/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.presentation.update;

import com.proyect.progra.proyectoprogra4.logic.Client;
import com.proyect.progra.proyectoprogra4.logic.Service;
import com.proyect.progra.proyectoprogra4.logic.User;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author leoch
 */
@WebServlet(name = "ControllerUpdate", urlPatterns = {"/presentation/update/show", "/presentation/update/update"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/update/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/update/update":
                viewUrl = this.update(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);

        User usuario = (User) session.getAttribute("usuario");
        Client cliente;
        try {
            cliente = service.clienteFind(usuario);
        } catch (Exception ex) {
            cliente = null;
        }
        try {
            model.setCliente(cliente);
            return "/presentation/update/View.jsp";
        } catch (Exception ex) {
            return "";
        }
    }

    public String update(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.updateAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/signup/View.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }

    public String updateAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        try {

            HttpSession session = request.getSession(true);

            User usuario = (User) session.getAttribute("usuario");
            
            model.getCliente().setCedula(usuario.getCedula());

            service.clienteUpdate(model.getCliente());
            return "/presentation/client/show";
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("nombreFld", "Datos incompletos");
            errores.put("telefonoFld", "Datos incompletos");
            errores.put("correoFld", "Datos incompletos");
            return "/presentation/update/View.jsp";
        }
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getCliente().setNombre(request.getParameter("nombreFld"));
        model.getCliente().setTelefono(request.getParameter("telefonoFld"));
        model.getCliente().setCorreo(request.getParameter("correoFld"));
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("nombreFld").isEmpty()) {
            errores.put("nombreFld", "Nombre requerido");
        }

        if (request.getParameter("telefonoFld").isEmpty()) {
            errores.put("telefonoFld", "Telefono requerida");
        }

        if (request.getParameter("correoFld").isEmpty()) {
            errores.put("correoFld", "Correo requerido");
        }
        return errores;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

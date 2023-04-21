/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.presentation.signup;

import com.proyect.progra.proyectoprogra4.logic.Client;
import com.proyect.progra.proyectoprogra4.logic.Service;
import com.proyect.progra.proyectoprogra4.logic.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author leoch
 */
@WebServlet(name = "ControllerSignup", urlPatterns = {"/presentation/signup/show","/presentation/signup/signup"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/signup/show":
                viewUrl = this.show(request);
                break;
                case "/presentation/signup/signup":
                viewUrl = this.signup(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getUsuario().setCedula("");
        model.getUsuario().setClave("");
        
        model.getCliente().setNombre("");
        model.getCliente().setCedula("");
        model.getCliente().setTarjeta(0);
        model.getCliente().setTelefono("");
        model.getCliente().setCorreo("");
        model.getCliente().setUsuario(model.getUsuario());
        return "/presentation/signup/View.jsp";
    }

    public String signup(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.signupAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/signup/View.jsp";
            }

        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }

    public String signupAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        try {
            User u = new User();
            u.setCedula(model.getUsuario().getCedula());
            u.setClave(model.getUsuario().getClave());
            service.userInsert(u);
            Client c = new Client();
            c.setNombre(model.getCliente().getNombre());
            c.setCedula(model.getCliente().getCedula());
            c.setTarjeta(model.getCliente().getTarjeta());
            c.setTelefono(model.getCliente().getTelefono());
            c.setCorreo(model.getCliente().getCorreo());
            c.setUsuario(service.usuarioFind(model.getUsuario().getCedula(), model.getUsuario().getCedula()));
            service.clienteInsert(c);
            return "/presentation/login/show";
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaFld", "Usuario o clave vacios");
            errores.put("claveFld", "Usuario o clave vacios");
            return "/presentation/signup/View.jsp";
        }
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getUsuario().setCedula(request.getParameter("cedulaFld"));
        model.getUsuario().setClave(request.getParameter("claveFld"));

        model.getCliente().setNombre(request.getParameter("nombreFld"));
        model.getCliente().setCedula(request.getParameter("cedulaFld1"));
        model.getCliente().setTarjeta(Integer.parseInt(request.getParameter("tarjetaFld")));
        model.getCliente().setTelefono(request.getParameter("telefonoFld"));
        model.getCliente().setCorreo(request.getParameter("correoFld"));
    }

    Map<String, String> validar(HttpServletRequest request) { //Solo los datos que no permiten null
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("cedulaFld").isEmpty()) {
            errores.put("cedulaFld", "Cedula requerida");
        }

        if (request.getParameter("claveFld").isEmpty()) {
            errores.put("claveFld", "Clave requerida");
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

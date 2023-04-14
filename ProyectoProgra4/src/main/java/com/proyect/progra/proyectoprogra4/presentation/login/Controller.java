/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.presentation.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.proyect.progra.proyectoprogra4.logic.Service;
import com.proyect.progra.proyectoprogra4.logic.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javir
 */
@WebServlet(name = "ControllerLogin", urlPatterns = {"presentation/loginClient/show", "presentation/loginAdmin/login,presentation/loginClient/login"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws jakarta.servlet.ServletException, IOException {
      
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "presentation/loginClient/show":
                viewUrl=this.show(request);
                break;              
            case "presentation/loginAdmin/login":
                viewUrl=this.login(request);
                break;            
            case "presentation/loginClient/login":
                viewUrl=this.logout(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }

    private String login(jakarta.servlet.http.HttpServletRequest request) { 
        try{
            Map<String,String> errores =  this.validar(request);
            if(errores.isEmpty()){
                this.updateModel(request);          
                return "";//this.loginAction(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/login/View.jsp"; 
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";             
        }         
    }
    
    Map<String,String> validar(jakarta.servlet.http.HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("cedulaFld").isEmpty()){
            errores.put("cedulaFld","Cedula requerida");
        }

        if (request.getParameter("claveFld").isEmpty()){
            errores.put("claveFld","Clave requerida");
        }
        return errores;
    }
    
    void updateModel(jakarta.servlet.http.HttpServletRequest request){
       Model model= (Model) request.getAttribute("model");
       
        model.getCurrent().setCedula(request.getParameter("cedulaFld"));
        model.getCurrent().setClave(request.getParameter("claveFld"));
   }

        
//    public String loginAction(jakarta.servlet.http.HttpServletRequest request) {
//        Model model= (Model) request.getAttribute("model");
//        Service  service = Service.instance();
//        HttpSession session = request.getSession(true);
//        try {
//            User real = service.usuarioFind(model.getCurrent().getCedula(),model.getCurrent().getClave());
//            session.setAttribute("usuario", real);
//            String viewUrl="";
//            switch(real.getTipo()){
//                case 1:
//                    viewUrl="/presentation/cliente/cuentas/show";
//                    break;
//                case 2:
//                     viewUrl="";
//                    break;             
//            }
//            return viewUrl;
//        } catch (Exception ex) {
//            Map<String,String> errores = new HashMap<>();
//            request.setAttribute("errores", errores);
//            errores.put("cedulaFld","Usuario o clave incorrectos");
//            errores.put("claveFld","Usuario o clave incorrectos");
//            return "/presentation/login/View.jsp"; 
//        }        
//    }   

    public String logout(jakarta.servlet.http.HttpServletRequest request){
        return this.logoutAction(request);
    }
    
    public String logoutAction(jakarta.servlet.http.HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/presentation/Index.jsp"; 
        //return "/presentation/login/show";
    }

    public String show(jakarta.servlet.http.HttpServletRequest request){
        return this.showAction(request);
    }
        
    public String showAction(jakarta.servlet.http.HttpServletRequest request){
        Model model= (Model) request.getAttribute("model");
        model.getCurrent().setCedula("");
        model.getCurrent().setClave("");
        return "/presentation/index.jsp"; 
    }    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (jakarta.servlet.ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (jakarta.servlet.ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

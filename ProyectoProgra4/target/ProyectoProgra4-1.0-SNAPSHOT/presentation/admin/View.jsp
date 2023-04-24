<%-- 
    Document   : View
    Created on : 20 Apr 2023, 16:27:38
    Author     : leoch
--%>


<%@page import="java.util.List"%>
<%@page import="com.proyect.progra.proyectoprogra4.logic.Client"%>
<%@page import="com.proyect.progra.proyectoprogra4.presentation.admin.Model"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Client> clientes = model.getClientes();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>
        <div style="margin-top: 150px;">
            <h1 style="color:rgb(255, 105, 45);" ><U>Listado de clientes del sistema</U></h1>  
            <table>
                <thead>
                <b><tr> <td>Nombre</td> <td>Cedula</td> <td>Tarjeta</td> <td>Telefono</td> <td>Correo</td> <td>Usuario</td></tr></b>
                </thead>
                <tbody>
                    <% for (Client c : clientes) {%>
                    <tr>
                        <td>
                            <%=c.getNombre() %>
                        </td>
                        <td>
                            <%=c.getCedula() %>
                        </td>
                        <td>
                            <%=c.getTarjeta() %>
                        </td>
                        <td>
                            <%=c.getTelefono() %>
                        </td>
                        <td>
                            <%=c.getCorreo() %>
                        </td>
                        <td>
                            <%=c.getUsuario().toString() %>
                        </td>
                    </tr>                    
                    <%}%>
                </tbody>
            </table>    
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>


<%-- 
    Document   : View
    Created on : 7 abr. 2023, 12:50:57
    Author     : javir
--%>
<%@page import="com.proyect.progra.proyectoprogra4.logic.Poliza"%>
<%@page import="com.proyect.progra.proyectoprogra4.presentation.client.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    Model model = (Model) request.getAttribute("model");
    List<Poliza> polizas = model.getPolizas();
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
            <h1 style="color:rgb(255, 105, 45);" ><U>Listado de Polizas del Cliente</U></h1>  
            <table>
                <thead>
                <b><tr> <td>Id Poliza</td> <td>Tipo de poliza</td> <td>Costo</td> <td>Placa</td></tr></b>
                </thead>
                <tbody>
                    <% for (Poliza p : polizas) {%>
                    <tr>
                        <td>
                            <%=p.getId()%>
                        </td>
                        <td>
                            <%=p.getNombre()%>
                        </td>
                        <td>
                            <%=p.getCosto()%>
                        </td>
                        <td>
                            <%=p.getPlaca()%>
                        </td>
                    </tr>                    
                    <%}%>
                </tbody>
            </table>    
        </div>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>

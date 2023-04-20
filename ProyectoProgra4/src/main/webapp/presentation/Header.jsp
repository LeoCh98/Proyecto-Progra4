<%-- 
    Document   : Header
    Created on : 15 Apr 2023, 15:55:30
    Author     : leoch
--%>
<%@page import="com.proyect.progra.proyectoprogra4.logic.User"%>
<% User usuario = (User) session.getAttribute("usuario");  %>

<header>
    <div class="logo">
        <img src="images/logo.png">
        <span> SafeCar </span>
    </div>
    <div class="menu">  
        <ul>
            <li>
                <a href="presentation/Index.jsp">Inicio</a>
            </li>
            <li>
                <a href="presentation/login/show">Acerca de...</a>
            </li>
            <% if (usuario == null) { %>
            <li>
                <a href="presentation/login/show">Login</a>
            </li>
            <% } %> 
            <% if (usuario != null) { %>
            <li>
                <a href="presentation/login/logout">Logout</a>
            </li>
            <% }%>
        </ul>
    </div>
</header>
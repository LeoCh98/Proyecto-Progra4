<%-- 
    Document   : Header
    Created on : 15 Apr 2023, 15:55:30
    Author     : leoch
--%>
<%@page import="com.proyect.progra.proyectoprogra4.logic.User"%>

<%
    User usuario = (User) session.getAttribute("usuario");
%>

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
            <% if (usuario == null) { %>
            <li>
                <a href="presentation/login/show">Login</a>
            </li>
            <li>
                <a href="presentation/signup/show">Registrarse</a>
            </li>
            <% } %> 
            <% if (usuario != null) { 
                if (usuario.getTipo() == 1) {
            %>
            <li>
                <a href="presentation/update/show"> Usuario: <% out.print(usuario.getCedula()); %> </a>
            </li>
            <li>
                <a href="presentation/client/show">Polizas</a>
            </li>
            <% }
                if (usuario.getTipo() == 0) {
            %>
            <li>
                <a href="presentation/update/show"> Admin: <% out.print(usuario.getCedula()); %> </a>
            </li>
            <% }%>
            <li>
                <a href="presentation/login/logout">Logout</a>
            </li>
            <% }%>
            <li>
                <a href="presentation/about_us.jsp">Acerca de...</a>
            </li>
        </ul>
    </div>
</header>
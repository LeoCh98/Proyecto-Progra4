<%-- 
    Document   : index
    Created on : 7 abr. 2023, 12:45:03
    Author     : javir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>
    <body>
        <header>      

        </header>
        <div id="datos">
            <br>
            <form action="presentation/loginClient/login" method="POST">
                <p id="sub">Username: </p>
                <br>
                <input id="txt" type="text" placeholder="Enter Username" name="user" required>
                <br>
                <p id="sub">Password: </p>
                <input id="txt" type="password" placeholder="Enter Password" name="pass" required>
                <br>
                <input id="loginButton" type="submit" name="login" value="Log In"/>
                <br>
            </form>
        </div>
        <footer>

        </footer>
    </body>
</html>

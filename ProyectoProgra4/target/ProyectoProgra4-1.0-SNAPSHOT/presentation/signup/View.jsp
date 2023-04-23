<%-- 
    Document   : View
    Created on : 20 Apr 2023, 23:49:50
    Author     : leoch
--%>

<%@page import="com.proyect.progra.proyectoprogra4.presentation.signup.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/presentation/Header.jsp" %>

        <% Model model = (Model) request.getAttribute("model"); %>
        <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
        <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>
        <form name="form" action="presentation/signup/signup" method="post" >

            <div class="panel" style="margin-top: 150px;">
                <div class="fila encabezado">Registrarse</div>
                <div class="fila">
                    <div class="etiqueta">Cedula</div>
                    <div class="campo"><input class="<%=erroneo("cedulaFld", errores)%>" placeholder="Cedula del usuario" type="text" name="cedulaFld" value="<%=form.get("cedulaFld")[0]%>" title="<%=title("cedulaFld", errores)%>"></div>
                </div>
                <div class="fila">
                    <div class="etiqueta">Clave</div>
                    <div class="campo"><input class="<%=erroneo("claveFld", errores)%>" placeholder="Clave del usuario" type="password" name="claveFld" value="<%=form.get("claveFld")[0]%>" title="<%=title("claveFld", errores)%>"></div>
                </div>
                <div class="fila">
                    <div class="etiqueta">Nombre</div>
                    <div class="campo"><input class="<%=erroneo("nombreFld", errores)%>" placeholder="Nombre del cliente" type="text" name="nombreFld" value="<%=form.get("nombreFld")[0]%>" title="<%=title("nombreFld", errores)%>"></div>
                </div>
                <div class="fila">
                    <div class="etiqueta">Cedula</div>
                    <div class="campo"><input class="<%=erroneo("cedulaFld1", errores)%>" placeholder="Cedula del cliente" type="text" name="cedulaFld1" value="<%=form.get("cedulaFld1")[0]%>" title="<%=title("cedulaFld1", errores)%>"></div>
                </div>
                <div class="fila">
                    <div class="etiqueta">Tarjeta</div>
                    <input style ="margin-left: 5px;" class="<%=erroneo("tarjetaFld", errores)%>" placeholder="Numero de tarjeta" type="text" name="tarjetaFld" title="<%=title("tarjetaFld", errores)%>">
                </div>
                <div class="fila">
                    <div class="etiqueta">Telefono</div>
                    <div class="campo"><input class="<%=erroneo("telefonoFld", errores)%>" placeholder="Telefono celular" type="text" name="telefonoFld" value="<%=form.get("telefonoFld")[0]%>" title="<%=title("telefonoFld", errores)%>"></div>
                </div>
                <div class="fila">
                    <div class="etiqueta">Correo</div>
                    <div class="campo"><input class="<%=erroneo("correoFld", errores)%>" placeholder="Correo electronico" type="text" name="correoFld" value="<%=form.get("correoFld")[0]%>" title="<%=title("correoFld", errores)%>"></div>
                </div>
                <div class="fila encabezado"><button  style="margin-bottom: 15px">Registrar</button> </div>
            </div>
        </form>
        <%@ include file="/presentation/Footer.jsp" %>
    </body>
</html>
<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "is-invalid";
        } else {
            return "";
        }
    }

    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }

    private Map<String, String[]> getForm(Model model) {
        Map<String, String[]> values = new HashMap<>();
        values.put("cedulaFld", new String[]{model.getUsuario().getCedula()});
        values.put("claveFld", new String[]{model.getUsuario().getClave()});

        values.put("nombreFld", new String[]{model.getCliente().getNombre()});
        values.put("cedulaFld1", new String[]{model.getCliente().getCedula()});
        String[] array = new String[]{String.valueOf(model.getCliente().getTarjeta())};
        values.put("tarjetaFld", array);
        values.put("telefonoFld", new String[]{model.getCliente().getTelefono()});
        values.put("correoFld", new String[]{model.getCliente().getCorreo()});

        return values;
    }
%>
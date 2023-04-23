<%-- 
    Document   : View
    Created on : 21 Apr 2023, 19:35:12
    Author     : leoch
--%>

<%@page import="com.proyect.progra.proyectoprogra4.presentation.update.Model"%>
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

        <form name="form" action="presentation/update/update" method="post" >
            <div class="panel" style="margin-top: 250px;">
                <div class="fila encabezado">Modificar datos:</div>
                <div class="fila">
                    <div class="etiqueta">Nuevo nombre</div>
                    <div class="campo"><input class="<%=erroneo("nombreFld", errores)%>" placeholder="Nombre" type="text" name="nombreFld" value="<%=form.get("nombreFld")[0]%>" title="<%=title("nombreFld", errores)%>"></div>
                </div>
                <div class="fila">
                    <div class="etiqueta">Nuevo Telefono</div>
                    <div class="campo"><input class="<%=erroneo("telefonoFld", errores)%>" placeholder="Telefono" type="text" name="telefonoFld" value="<%=form.get("telefonoFld")[0]%>" title="<%=title("telefonoFld", errores)%>"></div>
                </div>
                <div class="fila">
                    <div class="etiqueta">Nuevo Correo</div>
                    <div class="campo"><input class="<%=erroneo("correoFld", errores)%>" placeholder="Correo" type="text" name="correoFld" value="<%=form.get("correoFld")[0]%>" title="<%=title("correoFld", errores)%>"></div>
                </div>
                <div class="fila encabezado"><button style="margin-bottom: 15px">Guardar</button> </div>
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
        values.put("nombreFld", new String[]{model.getCliente().getNombre()});
        values.put("telefonoFld", new String[]{model.getCliente().getTelefono()});
        values.put("correoFld", new String[]{model.getCliente().getCorreo()});
        return values;
    }
%>
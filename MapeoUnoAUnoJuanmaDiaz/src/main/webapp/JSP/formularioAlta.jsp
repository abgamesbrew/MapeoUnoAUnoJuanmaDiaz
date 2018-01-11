<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contexto" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel="stylesheet" type="text/css" href="${contexto}/CSS/estilo.css" />
    </head>
    <body>

        <div id="principal" style="text-align: center;">
            <h2>Actualizaci&oacute;n de datos</h2>
        <form method="post" action="control?op=add">
            <h1>Puerto</h1> 
            <table>
                <tr>
                    <td>Numero</td>
                    <td><input type="text" name="numero" required/></td>
                </tr>
                <tr>
                    <td>Tipo</td>
                    <td><input type="text" name="tipo"  required/></td>
                </tr>
            </table>
            <br>
            <h1>Servicio</h1>
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" required/></td>
                </tr>
                <tr>
                    <td>path</td>
                    <td><input type="text" name="path"  required/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                </tr>
            </table>
        </form>
        </div>


    </body>
</html>
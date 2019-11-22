<%-- 
    Document   : lista_bbdd
    Created on : 22-nov-2019, 11:24:13
    Author     : pc
--%>

<%@page import="com.vn.appweb.modelo.ConsultaSQL"%>
<%@page import="java.util.List"%>
<%@page import="com.vn.appweb.modelo.DatosPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado JSP con DerbyDB</title>
    </head>
    <body>
        <h1>Listado JSP con DerbyDB</h1>
        <%
            out.println("<p>Hola desde Java en URL " + request.getContextPath() + "</p>");
        %>
        <br>
        <ul>
            <%
                for (int i = 0; i < 3; i++) {
            %>    
            <li> Número <%= i%> </li>
            <%  }
            ConsultaSQL conSQL = new ConsultaSQL();
            String nombreBusq = request.getParameter("nombre_busq");
            List<DatosPersona> listaPer = conSQL.leerTabla(nombreBusq);
            %>        
        </ul>

        <form name="formBusq" method="GET" action="./lista_bbdd.jsp">
            <input name="nombre_busq" type="text" placeholder="Introduzca la busqueda..." size="40"/>
            <input type="submit" value="Buscar"/>
        </form>
        
        <table>
            <thead>
            <th>Nombre</th><th>email</th>
        </thead>
        <%      for (DatosPersona dp : listaPer ) {  %>
        <tr>
            <td><%= dp.getNombre() %></td><td><%= dp.getEmail()%></td>
        </tr>
        <% } %>
    </table>

</body>
</html>

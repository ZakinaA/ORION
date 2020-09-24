<%-- 
    Document   : categVenteConsulter
    Created on : 24 sept. 2020, 14:46:37
    Author     : sio2
--%>

<%@page import="modele.CategVente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Infos categorie de vente</h1>
        
         <%
        CategVente unCategVente = (CategVente)request.getAttribute("pCategVente");
        %>
        
        
         <table class="table table-bordered table-striped table-condensed">
            <tr><td>Code :</td><td><% out.println(unCategVente.getCode());%></td></tr>
            <tr><td>Libelle :</td><td><%  out.println(unCategVente.getLibelle());%></td>  </tr>
        </table>
        
    </body>
</html>

<%-- 
    Document   : chevalModifier
    Created on : 1 oct. 2020, 16:33:09
    Author     : sio2
--%>

<%@page import="modele.Cheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulter Cheval</title>
    </head>
    <body>
        <h1>Infos cheval</h1>
        
         <%
        Cheval unCheval = (Cheval)request.getAttribute("pCheval");
        %>
        
        
         <table class="table table-bordered table-striped table-condensed">
            <tr><td>Nom :</td><td><%  out.println(unCheval.getNom());%></td></tr>
            <tr><td>Sexe :</td><td><%  out.println(unCheval.getSexe());%></td></tr>
            <tr><td>Numero Sire :</td><td><%  out.println(unCheval.getNumSire());%></td></tr>
        </table>
        
    </body>
</html>

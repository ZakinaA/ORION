<%-- 
    Document   : chevalConsulter
    Created on : 29 sept. 2020, 08:25:46
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
        
        
         <%
        Cheval unCheval = (Cheval)request.getAttribute("pCheval");
        %>
        
        <%--
         <table class="table table-bordered table-striped table-condensed">
            <tr><td>Nom :</td><td><%  out.println(unCheval.getNom());%></td></tr>
            <tr><td>Sexe :</td><td><%  out.println(unCheval.getSexe());%></td></tr>
            <tr><td>Numero Sire :</td><td><%  out.println(unCheval.getNumSire());%></td></tr>
        </table>
        --%>
    
    <center>
        <h2>Information sur le cheval <%  out.println(unCheval.getNom());%></h2>
        <p>
            Son numéro d'identification (Sire) est le <%  out.println(unCheval.getNumSire());%>
        </p>
        <p>
            C'est un <%  out.println(unCheval.getSexe());%> de race <%  out.println(unCheval.getUnTypeCheval().getLibelle());%>
        </p>
    </center>
    </body>
</html>

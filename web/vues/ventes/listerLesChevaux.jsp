<%-- 
    Document   : listerLesChevaux
    Created on : 17 sept. 2020, 13:49:06
    Author     : sio2
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modele.Cheval"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <%
        ArrayList<Cheval> lesChevaux = (ArrayList)request.getAttribute("pLesChevaux");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>Nom</th>
                    <th>Sexe</th>
                    <th>Numero Sire</th>
                    <th>Prix de Depart</th>     
            <br>
            <br>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesChevaux.size();i++)
                    {
                        
                        Cheval unCheval = lesChevaux.get(i);
                        out.println("<tr><td>");
                        out.println(unCheval.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unCheval.getNom());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unCheval.getSexe());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(unCheval.getNumSire());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unCheval.getUnTypeCheval());
                        out.println("</td>");
                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>

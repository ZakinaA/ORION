<%-- 
    Document   : listerLesLots
    Created on : 22 sept. 2020, 08:49:21
    Author     : sio2
--%>

<%@page import="modele.Lot"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    </head>
    <body>
        <h1>LISTE DES VENTES</h1>
         <%
        ArrayList<Lot> lesLots = (ArrayList)request.getAttribute("pLesLots");
        %>
        <table  class="table table-bordered table-striped table-condensed">  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>Prix de depart</th> 
                    <th>Nom du cheval</th>
            <br>
            <br>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                    for(int i = 0; i < lesLots.size();i++)
                    {
                        
                        Lot unLot = lesLots.get(i);
                        out.println("<tr><td>");
                        out.println(unLot.getId());
                        out.println("</a></td>");

                        out.println("<td>");
                        out.println(unLot.getPrixDepart());
                        out.println("</td>");
                        
                        out.println("<td>");
                        out.println(unLot.getUnCheval().getNom());
                        out.println("</td>");
                        
                        /*out.println("<td><a href ='../ServletVentes/listerLesChevaux?codeLot="+ unLot.getId()+ "'>");
                        out.println("Lister les chevaux");
                        out.println("</td>");
                        */
                    }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>

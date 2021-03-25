<%-- 
    Document   : consulterVente
    Created on : 5 nov. 2020, 15:19:19
    Author     : sio2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Ajouter Vente</title>
    </head>
    <body>
         <h1>Infos Vente</h1>
        
         <%
        Vente uneVente = (Vente)request.getAttribute("pVente");
        %>
        
        
         <table class="table table-bordered table-striped table-condensed">
            
            <tr><td>NOM :</td><td><%  out.println(uneVente.getNom());%></td>  </tr>
            <tr><td>DATE DEBUT  :</td><td><%  out.println(uneVente.getDateDebutVente());%></td>  </tr>
            <tr><td>CATEGORIE VENTE  :</td><td><%  out.println(uneVente.getUneCategVente().getLibelle());%></td>  </tr>
            <tr><td>LIEU  :</td><td><%  out.println(uneVente.getUnLieux().getVille());%></td>  </tr>

              </td></tr>
        </table>
    </body>
</html>

<%-- 
    Document   : chevalAjouter
    Created on : 29 sept. 2020, 08:25:36
    Author     : sio2
--%>

<%@page import="modele.TypeCheval"%>
<%@page import="java.util.ArrayList"%>
<%@page import="formulaires.ChevalForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un cheval</title>
    </head>
    <body>
        <h1>Inscription Cheval</h1>
        
         <%
                ChevalForm form = (ChevalForm)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouterCheval" method="POST">
                <label for="nom">Nom : </label>
                <input id="nom"  type="text"  name="nom" size="30" maxlength="30">      
                </br>
                <label for="sexe">Sexe : </label>
                <input id="sexe"  type="text"  name="sexe" size="30" maxlength="30">      
                </br>
                <label for="numSire">Numero Sire : </label>
                <input id="sire"  type="text"  name="numSire" size="30" maxlength="30">      
                </br>
                
                <label for="typecheval">Type de Cheval : </label>
                <select class="form-control" id="idTypeCheval" name ="typecheval">
                    <%
                        ArrayList<TypeCheval> lesTypeChevaux = (ArrayList)request.getAttribute("pLesTypeCheval");
                        for (int i=0; i<lesTypeChevaux.size();i++){
                            TypeCheval tc = lesTypeChevaux.get(i);
                            out.println("<option value='" + tc.getId()+"'>" + tc.getLibelle()+"</option>" );
                        } 
                    %>
                </select>
                </br>
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
        
    </body>
</html>

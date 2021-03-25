<%-- 
    Document   : ajouterVente
    Created on : 5 nov. 2020, 15:19:10
    Author     : sio2
--%>
<%@page import="formulaires.VenteForm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.CategVente"%>
<%@page import="modele.Lieux"%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Ajouter vente</title>
    </head>
    <body>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Equida</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="../index.html">Accueil <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../ServletVentes/listerLesVentes">Lister les ventes</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Ajouter
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="../ServletClient/ajouterClient">Ajouter Client</a>
          <a class="dropdown-item" href="../ServletCheval/ajouterCheval">Ajouter Cheval</a>
          <a class="dropdown-item" href="../ServletAdmin/ajouterTypeCheval">Ajouter Type Cheval</a>
          <a class="dropdown-item" href="../ServletAdmin/ajouterCategVente">Ajouter Catégorie</a>
          <a class="dropdown-item" href="../ServletAdmin/ajouterPays">Ajouter Pays</a>
          <a class="dropdown-item" href="../ServletAdmin/ajouterLieux">Ajouter Lieux</a>
        </div>
      </li>
    </ul>
    
  </div>
</nav>
        <br>
         <div class="container">
        <h1>Inscription Vente</h1>
       </br>
       
         <%
                VenteForm form = (VenteForm)request.getAttribute("form");
            %>
        
        <form class="form-group" action="ajouterVente" method="POST">
                <label for="id">Id : </label>
                <input class="form-control" id="id"  type="text"  name="id" size="30" maxlength="30">      
                </br>
                <label for="nom">Nom : </label>
                <input class="form-control" id="nom"  type="text"  name="nom" size="30" maxlength="30">      
                </br>
                <label for="dateDebut">Date de debut : </label>
                <input class="form-control" id="dateDebut"  type="date"  name="dateDebut" size="30" maxlength="30">      
                </br>
                
                <label for="categVente">Categorie de vente : </label>
                <select class="form-control"  name ="categVente" size="5">
                    <%
                        ArrayList<CategVente> uneCategVente = (ArrayList)request.getAttribute("pLesCategVentes");
                        for (int i=0; i<uneCategVente.size();i++){
                            CategVente cv = uneCategVente.get(i);
                            out.println("<option value ='" + cv.getCode() + "'>" + cv.getLibelle() + "</option>"); 
                           
                        } 
                    %>
                </select>  
                
         <%--   <label for="categVente">Categorie de vente : </label>
                <select class="form-control" name="categVente" size="5" >
                <%
                        ArrayList<CategVente> uneCategVente = (ArrayList)request.getAttribute("pLesCategVentes");
                        for (int i=0; i<uneCategVente.size();i++){
                            CategVente p = uneCategVente.get(i);
                            out.println("<option value ='" + p.getCode() + "'>" + p.getLibelle() + "</option>"); 
                           
                        }
                    %>
                </select>--%>
                    <!-- </select></br> -->
                   
               
                </br>
                <label for="lieux">Lieux de vente : </label>
                <select class="form-control" name="lieux" size="5" multiple>
                <%
                        ArrayList<Lieux> lesLieux = (ArrayList)request.getAttribute("pLesLieux");
                        for (int i=0; i<lesLieux.size();i++){
                            Lieux l= lesLieux.get(i);
                            out.println("<option value ='" + l.getId() + "'>" + l.getVille() + "</option>"); 
                        }
                    %>
                </select>
                </br>
            <input type="submit" name="valider" id="valider" value="Valider"/>
        </form>
       </div>
    </body>
</html>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>


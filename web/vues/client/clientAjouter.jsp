<%-- 
    Document   : ClientAjouter
    Created on : 22/06, 16:35:27
    Author     : Zakina
--%>

<%@page import="modele.CategVente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Pays"%>
<%@page import="formulaires.ClientForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Client Ajouter</title>
        
        
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
      <form class="form-inline my-2 my-lg-0">
          <ul class="form-inline my-2 my-lg-0">
              <a type="button" class="btn btn-outline-primary" href="inscription.html">S'inscrire </a> &nbsp;
              <a type="button" class="btn btn-outline-success" href="connexion.html">Connexion </a>
          </ul>
      </form>
  </div>
</nav>
         <div class="container">
        <h1>Nouveau client</h1>
        
         <%
                //Client client=(Client)request.getAttribute("client");
                ClientForm form = (ClientForm)request.getAttribute("form");
            %>
           
        <form class="form-group" action="ajouterClient" method="POST">
                <label for="nom">NOM : </label>
                <input class="form-control" id="nom" type="text" name="nom"  size="30" maxlength="30">
                </br>
                
                <label for="prenom">PRENOM : </label>
                <input class="form-control" id="prenom"  type="text"  name="prenom" size="30" maxlength="30">      
                 </br>
                
                <label for="rue">rue : </label>
                <input class="form-control" id="rue"  type="text"  name="rue" size="30" maxlength="50">
                 </br>
                               
                
                <label for="copos">Code postal : </label>
                <input class="form-control" id="copos"  type="text"  name="copos" size="5" maxlength="5">
                </br>
                
                <label for="ville">Ville : </label>
                <input class="form-control" id="ville"  type="text"  name="ville" size="40" maxlength="40">
                </br>
                
                <label for="mail">Mail : </label>
                <input class="form-control" id="mail"  type="text"  name="mail" size="40" maxlength="40">
                </br>
                
                <%-- Champ Liste des pays --%>
                <label for="pays">Pays : </label>
                <select class="form-control" id="codePays" name ="pays">
s
                    <%
                        ArrayList<Pays> lesPays = (ArrayList)request.getAttribute("pLesPays");
                        for (int i=0; i<lesPays.size();i++){
                            Pays p = lesPays.get(i);
                            out.println("<option value='" + p.getCode()+"'>" + p.getNom()+"</option>" );
                        } 
                    %>
                </select>
                </br>            
                
                <label for="categVente">Categorie Vente : </label><br>
                <!--<select class="form-control" id="categVente" name ="categVente"> -->
                <%
                        ArrayList<CategVente> lesCategVente = (ArrayList)request.getAttribute("pLesCategVente");
                        for (int i=0; i<lesCategVente.size();i++){
                            CategVente cv = lesCategVente.get(i);
                            //out.println("<option value ='" + cv.getCode() + "'>" + cv.getLibelle() + "</option>"); 
                            out.println("<input type='checkbox' id='cb" + i + "' name='categVente' value='" + cv.getCode() + "'>" + cv.getLibelle()); 
                            //out.println(cv.getLibelle()); 
                            out.println("</label></br>");
                        }
                    %>
                    <!-- </select></br> -->
                   
               
               
                
                <%-- Cases à cocher permettant de choisir les différentes catégories de vente auxquelles le client souhaite s'inscrire 
                <label for="categVente">Categories de vente : </label></br>
                 <%
                        ArrayList<CategVente> lesCategVente = (ArrayList)request.getAttribute("pLesCategVente");
                        for (int i=0; i<lesCategVente.size();i++){
                            CategVente cv = lesCategVente.get(i);
                            
                        }
                    %>
                    </br>
                    --%>
                 
                
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
         </div>
    </body>
</html>

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

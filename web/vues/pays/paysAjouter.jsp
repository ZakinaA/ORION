<%-- 
    Document   : paysAjouter
    Created on : 15 oct. 2020, 09:02:15
    Author     : sio2
--%>

<%@page import="formulaires.PaysForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Ajout d'un pays</title>
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
        </div>
      </li>
    </ul>
    
  </div>
  
</nav>
       </br>
       <div class="container">
           <h1>Inscription Pays</h1>
       </br>
       
         <%
                PaysForm form = (PaysForm)request.getAttribute("form");
            %>
        
        <form class="form-group" action="ajouterPays" method="POST">
                <label for="code">code : </label>
                <input class="form-control" id="code"  type="text"  name="code" size="3" maxlength="3">      
                </br>
                <label for="nom">nom : </label>
                <input class="form-control" id="nom"  type="text"  name="nom" size="30" maxlength="30">      
                </br>
            <input type="submit" name="valider" id="valider" value="Valider"/>
        </form>
       </div>
    </body>
</html>

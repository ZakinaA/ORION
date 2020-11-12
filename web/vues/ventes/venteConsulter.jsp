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
      <form class="form-inline my-2 my-lg-0">
          <ul class="form-inline my-2 my-lg-0">
              <a type="button" class="btn btn-outline-primary" href="../inscription.html">S'inscrire </a> &nbsp;
              <a type="button" class="btn btn-outline-success" href="../connexion.html">Connexion </a>
          </ul>
      </form>
  </div>
</nav>
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

<%-- 
    Document   : CalendrierVentes
    Created on : 15 oct. 2020, 11:10:57
    Author     : sio2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="java.util.ArrayList"%>
        <%@page import="modele.Vente"%>
        <%@page import="modele.Lieux"%>
        <%@page import="modele.CategVente"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="../css/calendrier.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>Calendrier des Ventes</title>
    </head>
    <body>
        <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">
      <img src="../img/Logo2.png" alt="logo cheval" height="30" width="30">
          Equida</a>
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
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ajouter</a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="../ServletClient/ajouterClient">Ajouter Client</a>
          <a class="dropdown-item" href="../ServletCheval/ajouterCheval">Ajouter Cheval</a>
          <a class="dropdown-item" href="../ServletAdmin/ajouterCategVente">Ajouter Catégorie</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
        
        <!-- Début Contenu -->
        
        <h1>Calendrier des Ventes</h1>

        <%
        ArrayList<Vente> lesVentes = (ArrayList)request.getAttribute("pLesVentes");
        %>
        
	<div class="container">
            
            <% for(int i = 0; i < lesVentes.size();i++)
                    {
                        
                        Vente uneVente = lesVentes.get(i);
                        Integer mois = Integer.parseInt(uneVente.getDateDebutVente().substring(5,7));
                        String moisString;
                        
                        switch (mois) {
            case 1:  moisString = "Janvier";
                     break;
            case 2:  moisString = "Février";
                     break;
            case 3:  moisString = "Mars";
                     break;
            case 4:  moisString = "Avril";
                     break;
            case 5:  moisString = "Mai";
                     break;
            case 6:  moisString = "Juin";
                     break;
            case 7:  moisString = "Juillet";
                     break;
            case 8:  moisString = "Août";
                     break;
            case 9:  moisString = "Septembre";
                     break;
            case 10: moisString = "Octobre";
                     break;
            case 11: moisString = "Novembre";
                     break;
            case 12: moisString = "Décembre";
                     break;
            default: moisString = "-erreur-";
                     break;
        }

            %>
		<div class="row row-striped">
			<div class="col-2 text-right">
				<h1 class="display-4"><span class="badge badge-secondary"><%out.println(uneVente.getDateDebutVente().substring(8,10));%></span></h1>
			</div>  <!-- Afficher toutes les ventes à venir-->
			<div class="col-10">
				<h3 class="text-uppercase"><strong><%out.println(uneVente.getNom());%></strong></h3>
				<ul class="list-inline">
				    <li class="list-inline-item"><i class="fa fa-calendar-o" aria-hidden="true"></i> Monday</li>
					<li class="list-inline-item"><i class="fa fa-caret-square-o-right" aria-hidden="true"></i> <%out.println(uneVente.getUneCategVente().getLibelle());%></li>
					<li class="list-inline-item"><i class="fa fa-location-arrow" aria-hidden="true"></i> <%out.println(uneVente.getUnLieu().getVille());%></li>
				</ul>
				<h2><%out.println(uneVente.getDateDebutVente().substring(0,4) + " " + moisString);%></h2>
			</div>
		</div>
            <% } %>
	</div>
	
        <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
    </body>
</html>
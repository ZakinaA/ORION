/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.CategVenteDAO;
import database.PaysDAO;
import database.TypeChevalDAO;
import formulaires.CategVenteForm;
import formulaires.PaysForm;
import formulaires.TypeChevalForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.CategVente;
import modele.Pays;
import modele.TypeCheval;

/**
 *
 * @author sio2
 */
public class ServletAdmin extends HttpServlet {
    
    Connection connection ;
      
        
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        connection=(Connection)servletContext.getAttribute("connection");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = request.getRequestURI();
        if(url.equals("/Orion/ServletAdmin/ajouterCategVente")){
       // processRequest(request, response);                   
            this.getServletContext().getRequestDispatcher("/vues/categ/categVenteAjouter.jsp" ).forward( request, response );
        }
        
        if(url.equals("/Orion/ServletAdmin/ajouterTypeCheval")){
            this.getServletContext().getRequestDispatcher("/vues/cheval/typeChevalAjouter.jsp" ).forward( request, response );
        }
        
        if(url.equals("/Orion/ServletAdmin/ajouterPays")){
            this.getServletContext().getRequestDispatcher("/vues/pays/paysAjouter.jsp" ).forward( request, response );
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();
        if(url.equals("/Orion/ServletAdmin/ajouterCategVente")){     
            /* Préparation de l'objet formulaire */
            CategVenteForm form = new CategVenteForm();
		
            /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
            CategVente unCategVente = form.ajouterCategVente(request);
        
            /* Stockage du formulaire et de l'objet dans l'objet request */
            request.setAttribute( "form", form );
            request.setAttribute( "pCategVente", unCategVente );
		
            if (form.getErreurs().isEmpty()){
                // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client
                CategVente categTest = CategVenteDAO.ajouterCategVente(connection, unCategVente);
                if ( categTest != null ){
                    request.setAttribute( "pCategVente", categTest );
                    this.getServletContext().getRequestDispatcher("/vues/categ/categVenteConsulter.jsp" ).forward( request, response );
                }
                else{
                    this.getServletContext().getRequestDispatcher("/vues/categ/categVenteAjouter.jsp" ).forward( request, response );
                }
            }
        }
        
        if(url.equals("/Orion/ServletAdmin/ajouterTypeCheval")){
            
           // System.out.println("t111111111111111");
            TypeChevalForm form = new TypeChevalForm();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        TypeCheval unTypeCheval = form.ajouterTypeCheval(request);
        //System.out.println("testuuuuuuuu");
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pTypeCheval", unTypeCheval );
		
            if (form.getErreurs().isEmpty()){
            // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
                TypeChevalDAO.ajouterTypeCheval(connection, unTypeCheval);
                this.getServletContext().getRequestDispatcher("/vues/cheval/typeChevalConsulter.jsp" ).forward( request, response );
            }
        }
        
        if(url.equals("/Orion/ServletAdmin/ajouterPays")){
            
           // System.out.println("t111111111111111");
            PaysForm form = new PaysForm();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Pays unPays = form.ajouterPays(request);
        //System.out.println("testuuuuuuuu");
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pPays", unPays );
		
            if (form.getErreurs().isEmpty()){
            // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
                Pays paysTest = PaysDAO.ajouterPays(connection, unPays);
                if ( paysTest != null ){
                    request.setAttribute( "pPays", paysTest );
                    this.getServletContext().getRequestDispatcher("/vues/pays/paysConsulter.jsp" ).forward( request, response );
                }
                else{
                    this.getServletContext().getRequestDispatcher("/vues/pays/paysAjouter.jsp" ).forward( request, response );
                }
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

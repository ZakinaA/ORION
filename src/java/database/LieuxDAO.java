/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Lieux;

/**
 *
 * @author sio2
 */
public class LieuxDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Lieux>  getLesLieux(Connection connection){      
        ArrayList<Lieux> lesLieux = new  ArrayList<Lieux>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from lieu");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Lieux unLieu = new Lieux();
                unLieu.setId(rs.getInt("id"));
                unLieu.setVille(rs.getString("ville"));
                unLieu.setNbBoxe(rs.getString("nbBoxes"));
                unLieu.setCommentaire(rs.getString("commentaire"));
                
                lesLieux.add(unLieu);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesLieux ;    
    } 
     
     public static Lieux ajouterLieux(Connection connection, Lieux unLieu){
        int idGenere = -1;
        try
        {
           
            requete=connection.prepareStatement("INSERT INTO lieu (ville, nbBoxes, commentaire)\n" +
                    "VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS);
            requete.setString(1, unLieu.getVille());
            requete.setString(2, unLieu.getNbBoxe());
            requete.setString(3, unLieu.getCommentaire());
            System.out.println(requete + " Test de requete !!!!  ");
            /* Exécution de la requête */
            int resultatREQ = requete.executeUpdate();
            System.out.println(resultatREQ + " RESDHCXSB ");
            if (resultatREQ == 1){
                
                rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unLieu.setId(idGenere);
            } 
            System.out.println("ID dans ajouterLieu + ID CHEVAL"+ unLieu.getId());
                unLieu = getRecupLieux(connection, unLieu.getId());
            }
            else{
                unLieu = null;
            }   
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            unLieu = null;
            System.out.println("Erreur lors de l’établissement de la connexion");
        }
        return unLieu ;    
    }
     public static Lieux getRecupLieux(Connection connection, int idGenere){
         Lieux unLieu = new Lieux();
        try{
            
            
            requete=connection.prepareStatement("SELECT l.* FROM lieu l WHERE l.id = ?");
            requete.setInt(1, idGenere);
            rs=requete.executeQuery();
            
            //System.out.println("reqqqq  " +  requete);
            while ( rs.next() ) {  
                //unCheval.setId(rs.getInt("id"));
                unLieu.setVille(rs.getString("ville"));
                unLieu.setNbBoxe(rs.getString("nbBoxes"));
                unLieu.setCommentaire(rs.getString("commentaire"));
                //System.out.println("LIBBBB dans getRecupCheval"+ unCheval.getUnTypeCheval().getLibelle());
            }
            System.out.println(unLieu);
         }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unLieu;
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.ClientDAO.requete;
import static database.ClientDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Cheval;

/**
 *
 * @author sio2
 */
public class ChevalDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    /* public static ArrayList<Cheval>  getCheval(Connection connection){ 
        
        ArrayList<Cheval> lesChevaux = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from cheval");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Cheval unCheval = new Cheval();
                //unCheval.setId(rs.getInt("id"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                unCheval.setNumSire(rs.getString("numSire"));
                lesChevaux.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesChevaux ;    
    } */
     
     public static Cheval ajouterCheval(Connection connection, Cheval unCheval){
        int idGenere = -1;
        
          //System.out.println("cheval DAO");
        try
        {
             //System.out.println("TRY ");
            //System.out.println("connection" + connection.toString());
            requete=connection.prepareStatement("INSERT INTO cheval (nom, sexe, numSire, idTypeCheval)\n" +
                    "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS);
            //requete.setInt(1, unCheval.getId());
            requete.setString(1, unCheval.getNom());
            requete.setString(2, unCheval.getSexe());
            requete.setString(3, unCheval.getNumSire());
            requete.setInt(4, 1);
            System.out.println(requete);
            /*
            requete.setInt(1, 9);
            requete.setString(2, "dfs");
            requete.setString(3, "M");
            requete.setString(4, "12121");
            requete.setInt(5, 1);
            */
            
            //Exécution de la requête 
            requete.executeUpdate();
            
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unCheval.setId(idGenere);
            }
            System.out.println(requete);
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval ;    
    }
     
     public static Cheval modifierCheval(Connection connection, Cheval unCheval){
        int idGenere = -1;
        
          //System.out.println("cheval DAO");
        try
        {
             //System.out.println("TRY ");
            //System.out.println("connection" + connection.toString());
            requete=connection.prepareStatement("UPDATE cheval (nom, sexe, numSire, idTypeCheval)\n" +
                    "VALUES (?,?,?,?) where id = ?");
            //requete.setInt(1, unCheval.getId());
            requete.setString(1, unCheval.getNom());
            requete.setString(2, unCheval.getSexe());
            requete.setString(3, unCheval.getNumSire());
            requete.setInt(4, 1);
            System.out.println(requete);
            /*
            requete.setInt(1, 9);
            requete.setString(2, "dfs");
            requete.setString(3, "M");
            requete.setString(4, "12121");
            requete.setInt(5, 1);
            */
            
            //Exécution de la requête 
            requete.executeUpdate();
            
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unCheval.setId(idGenere);
            }
            System.out.println(requete);
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval ;    
    }
}

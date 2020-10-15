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
import modele.Pays;

/**
 *
 * @author Zakina
 */
public class PaysDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Pays>  getLesPays(Connection connection){      
        ArrayList<Pays> lesPays = new  ArrayList<Pays>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from pays");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Pays unPays = new Pays();
                unPays.setCode(rs.getString("code"));
                unPays.setNom(rs.getString("nom"));
                lesPays.add(unPays);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesPays ;    
    } 
     
     public static Pays ajouterPays(Connection connection, Pays unTypeCheval){
        
          //System.out.println("TypeCheval DAO");
        try
        {
                //System.out.println("TRY ");
                //System.out.println("connection ! " + connection.toString());
            requete=connection.prepareStatement("INSERT INTO pays (code, nom)\n" +
                    "VALUES (?,?)");
            //requete.setInt(1, unCheval.getId());
            requete.setString(1, unTypeCheval.getCode());
            requete.setString(2, unTypeCheval.getNom());
                //System.out.println(requete.toString());
            //Exécution de la requête 
            requete.executeUpdate();
            //System.out.println(requete + "La requete");
            System.out.println(requete);
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unTypeCheval ;    
    }
    
}

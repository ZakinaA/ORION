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
     
     public static Pays ajouterPays(Connection connection, Pays unPays){
        
          //System.out.println("TypeCheval DAO");
        try
        {
                //System.out.println("TRY ");
                //System.out.println("connection ! " + connection.toString());
            requete=connection.prepareStatement("INSERT INTO pays (code, nom)\n" +
                    "VALUES (?,?)");
            //requete.setInt(1, unCheval.getId());
            requete.setString(1, unPays.getCode());
            requete.setString(2, unPays.getNom());
            //System.out.println(requete.toString());
            
            //System.out.println(requete + "La requete");
            int resultatREQ = requete.executeUpdate();
            //System.out.println(resultatREQ + " RESDHCXSB ");
            if (resultatREQ == 1){
                unPays = getRecupPays(connection);
            }
            else{
                unPays = null;
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            unPays = null;
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unPays ;    
    }
     
     public static Pays getRecupPays(Connection connection){
         Pays unPays = new Pays();
        try{
            
            
            requete=connection.prepareStatement("SELECT p.* FROM pays p WHERE c.code = ?");
            rs=requete.executeQuery();
            
            //System.out.println("reqqqq  " +  requete);
            while ( rs.next() ) {  
                //unCheval.setId(rs.getInt("id"));
                unPays.setCode(rs.getString("code"));
                unPays.setNom(rs.getString("nom"));              
                //System.out.println("LIBBBB dans getRecupCheval"+ unCheval.getUnTypeCheval().getLibelle());
            }
            System.out.println(unPays);
         }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unPays;
     }
}

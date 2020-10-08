/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.ClientDAO.requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.CategVente;
import modele.Client;
/**
 *
 * @author Zakina
 */
public class CategVenteDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<CategVente>  getLesCategVentes(Connection connection){      
        ArrayList<CategVente> lesCategVentes = new  ArrayList<CategVente>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from categvente");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                CategVente uneCategVente = new CategVente();
                uneCategVente.setCode(rs.getString("code"));
                uneCategVente.setLibelle(rs.getString("libelle"));
                lesCategVentes.add(uneCategVente);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesCategVentes ;    
    } 
     
     public static CategVente ajouterCategVente(Connection connection, CategVente unCategVente){
        try
        {
           
            requete=connection.prepareStatement("INSERT INTO categvente ( code, libelle)\n" +
                    "VALUES (?,?)");
            requete.setString(1, unCategVente.getCode());
            requete.setString(2, unCategVente.getLibelle());

           /* Exécution de la requête */
            requete.executeUpdate();   
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCategVente ;    
    }
}

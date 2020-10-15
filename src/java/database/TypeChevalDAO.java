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
import modele.TypeCheval;

/**
 *
 * @author sio2
 */
public class TypeChevalDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static ArrayList<TypeCheval> getLesTypeChevaux(Connection connection){      
        ArrayList<TypeCheval> lesTypeChevaux = new  ArrayList<TypeCheval>();
        try
        {
            //preparation de la requete   
            
            requete=connection.prepareStatement("select * from typecheval");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                TypeCheval unTypeCheval = new TypeCheval();
                
                unTypeCheval.setId(rs.getInt("id"));
                unTypeCheval.setLibelle(rs.getString("libelle"));
                unTypeCheval.setDescription(rs.getString("description"));
                lesTypeChevaux.add(unTypeCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesTypeChevaux;    
    }
    
    public static TypeCheval ajouterTypeCheval(Connection connection, TypeCheval unTypeCheval){
        int idGenere = -1;
        
          //System.out.println("TypeCheval DAO");
        try
        {
                //System.out.println("TRY ");
                //System.out.println("connection ! " + connection.toString());
            requete=connection.prepareStatement("INSERT INTO typecheval (libelle, description)\n" +
                    "VALUES (?,?)", requete.RETURN_GENERATED_KEYS);
            //requete.setInt(1, unCheval.getId());
            requete.setString(1, unTypeCheval.getLibelle());
            requete.setString(2, unTypeCheval.getDescription());
                //System.out.println(requete.toString());
            //Exécution de la requête 
            int resultatRequ = requete.executeUpdate();
            if (resultatRequ == 1){
                //System.out.println("Resultat Req. " + resultatRequ);
            //System.out.println(requete + "La requete");
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unTypeCheval.setId(idGenere);
            } 
            //System.out.println(requete);
            
            //System.out.println("ID dans ajouterCheval + ID CHEVAL"+ unCheval.getUnTypeCheval().getId() + "   " + unCheval.getId());
            
            unTypeCheval = getRecupTypeCheval(connection, unTypeCheval.getId());
            //System.out.println("LIBEELLLE APRES RECUP"+ unCheval.getUnTypeCheval().getId() + "   " + unCheval.getUnTypeCheval().getLibelle());
            }
            else {
                //System.out.println("Resultat Req. " + resultatRequ);
                unTypeCheval = null;
            }
            System.out.println(requete);
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            unTypeCheval = null;
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unTypeCheval ;    
    }
    
    public static TypeCheval getRecupTypeCheval(Connection connection, int idGenere){
         TypeCheval unTypeCheval = new TypeCheval();
        try{
            
            
            requete=connection.prepareStatement("SELECT tc.* FROM typecheval tc WHERE tc.id = ?");
            requete.setInt(1, idGenere);
            rs=requete.executeQuery();
            
            //System.out.println("reqqqq  " +  requete);
            while ( rs.next() ) {  
                //unTypeCheval.setId(rs.getInt("id"));
                unTypeCheval.setLibelle(rs.getString("libelle")); 
                unTypeCheval.setDescription(rs.getString("description"));
                //System.out.println("LIBBBB dans getRecupCheval"+ unCheval.getUnTypeCheval().getLibelle());
            }
            System.out.println(unTypeCheval);
         }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unTypeCheval;
     }
}

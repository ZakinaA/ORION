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
import modele.Cheval;
import modele.TypeCheval;

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
                //System.out.println("connection ! " + connection.toString());
            requete=connection.prepareStatement("INSERT INTO cheval (nom, sexe, numSire, idTypeCheval)\n" +
                    "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS);
            //requete.setInt(1, unCheval.getId());
            requete.setString(1, unCheval.getNom());
            requete.setString(2, unCheval.getSexe());
            requete.setString(3, unCheval.getNumSire());
            requete.setInt(4, unCheval.getUnTypeCheval().getId());
            //System.out.println(requete.toString());
            //Exécution de la requête 
            int resultatRequ = requete.executeUpdate();
            
            if (resultatRequ == 1){
                //System.out.println("Resultat Req. " + resultatRequ);
            //System.out.println(requete + "La requete");
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unCheval.setId(idGenere);
            } 
            //System.out.println(requete);
            
            //System.out.println("ID dans ajouterCheval + ID CHEVAL"+ unCheval.getUnTypeCheval().getId() + "   " + unCheval.getId());
            
            unCheval = getRecupCheval(connection, unCheval.getId());
            //System.out.println("LIBEELLLE APRES RECUP"+ unCheval.getUnTypeCheval().getId() + "   " + unCheval.getUnTypeCheval().getLibelle());
            }
            else {
                //System.out.println("Resultat Req. " + resultatRequ);
                unCheval = null;
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unCheval = null;
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
            requete.setInt(4, unCheval.getUnTypeCheval().getId());
            //System.out.println(requete);
            
            
            //Exécution de la requête 
            int resultatReqMod = requete.executeUpdate();
            
            if (resultatReqMod == 1){
                //System.out.println("Resultat Req. " + resultatRequ);
            //System.out.println(requete + "La requete");
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unCheval.setId(idGenere);
            } 
            //System.out.println(requete);
            
            //System.out.println("ID dans ajouterCheval + ID CHEVAL"+ unCheval.getUnTypeCheval().getId() + "   " + unCheval.getId());
            
            unCheval = getRecupCheval(connection, unCheval.getId());
            //System.out.println("LIBEELLLE APRES RECUP"+ unCheval.getUnTypeCheval().getId() + "   " + unCheval.getUnTypeCheval().getLibelle());
            }
            else {
                //System.out.println("Resultat Req. " + resultatRequ);
                unCheval = null;
            }
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval ;    
    }
     
    public static Cheval getRecupCheval(Connection connection, int idGenere){
         Cheval unCheval = new Cheval();
        try{
            
            
            requete=connection.prepareStatement("Select ch.*, tc.libelle from cheval ch, typecheval tc where ch.idTypeCheval = tc.id and ch.id = ?");
            requete.setInt(1, idGenere);
            rs=requete.executeQuery();
            
            //System.out.println("reqqqq  " +  requete);
            while ( rs.next() ) {  
                //unCheval.setId(rs.getInt("id"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                unCheval.setNumSire(rs.getString("numSire"));
                
                
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setLibelle(rs.getString("libelle"));
                
                unCheval.setUnTypeCheval(unTypeCheval);
                
                //System.out.println("LIBBBB dans getRecupCheval"+ unCheval.getUnTypeCheval().getLibelle());
            }
         }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval;
     }
}    


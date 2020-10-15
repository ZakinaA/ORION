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
import modele.CategVente;
import modele.Client;
import modele.Pays;

/**
 *
 * @author Zakina
 * 23/06/2017
 * Classe faisant la liaison entre la table client et la classe Client
 */
public class ClientDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static PreparedStatement requeteCategVente=null;
    static ResultSet rs=null;
    static ResultSet rsCategVente=null;
    
    
    
    // Méthode permettant d'insérer un client en base à partir de l'objet client passé en paramètre
    // Cette méthode renvoie l'objet client
    public static Client ajouterClient(Connection connection, Client unClient){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO client ( nom, prenom, rue, copos, ville, mail, codePays)\n" +
                    "VALUES (?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unClient.getNom());
            requete.setString(2, unClient.getPrenom());
            requete.setString(3, unClient.getRue());
            requete.setString(4, unClient.getCopos());
            requete.setString(5, unClient.getVille());
            requete.setString(6, unClient.getMel());
            requete.setString(7, unClient.getUnPays().getCode());

           /* Exécution de la requête */
            int resultatRequ = requete.executeUpdate();
            if (resultatRequ == 1){
            //System.out.println("Resultat Req. " + resultatRequ);
            //System.out.println(requete + "La requete");
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unClient.setId(idGenere);
            }
            
                for (int i=0;i<unClient.getLesCategVentes().size();i++){
                    PreparedStatement requete2=connection.prepareStatement("INSERT INTO clientcategvente (codeClient, codeCategVente )\n" +
                        "VALUES (?,?)");
                    requete2.setInt(1, unClient.getId());
                    requete2.setString(2, unClient.getLesCategVentes().get(i).getCode());
                    requete2.executeUpdate();
                }
                unClient = getRecupClient(connection, unClient.getId());
            }
            else{
                unClient = null;
            }  
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            unClient = null;
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unClient ;    
    }
    
    public static Client getRecupClient(Connection connection, int idGenere){
         Client unClient = new Client();
         ArrayList<CategVente> lesCategVentes = new  ArrayList<CategVente>();
        try{
            
            
            requete=connection.prepareStatement("Select c.*, p.nom as pays from client c, pays p where c.codePays = p.code and c.id = ?");
            requeteCategVente=connection.prepareStatement("select cv.* from clientcategvente cc, categvente cv, client c where c.id = cc.codeClient and cc.codeCategVente = cv.code and c.id = ?");
            
            //System.out.println("REQUETECATEGVENTE=" + requeteCategVente);
            
            requete.setInt(1, idGenere);
            requeteCategVente.setInt(1, idGenere);
            
            //System.out.println("REQUETECATEGVENTE=" + requeteCategVente);
            
            rs=requete.executeQuery();
            
            //System.out.println("reqqqq  " +  requete);
            while ( rs.next()) {  
                //unCheval.setId(rs.getInt("id"));
                unClient.setNom(rs.getString("nom"));
                unClient.setPrenom(rs.getString("prenom"));
                unClient.setRue(rs.getString("rue"));
                unClient.setCopos(rs.getString("copos"));
                unClient.setVille(rs.getString("Ville"));
                unClient.setMel(rs.getString("mail"));
                
                Pays unPays = new Pays();
                unPays.setNom(rs.getString("pays"));
                
                unClient.setUnPays(unPays);
                
                //System.out.println("LIBBBB dans getRecupCheval"+ unCheval.getUnTypeCheval().getLibelle());
            }
            
            rsCategVente=requeteCategVente.executeQuery();
            
           while (rsCategVente.next()){
                CategVente uneCateg = new CategVente();
                uneCateg.setCode(rsCategVente.getString("code"));
                uneCateg.setLibelle(rsCategVente.getString("libelle"));
                
                lesCategVentes.add(uneCateg);
               
           }
           
            unClient.setLesCategVentes(lesCategVentes);
         }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unClient;
     }   
}

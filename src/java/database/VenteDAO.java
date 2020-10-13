/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.CategVente;
import modele.Cheval;
import modele.Client;
import modele.Courriel;
import modele.Lieu;
import modele.Lot;
import modele.Pays;
import modele.TypeCheval;
import modele.Vente;

/**
 *
 * @author Zakina
 * 22/06/2017
 * Classe faisant la liaison entre la table Vente et la classe Vente
 */
public class VenteDAO {

    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    /* @author Zakina - 22/06/2017
    /* Méthode permettant de lister toutes les ventes enregistrées en base, triées par date décroissante.
    /* Pour chaque vente, on récupère aussi sa catégorie.
    /* La liste des vente est stockée dans une ArrayList
    */
    public static ArrayList<Vente>  getLesVentes(Connection connection){      
        ArrayList<Vente> lesVentes = new  ArrayList<Vente>();
        try
        {
            //preparation de la requete 
            //System.out.println("req avant" + requete);
            //System.out.println("connection" + connection.toString());
            requete=connection.prepareStatement("select distinct * from vente, categvente, lieu where codeCategVente=code and idLieu = lieu.id order by dateDebut desc");          
            //System.out.println("req apres" + requete);
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Vente uneVente = new Vente();
                uneVente.setId(rs.getInt("id"));
                uneVente.setNom(rs.getString("nom"));
                uneVente.setDateDebutVente(rs.getString("dateDebut"));
                
               Lieu unLieu = new Lieu();
               unLieu.setId(rs.getInt("id"));
               unLieu.setVille(rs.getString("ville"));
               unLieu.setNbBoxe(rs.getString("nbBoxes"));
               
               uneVente.setUnLieu(unLieu);
               
                CategVente uneCateg = new CategVente();
                uneCateg.setCode(rs.getString("code"));  // on aurait aussi pu prendre CodeCateg
                uneCateg.setLibelle(rs.getString("libelle"));
                
                uneVente.setUneCategVente(uneCateg);
                
                lesVentes.add(uneVente);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesVentes ;    
    } 
    
    /* @author Zakina - 22/06/2017
    /* Méthode permettant de lister les clients interessés par la catégorie de la vente selectionnée (passée en paramètre de la méthode)
    /* Pour chaque client, on récupère aussi le nom de son pays
    /* La liste des clients est stockée dans une ArrayList
    */
    public static ArrayList<Client>  getLesClients(Connection connection, String codeCateg){      
        ArrayList<Client> lesClients = new  ArrayList<Client>();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT c.*, p.nom as nomPays, cv.libelle FROM client c, pays p, clientcategvente cc, categvente cv where c.codePays=p.code and cc.codeClient=c.id and cv.code=cc.codeCategVente and codeCategVente= ? ");
            requete.setString(1, codeCateg);
            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                
                
                Client unClient = new Client();
                unClient.setId(rs.getInt("id"));
                unClient.setNom(rs.getString("nom"));
                unClient.setPrenom(rs.getString("prenom"));
                unClient.setRue(rs.getString("rue"));
                unClient.setCopos(rs.getString("copos"));
                unClient.setVille(rs.getString("ville"));
                unClient.setMel(rs.getString("mail"));
                
                Pays p = new Pays();
                p.setCode(rs.getString("codePays"));
                p.setNom(rs.getString("nomPays"));
                
                unClient.setUnPays(p);
                /*CategVente uneCateg = new CategVente();
                uneCateg.setCode(rs.getString("code"));  // on aurait aussi pu prendre CodeCateg
                uneCateg.setLibelle(rs.getString("libelle"));*/
                
                lesClients.add(unClient);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesClients ;    
    } 
    
    public static ArrayList<Courriel>  getLesCourriel(Connection connection, String codeVen){      
        ArrayList<Courriel> lesCourriel = new  ArrayList<Courriel>();
        try
        {
            //preparation de la requete     
            //codeVen="210817";
            requete=connection.prepareStatement("SELECT DISTINCT c.* FROM courriel c, vente v where c.idVente=v.id and v.id = ? ");
            requete.setString(1, codeVen);
            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                
                
                Courriel unCourriel = new Courriel();
                unCourriel.setId(rs.getInt("id"));
                Date laDate =  rs.getDate("dates");
                String str = String.valueOf(laDate);
                unCourriel.setDate(str);
                unCourriel.setObjet(rs.getString("objet"));
                unCourriel.setCorps(rs.getString("corps"));
                
                
                lesCourriel.add(unCourriel);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesCourriel ;    
    }     
    
    public static ArrayList<Lot>  getLesLots(Connection connection, String codeVen){      
        ArrayList<Lot> lesLots = new  ArrayList<Lot>();
        try
        {
            //preparation de la requete     
            //codeVen="210817";
            requete=connection.prepareStatement("SELECT DISTINCT l.*, c.nom FROM lot l, vente v, cheval c where l.idVente=v.id and l.idCheval = c.id and v.id = ? ");
            requete.setString(1, codeVen);
            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                
                
                Lot unLot = new Lot();
                unLot.setId(rs.getInt("id"));
                unLot.setPrixDepart(rs.getString("prixDepart"));
                
                Cheval unCheval = new Cheval();
                unCheval.setNom(rs.getString("nom"));
                unLot.setUnCheval(unCheval);
                
                lesLots.add(unLot);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesLots ;    
    }
    
    public static ArrayList<Cheval>  getLesChevaux(Connection connection, String codeLot){      
        ArrayList<Cheval> LesChevaux = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            //codeVen="210817";
            requete=connection.prepareStatement("SELECT c1.id, c1.nom, c1.sexe, c1.numSire, c1.idTypeCheval, c2.nom as PereCheval, c3.nom as MereCheval, t.libelle, client.nom as NomProp, client.prenom as PrenomProp FROM cheval as c1, lot l, typecheval t, cheval c2, cheval c3, client WHERE c1.pere = c2.id and c1.mere = c3.id and l.idCheval = c1.id and c1.idTypeCheval = t.id and client.id = c1.idClient and l.id = ? ");
            requete.setString(1, codeLot);
            //executer la requete
            System.out.println(requete);
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
                
                
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("id"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                unCheval.setNumSire(rs.getString("numSire"));
                
                
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setLibelle(rs.getString("libelle"));
                unCheval.setUnTypeCheval(unTypeCheval);
                
                Cheval unChevalPere = new Cheval();
                unChevalPere.setNom(rs.getString("PereCheval"));
                
                Cheval unChevalMere = new Cheval();
                unChevalMere.setNom(rs.getString("MereCheval"));
                
                Client unClient = new Client();
                unClient.setNom(rs.getString("NomProp"));
                unClient.setPrenom(rs.getString("PrenomProp"));
                unCheval.setUnClient(unClient);
                
                unCheval.setUnChevalPere(unChevalPere);
                unCheval.setUnChevalMere(unChevalMere);
                LesChevaux.add(unCheval);
                
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return LesChevaux ;    
    }
}

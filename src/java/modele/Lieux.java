/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Zakina
 */
public class Lieux {
    
    private int id ;
    private String ville;
    private String nbBoxe;
    private String commentaire;
    
    private ArrayList<Vente> ListeVente;

    public Lieux() {
    }

    public Lieux(int id, String ville, String nbBoxe, String commentaire, ArrayList<Vente> ListeVente) {
        this.id = id;
        this.ville = ville;
        this.nbBoxe = nbBoxe;
        this.commentaire = commentaire;
        this.ListeVente = ListeVente;
    }

    public Lieux(int id, String ville, String nbBoxe, String commentaire) {
        this.id = id;
        this.ville = ville;
        this.nbBoxe = nbBoxe;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNbBoxe() {
        return nbBoxe;
    }

    public void setNbBoxe(String nbBoxe) {
        this.nbBoxe = nbBoxe;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }  

    public ArrayList<Vente> getListeVente() {
        return ListeVente;
    }

    public void setListeVente(ArrayList<Vente> ListeVente) {
        this.ListeVente = ListeVente;
    }
    
    public void addVente(Vente unVente){
        
        if (this.ListeVente == null){
            this.ListeVente = new ArrayList<Vente>();                  
        }
         ListeVente.add(unVente);
    }
}

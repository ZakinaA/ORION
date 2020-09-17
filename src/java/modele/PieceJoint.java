/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author sio2
 */
public class PieceJoint {
    
    private int id;
    private String chemin;
    private String description;
    
    private ArrayList<Courriel> ListeCourriel;

    public PieceJoint() {
    }

    public PieceJoint(int id, String chemin, String description, ArrayList<Courriel> ListeCourriel) {
        this.id = id;
        this.chemin = chemin;
        this.description = description;
        this.ListeCourriel = ListeCourriel;
    }

    public PieceJoint(int id, String chemin, String description) {
        this.id = id;
        this.chemin = chemin;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Courriel> getListeCourriel() {
        return ListeCourriel;
    }

    public void setListeCourriel(ArrayList<Courriel> ListeAffectation) {
        this.ListeCourriel = ListeAffectation;
    }
    
    public void addCourriel(Courriel unCourriel){
        
        if (this.ListeCourriel == null){
            this.ListeCourriel = new ArrayList<Courriel>();                  
        }
         ListeCourriel.add(unCourriel);
    }
    
    
}

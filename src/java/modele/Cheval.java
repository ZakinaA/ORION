/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author sio2
 */
public class Cheval {
    
    private int id;
    private String nom;
    private String sexe;
    private String numSire;
    private String dateNaissance;

    public Cheval() {
    }

    public Cheval(int id, String nom, String sexe, String numSire, String dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        this.numSire = numSire;
        this.dateNaissance = dateNaissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumSire() {
        return numSire;
    }

    public void setNumSire(String numSire) {
        this.numSire = numSire;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    
}

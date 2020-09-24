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
public class Cheval {
    
    private int id;
    private String nom;
    private String sexe;
    private String numSire;
    private String dateNaissance;
    private TypeCheval unTypeCheval;
    private Client unClient;
    ArrayList<Lot> listeLot;
    Cheval unChevalPere;
    Cheval unChevalMere;

    public Cheval() {
    }

    public Cheval(int id, String nom, String sexe, String numSire, String dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        this.numSire = numSire;
        this.dateNaissance = dateNaissance;
    }

    public Cheval(int id, String nom, String sexe, String numSire, String dateNaissance, ArrayList<Lot> leLot) {
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        this.numSire = numSire;
        this.dateNaissance = dateNaissance;
        this.listeLot = listeLot;
    }

    public Cheval(int id, String nom, String sexe, String numSire, String dateNaissance, TypeCheval unTypeCheval, ArrayList<Lot> listeLot) {
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        this.numSire = numSire;
        this.dateNaissance = dateNaissance;
        this.unTypeCheval = unTypeCheval;
        this.listeLot = listeLot;
    }

    public Cheval(int id, String nom, String sexe, String numSire, String dateNaissance, TypeCheval unTypeCheval, Client unClient, ArrayList<Lot> listeLot) {
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        this.numSire = numSire;
        this.dateNaissance = dateNaissance;
        this.unTypeCheval = unTypeCheval;
        this.unClient = unClient;
        this.listeLot = listeLot;
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

    public TypeCheval getUnTypeCheval() {
        return unTypeCheval;
    }

    public ArrayList<Lot> getListeLot() {
        return listeLot;
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

    
    public void addLot(Lot unLot){
        
        if (this.listeLot == null){
            this.listeLot = new ArrayList<Lot>();                  
        }
         listeLot.add(unLot);
    }

    public void setUnTypeCheval(TypeCheval unTypeCheval) {
        this.unTypeCheval = unTypeCheval;
    }

    public void setListeLot(ArrayList<Lot> listeLot) {
        this.listeLot = listeLot;
    }

    public Client getUnClient() {
        return unClient;
    }

    public void setUnClient(Client unClient) {
        this.unClient = unClient;
    }

    public Cheval getUnChevalPere() {
        return unChevalPere;
    }

    public void setUnChevalPere(Cheval unChevalPere) {
        this.unChevalPere = unChevalPere;
    }
    
    public Cheval getUnChevalMere() {
        return unChevalMere;
    }

    public void setUnChevalMere(Cheval unChevalMere) {
        this.unChevalMere = unChevalMere;
    }
}

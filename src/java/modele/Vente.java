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
public class Vente {
    private int id;
    private String nom;
    private String dateDebutVente;
    private Lieux unLieu ;
    private CategVente uneCategVente;
    ArrayList<Lot> listeLot;
    ArrayList<Courriel> lesCourriels;
    

    public Vente() {
    }

    public Vente(int id, String nom, String dateDebutVente) {
        this.id = id;
        this.nom = nom;
        this.dateDebutVente = dateDebutVente;
    }

    public Vente(int id, String nom, String dateDebutVente, Lieux unLieu, CategVente uneCategVente) {
        this.id = id;
        this.nom = nom;
        this.dateDebutVente = dateDebutVente;
        this.unLieu = unLieu;
        this.uneCategVente = uneCategVente;
    }

    public Vente(int id, String nom, String dateDebutVente, Lieux unLieu, CategVente uneCategVente, ArrayList<Lot> listeLot) {
        this.id = id;
        this.nom = nom;
        this.dateDebutVente = dateDebutVente;
        this.unLieu = unLieu;
        this.uneCategVente = uneCategVente;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateDebutVente() {
        return dateDebutVente;
    }

    public void setDateDebutVente(String dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }

    public CategVente getUneCategVente() {
        return uneCategVente;
    }

    public void setUneCategVente(CategVente uneCategVente) {
        this.uneCategVente = uneCategVente;
    }

    public Lieux getUnLieu() {
        return unLieu;
    }

    public void setUnLieu(Lieux unLieu) {
        this.unLieu = unLieu;
    }

    public ArrayList<Lot> getUnLot() {
        return listeLot;
    }

    public void setUnLot(ArrayList<Lot> unLot) {
        this.listeLot = listeLot;
    }
    
    public void addLot(Lot unLot){
        
        if (this.listeLot == null){
            this.listeLot = new ArrayList<Lot>();                  
        }
         listeLot.add(unLot);
    }
    
    public void addCourriel(Courriel unCourriel){
        
        if (this.lesCourriels == null){
            this.lesCourriels = new ArrayList<Courriel>();                  
        }
         lesCourriels.add(unCourriel);
    }
    
    public int getNbCourriels(){
        return lesCourriels.size();
    }
}

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
public class Courriel {
    
    private int id;
    private String date;
    private String objet;
    private String corps;
    
    private ArrayList<PieceJoint> ListePieceJoint;
    private Vente unVente;

    public Courriel() {
    }

    public Courriel(int id, String date, String objet, String corps, ArrayList<PieceJoint> ListePieceJoint, Vente unVente) {
        this.id = id;
        this.date = date;
        this.objet = objet;
        this.corps = corps;
        this.ListePieceJoint = ListePieceJoint;
        this.unVente = unVente;
    }

    public Courriel(int id, String date, String objet, String corps, ArrayList<PieceJoint> ListePieceJoint) {
        this.id = id;
        this.date = date;
        this.objet = objet;
        this.corps = corps;
        this.ListePieceJoint = ListePieceJoint;
    }

    public Courriel(int id, String date, String objet, String corps) {
        this.id = id;
        this.date = date;
        this.objet = objet;
        this.corps = corps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public ArrayList<PieceJoint> getListePieceJoint() {
        return ListePieceJoint;
    }

    public void setListePieceJoint(ArrayList<PieceJoint> ListePieceJoint) {
        this.ListePieceJoint = ListePieceJoint;
    }
    
    public void addPieceJoint(PieceJoint unPieceJoint){
        
        if (this.ListePieceJoint == null){
            this.ListePieceJoint = new ArrayList<PieceJoint>();
            }
        ListePieceJoint.add(unPieceJoint);
    }

    public Vente getUnVente() {
        return unVente;
    }

    public void setUnVente(Vente unVente) {
        this.unVente = unVente;
    }
}

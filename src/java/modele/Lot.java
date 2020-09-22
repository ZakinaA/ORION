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
public class Lot {
    private int id;
    private String prixDepart;
    private Cheval unCheval;

    public Lot() {
    }
    
    public Lot(int id, String prixDepart) {
        this.id = id;
        this.prixDepart = prixDepart;
    }

    public Lot(int id, String prixDepart, Cheval unCheval) {
        this.id = id;
        this.prixDepart = prixDepart;
        this.unCheval = unCheval;
    }

    public int getId() {
        return id;
    }

    public String getPrixDepart() {
        return prixDepart;
    }

    public Cheval getUnCheval() {
        return unCheval;
    }

    public void setUnCheval(Cheval unCheval) {
        this.unCheval = unCheval;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setPrixDepart(String prixDepart) {
        this.prixDepart = prixDepart;
    }
}

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
public class Prix {
    private int id;
    private String nomPrix;
    private String lieu;
    private String date;

    public Prix() {
    }

    public Prix(int id, String nomPrix, String lieu, String date) {
        this.id = id;
        this.nomPrix = nomPrix;
        this.lieu = lieu;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPrix() {
        return nomPrix;
    }

    public void setNomPrix(String nomPrix) {
        this.nomPrix = nomPrix;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }    
}

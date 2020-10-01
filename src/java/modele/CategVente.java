package modele;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zakina
 */
public class CategVente {
    private String code;
    private String libelle ;
    ArrayList<Vente> listerLesVentes;

    public CategVente() {
    }

    public CategVente(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Vente> getListerLesVentes() {
        return listerLesVentes;
    }

    public void setListerLesVentes(ArrayList<Vente> listerLesVentes) {
        this.listerLesVentes = listerLesVentes;
    } 
}

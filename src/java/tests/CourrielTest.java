/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Courriel;

/**
 *
 * @author sio2
 */
public class CourrielTest {
    public static void main(String[] args) {
        Courriel unCourriel = new Courriel(1, "08/09/2020", "Vente d'été", "Elle sera la 1er vente de la saison");
       System.out.println(unCourriel.getDate() + " Objet - " + unCourriel.getObjet() + " | " + unCourriel.getCorps());
    }
}

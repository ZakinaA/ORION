/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Courriel;
import modele.Vente;

/**
 *
 * @author sio2
 */
public class VenteTest {
    public static void main(String[] args) {
        Vente unVente = new Vente(1, "Vente d'été", "2 juin 2021");
        System.out.println("Le vente numéro " + unVente.getId() + " sera " + unVente.getNom() + " qui débutera le " + unVente.getDateDebutVente());
        
        Courriel unCourriel1 = new Courriel(1, "08/09/2020", "Vente d'été", "Elle sera la 1er vente de la saison");
        unVente.addCourriel(unCourriel1);
        System.out.println("La vente " + unVente.getNom() + " concerne " + unVente.getNbCourriels() + " courriel");
    }  
}

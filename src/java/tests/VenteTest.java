/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Vente;

/**
 *
 * @author sio2
 */
public class VenteTest {
    public static void main(String[] args) {
        Vente unVente = new Vente(1, "Vente d'été", "2 juin 2021");
        System.out.println("Le vente numéro " + unVente.getId() + " sera " + unVente.getNom() + " qui débutera le " + unVente.getDateDebutVente());
    }  
}

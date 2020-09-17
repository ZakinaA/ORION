/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Client;
import modele.Pays;

/**
 *
 * @author Zakina
 */
public class ClientTest {
    
    public static void main(String[] args) {
        
        Client unClient = new Client(1, "dupont", "luc","2 rue de l'église", "14000", "Caen");
        unClient.setUnPays(new Pays("FRA", "FRANCE"));    
        System.out.println(unClient.toString());
        System.out.println(unClient.getNom() + "  " + unClient.getUnPays().getNom());
  
    }
    
}

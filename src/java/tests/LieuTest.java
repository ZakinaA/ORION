/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Lieux;

/**
 *
 * @author sio2
 */
public class LieuTest {
    
    public static void main(String[] args) {
        Lieux unLieu = new Lieux(1,"Caen","20 ","grand boxe");
        System.out.println(unLieu.getVille()+ " contient " + unLieu.getNbBoxe() + unLieu.getCommentaire());
    }
}

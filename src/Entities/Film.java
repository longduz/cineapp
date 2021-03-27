/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Amine
 */
public class Film {
    private int id_film;
    private String image;
    
    public Film(){
        
    }

    public Film(int id_film, String image) {
        this.id_film = id_film;
        this.image = image;
    }
    

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
    
}

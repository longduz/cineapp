/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Amine
 */
public class Actualite {
    private int id_act;
    private Date date;
    private String description;
    private int id_film;
    private int id_prom;
    private int id_admin;

    public Actualite() {
    }

    public Actualite(int id_act, Date date, String description, int id_film, int id_prom, int id_admin) {
        this.id_act = id_act;
        this.date = date;
        this.description = description;
        this.id_film = id_film;
        this.id_prom = id_prom;
        this.id_admin = id_admin;
    }

    public Actualite(Date date,String description, int id_film, int id_prom) {
        this.date = date;
        this.description = description;
        this.id_film = id_film;
        this.id_prom = id_prom;
    }
    

    public int getId_act() {
        return id_act;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public int getId_prom() {
        return id_prom;
    }

    public void setId_prom(int id_prom) {
        this.id_prom = id_prom;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
    
    
}

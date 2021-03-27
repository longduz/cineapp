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
public class Promotion {
    private int id_promotion;
    private int percent;

    public Promotion() {
    }

    public Promotion(int id_promotion, int percent) {
        this.id_promotion = id_promotion;
        this.percent = percent;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    
}

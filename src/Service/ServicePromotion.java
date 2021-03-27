/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.ServicePromotion;
import Services.IServicePromotion;
import Utils.Maconnexion;
import Entities.Actualite;
import Entities.Promotion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amine
 */
public class ServicePromotion implements IServicePromotion<Promotion> {

    private final Connection con;
    private Statement ste;
    public ResultSet resultat;
    public PreparedStatement pre;
    public String req;

    public ServicePromotion() {
        con = Maconnexion.getInstance().getConnection();

    }
    
    @Override
    public Promotion get_promotion_by_id(int id) throws SQLException {
        List<Promotion> arr = new ArrayList<>();
        req = "select * from promotion where id = '" + String.valueOf(id)+ "' ";
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            int id_promotion = rs.getInt(1);
            int percent = rs.getInt(2);
            Promotion promotion = new Promotion(id_promotion, percent);
            arr.add(promotion);
        }
        if (arr.size() == 1) 
            return arr.get(0);
        else return null;
    }

}

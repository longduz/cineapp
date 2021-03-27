/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Actualite;
import Entities.Reservation;
import Services.IServiceUser;
import Utils.Maconnexion;
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
 * @author amine
 */
public class ServiceUser implements IServiceUser{

    private final Connection con;
    private Statement ste;
    public ResultSet resultat;
    public PreparedStatement pre;
    public String req;

    public ServiceUser() {
        con = Maconnexion.getInstance().getConnection();

    }

    @Override
    public List<String> get_mailing_list() throws SQLException {
        List<String> res= new ArrayList<>();
        ste = con.createStatement();
        req ="select email from simpleusers"; 
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            String email = rs.getString(1);
            res.add(email);
        }
        return res;
        
    }
    
}

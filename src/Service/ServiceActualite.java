/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.ServiceActualite;
import Services.IServiceActualite;
import Utils.Maconnexion;
import Entities.Actualite;
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
public class ServiceActualite implements IServiceActualite<Actualite> {

    private final Connection con;
    private Statement ste;
    public ResultSet resultat;
    public PreparedStatement pre;
    public String req;

    public ServiceActualite() {
        con = Maconnexion.getInstance().getConnection();

    }

    @Override
    public String ajouter_actualite(Actualite actu) throws SQLException {
        String last_id = "0";
        PreparedStatement pre = con.prepareStatement("INSERT INTO `actualite`(`date`, `description`, `id_film`, `id_prom`) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
        pre.setDate(1, actu.getDate());
        pre.setString(2, actu.getDescription());
        pre.setInt(3, actu.getId_film());
        pre.setInt(4, actu.getId_prom());
        pre.executeUpdate();
        ResultSet rs = pre.getGeneratedKeys();
        if (rs.next()){
            last_id = rs.getString(1);
        }
        return last_id;
    }

    @Override
    public List<Actualite> get_actualite() throws SQLException {
        List<Actualite> arr = new ArrayList<>();
        req = "select * from actualite";
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            int id_act = rs.getInt(1);
            Date date = rs.getDate(2);
            String description = rs.getString(3);
            int id_film = rs.getInt(4);
            int id_prom = rs.getInt(5);
            int id_admin = rs.getInt(6);
            Actualite actu = new Actualite(id_act, date, description, id_film, id_prom, id_admin);
            arr.add(actu);
        }
        return arr;

    }

    @Override
    public void delete_actualite_by_id(int id) throws SQLException {
        ste = con.createStatement();
        String requeteDelete = "DELETE FROM actualite WHERE id_act = ? ;";
        PreparedStatement pst = con.prepareStatement(requeteDelete);
        pst.setInt(1, id);
        pst.executeUpdate();
    }

    @Override
    public void update_actualite(Actualite actu, int id) throws SQLException {
        req = "UPDATE `actualite` SET `date`=?,`description`=?,`id_film`=?,`id_prom`=? WHERE `id_act`=?";
        pre = con.prepareStatement(req);
        pre.setDate(1, actu.getDate());
        pre.setString(2, actu.getDescription());
        pre.setInt(3, actu.getId_film());
        pre.setInt(4, actu.getId_prom());
        pre.setInt(5, id);
        pre.executeUpdate();
    }

    @Override
    public List<Actualite> get_actualite_sorted_by_date(boolean desc) throws SQLException {
        List<Actualite> arr = new ArrayList<>();
        req = "select * from actualite order by date";
        if (desc == true) {
            req = req + " DESC";
        }
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            int id_act = rs.getInt(1);
            Date date = rs.getDate(2);
            String description = rs.getString(3);
            int id_film = rs.getInt(4);
            int id_prom = rs.getInt(5);
            int id_admin = rs.getInt(6);
            Actualite actu = new Actualite(id_act, date, description, id_film, id_prom, id_admin);
            arr.add(actu);
        }
        return arr;
    }

    @Override
    public List<Actualite> get_actualite_by_description(String description) throws SQLException {
        List<Actualite> arr = new ArrayList<>();
        req = "select * from actualite where description = " + description;
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            int id_act = rs.getInt(1);
            Date date = rs.getDate(2);
            String desc = rs.getString(3);
            int id_film = rs.getInt(4);
            int id_prom = rs.getInt(5);
            int id_admin = rs.getInt(6);
            Actualite actu = new Actualite(id_act, date, desc, id_film, id_prom, id_admin);
            arr.add(actu);
        }
        return arr;
    }

    @Override
    public Actualite get_actualite_by_id(int id) throws SQLException {
        List<Actualite> arr = new ArrayList<>();
        req = "select * from actualite where id_act = '" + String.valueOf(id)+ "' ";
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            int id_act = rs.getInt(1);
            Date date = rs.getDate(2);
            String desc = rs.getString(3);
            int id_film = rs.getInt(4);
            int id_prom = rs.getInt(5);
            int id_admin = rs.getInt(6);
            Actualite actu = new Actualite(id_act, date, desc, id_film, id_prom, id_admin);
            arr.add(actu);
        }
        if (arr.size() == 1) 
            return arr.get(0);
        else return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.Maconnexion;
import Entities.Film;
import Services.IServiceFilm;
import java.sql.Connection;
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
public class ServiceFilm implements IServiceFilm<Film> {

    private final Connection con;
    private Statement ste;
    public ResultSet resultat;
    public PreparedStatement pre;
    public String req;

    public ServiceFilm() {
        con = Maconnexion.getInstance().getConnection();

    }

    @Override
    public Film get_film_by_id(int id) throws SQLException {
        List<Film> arr = new ArrayList<>();
        req = "select * from film where id = '" + String.valueOf(id)+ "' ";
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            int id_film = rs.getInt(1);
            String image = rs.getString(2);
            Film film = new Film(id_film, image);
            arr.add(film);
        }
        if (arr.size() == 1) {
            return arr.get(0);
        }
        else return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Film;
import java.sql.SQLException;

/**
 *
 * @author mouad
 */
public interface IServiceFilm<T> {
    public Film get_film_by_id(int id)throws SQLException ;
    
}

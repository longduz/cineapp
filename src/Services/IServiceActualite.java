/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Actualite;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amine
 */
public interface IServiceActualite<T> {
    public String ajouter_actualite(T actu) throws SQLException;
    public List<T> get_actualite() throws SQLException ;
    public Actualite get_actualite_by_id(int id)throws SQLException ;
    public List<T> get_actualite_sorted_by_date(boolean desc)throws SQLException ;
    public List<T> get_actualite_by_description(String description)throws SQLException ;
    public void delete_actualite_by_id(int id) throws SQLException;
    public void update_actualite(T actu, int id) throws SQLException;    
}

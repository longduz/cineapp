/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author amine
 */
public interface IServiceUser {
    public List<String> get_mailing_list()throws SQLException ;
    
}

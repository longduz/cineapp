/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Promotion;
import java.sql.SQLException;

/**
 *
 * @author mouad
 */
public interface IServicePromotion<T> {
    public Promotion get_promotion_by_id(int id)throws SQLException ;
}

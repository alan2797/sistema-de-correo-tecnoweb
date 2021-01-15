/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Franklin
 */
public interface IQuery {
    
    Object[] field();
    Object[] values(ResultSet rs)throws SQLException;
}

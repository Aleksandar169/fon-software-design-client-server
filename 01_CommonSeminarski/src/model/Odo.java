/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public interface Odo extends Serializable {

    public String getTableName();

    public List<Odo> getList(ResultSet rs) throws Exception;

    public String getColumnForInsert();

    public String getValueForInsert();

    public String getGeneretedKey();

    public Odo getObject(ResultSet rs) throws Exception;

    public String getValueForUpdate();

    public String getWhere();
    
    public Object[] getObjectArray();
    
    public String join();

    public String[] getColumnName();
    
    /**
     *
     * @return
     */
    public String getWhereRb();
    
 

}

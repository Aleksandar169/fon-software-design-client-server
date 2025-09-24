/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ProfessionalDegree implements Serializable, Odo{
    
    private int idProfessionalDegree;
    private String name; 
    private String condition;

    public ProfessionalDegree() {
    }

    public ProfessionalDegree(int idProfessionalDegree, String name) {
        this.idProfessionalDegree = idProfessionalDegree;
        this.name = name;
        
    }
    public ProfessionalDegree( String name) {
        this.name = name;
        
    }

    ProfessionalDegree(ResultSet rs) {
        try {
            idProfessionalDegree=rs.getInt("professionaldegree.idProfessionaldegree");
            name=rs.getString("professionaldegree.name");
        } catch (SQLException ex) {
            Logger.getLogger(ProfessionalDegree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getIdProfessionalDegree() {
        return idProfessionalDegree;
    }

    public void setIdProfessionalDegree(int idProfessionalDegree) {
        this.idProfessionalDegree = idProfessionalDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    

    @Override
    public String toString() {
        return  name  ;
    }

    @Override
    public String getTableName() {
        return "professionaldegree";
    }

    @Override
    public List<Odo> getList(ResultSet rs) throws Exception {
        List<Odo> list=new ArrayList<>();
        while(rs.next()){
            int id=rs.getInt("professionaldegree.idProfessionaldegree");
            String name=rs.getString("professionaldegree.name");
           ProfessionalDegree pd=new ProfessionalDegree(id,name);
           list.add(pd);
            
        }
        return list;        
    }

    @Override
    public String getColumnForInsert() {
        return "name";
    }

    @Override
    public String getValueForInsert() {
        return "'"+name+"'";
    }

    @Override
    public String getGeneretedKey() {
        return " professionaldegree.idProfessionaldegree="+idProfessionalDegree;
    }

    @Override
    public Odo getObject(ResultSet rs) throws Exception {
        if(rs.next()){
            int id=rs.getInt("professionaldegree.idProfessionaldegree");
            String name=rs.getString("professionaldegree.idProfessionaldegree");
            return new ProfessionalDegree(id, name);
        }
        return null;
    }

    @Override
    public String getValueForUpdate() {
        return " name='"+name+"'";
    }

    @Override
    public String getWhere() {
        if(condition!=null)
        return " WHERE professionaldegree.name LIKE '%"+condition+"%'";
        return "";
    }

    @Override
    public Object[] getObjectArray() {
        Object[] o={name};
        return o;
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String[] getColumnName() {
        String[] s={"Name"};
        return s;
    }

    @Override
    public String getWhereRb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}

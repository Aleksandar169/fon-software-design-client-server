/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;

/**
 *
 * @author Lenovo
 */
public class Place implements Odo,Serializable{
    private int idPlace;
    private String name;
    private String condition;
     
    
    public Place() {
    }

    public Place(int idPlace, String Name ) {
        this.idPlace = idPlace;
        this.name = Name;
        
    }
    public Place(String Name ) {
       
        this.name = Name;
        
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    

   
    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    @Override
    public String toString() {
        return  name ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Place other = (Place) obj;
        return this.idPlace == other.idPlace;
    }
    

    @Override
    public String getTableName() {
        return "place";
    }

    @Override
    public List<Odo> getList(ResultSet rs) throws Exception {
        List<Odo> list=new ArrayList<>();
        while(rs.next()){
            int id=rs.getInt("place.idPlace");
           // System.out.println(id);
            String name=rs.getString("place.name");
            Place place=new Place(id, name);
            list.add(place);
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
        return "place.idPlace="+idPlace;
    }

    @Override
    public Odo getObject(ResultSet rs) throws Exception {
         if(rs.next()){
            int id=rs.getInt("place.idPlace");
           // System.out.println(id);
            String name=rs.getString("place.name");
            return new Place(id, name);
           
        }
         return null;
    }

    @Override
    public String getValueForUpdate() {
        return "name='"+name+"'";
    }

    @Override
    public String getWhere() {
        if(condition!=null )
           return " WHERE name LIKE '%"+condition+"%'";
        return "";
    }

    @Override
    public String join() {
        return " ";//JOIN customer ON customer.place=place.idPlace";
    }

    @Override
    public Object[] getObjectArray() {
        Object[] o={name};
        return o;
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

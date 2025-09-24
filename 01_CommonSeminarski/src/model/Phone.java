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
public class Phone implements Serializable, Odo {

    private int idPhone;
    private String mark;
    private String model;

    private double price;
    private String condition;

    public Phone() {
    }

    public Phone(String model, String mark, double price) {
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public Phone(int idPhone, String mark, String model, double price) {
        this.idPhone = idPhone;
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    Phone(ResultSet rs) {
        try {
            idPhone = rs.getInt("phone.idPhone");
            mark = rs.getString("phone.mark");
            model = rs.getString("phone.model");
            price = rs.getDouble("phone.price");
        } catch (SQLException ex) {
            Logger.getLogger(Phone.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    

    @Override
    public String toString() {
        return  mark    + "/" + model ;
    }

    @Override
    public String getTableName() {
        return "phone";
    }

    @Override
    public List<Odo> getList(ResultSet rs) throws Exception {
        List<Odo> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("phone.idPhone");
            String mark = rs.getString("phone.mark");
            String model = rs.getString("phone.model");
            double price = rs.getDouble("phone.price");
            Phone p = new Phone(id, mark, model, price);
            list.add(p);

        }
        return list;

    }

    @Override
    public String getColumnForInsert() {
        return "mark, model, price";
    }

    @Override
    public String getValueForInsert() {
        return "'" + mark + "', '" + model + "', " + price;
    }

    @Override
    public String getGeneretedKey() {
        return "phone.idPhone=" + idPhone;
    }

    @Override
    public Odo getObject(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("phone.idPhone");
            String mark = rs.getString("phone.mark");
            String model = rs.getString("phone.model");
            double price = rs.getDouble("phone.price");
            return new Phone(id, mark, model, price);
        }
        return null;
    }

    @Override
    public String getValueForUpdate() {
        return "mark='" + mark + "', model='" + model + "', price=" + price;
    }

    @Override
    public String getWhere() {
        if(condition!=null){
            return " WHERE phone.mark LIKE '%"+condition+"%' OR phone.model LIKE '%"+condition+"%' ";
                    
        }
        return "";
    }

    @Override
    public Object[] getObjectArray() {
        Object[] o = {mark, model, price};
        return o;
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String[] getColumnName() {
        String[] s = {"Mark", "Model", "Price"};
        return s;
    }

    @Override
    public String getWhereRb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getConditionReceipt() {
        if(idPhone>0)
            return "  phone.idPhone = " + idPhone;
        if(mark != null)
            return " LOWER(phone.mark) LIKE '%"+ mark.toLowerCase()+"%' ";
        return "";
    }

}

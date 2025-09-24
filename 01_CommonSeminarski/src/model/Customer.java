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
public class Customer implements Serializable, Odo {

    private int idCustomer;
    private String name;
    private String lastname;
    private String number;
    private Place place;
    private String condition;

    public Customer() {
    }

    public Customer(int idCustomer, String name, String lastname, String number, Place place) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.lastname = lastname;
        this.number = number;
        this.place = place;

    }

    Customer(ResultSet rs) {
        try {
            idCustomer = rs.getInt("customer.idCustomer");
            name = rs.getString("customer.name");
            lastname = rs.getString("customer.lastname");
            number = rs.getString("customer.number");

            int id = (rs.getInt("place.idPlace"));
            String n = (rs.getString("place.name"));
            place = new Place(id, n);

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer(String name, String last, String number, Place p) {
        this.name = name;
        this.lastname = last;
        this.number = number;
        this.place = p;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        if (this.condition != null) {
           this.condition += " AND (customer.name LIKE '%" + condition + "%' OR customer.lastname LIKE '%" + condition + "%')";
            return;
        } else {
            this.condition = "  WHERE (customer.name LIKE '%" + condition + "%' OR customer.lastname LIKE '%" + condition + "%')";
        }
        //this.condition = condition;
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
        final Customer other = (Customer) obj;
        return this.idCustomer == other.idCustomer;
    }

    @Override
    public String toString() {
        return name + " " + lastname;
    }

    @Override
    public String getTableName() {
        return "customer";
    }

    @Override
    public List<Odo> getList(ResultSet rs) throws Exception {
        List<Odo> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("customer.idCustomer");
            String name = rs.getString("customer.name");
            String lastname = rs.getString("customer.lastname");
            String number = rs.getString("customer.number");

            Place p = new Place();
            p.setIdPlace(rs.getInt("idPlace"));
            p.setName(rs.getString("place.name"));

            Customer c = new Customer(id, name, lastname, number, p);
            list.add(c);

        }
        return list;
    }

    @Override
    public String getColumnForInsert() {
        return "name,lastname,number,place";
    }

    @Override
    public String getValueForInsert() {
        return "'" + name + "', '" + lastname + "', '" + number + "', " + place.getIdPlace();
    }

    @Override
    public String getGeneretedKey() {
        return "customer.idCustomer=" + idCustomer;
    }

    @Override
    public Odo getObject(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("customer.idCustomer");
            String name = rs.getString("customer.name");
            String lastname = rs.getString("customer.lastname");
            String number = rs.getString("customer.number");

            Place p = new Place();
            p.setIdPlace(rs.getInt("place.idPlace"));
            p.setName(rs.getString("place.name"));

            return new Customer(id, name, lastname, number, p);
        }
        return null;
    }

    @Override
    public String getValueForUpdate() {
        return "name='" + name + "', lastname='" + lastname + "', number='" + number + "', place=" + place.getIdPlace();
    }

    @Override
    public String getWhere() {
        if (condition != null) {
            return condition;
            //return " WHERE customer.name LIKE '%" + condition + "%' OR customer.lastname LIKE '%" + condition + "%' OR customer.number LIKE '%" + condition + "%' OR place.name LIKE '%" + condition + "%'";
        }
        return "";
    }

    @Override
    public Object[] getObjectArray() {
        Object[] o = {name, lastname, number, place.getName()};
        return o;
    }

    @Override
    public String join() {
        return " JOIN place ON place.idPlace=customer.place";
    }

    @Override
    public String[] getColumnName() {
        String[] s = {"Name", "Lastname", "Number", "Place"};
        return s;
    }

    @Override
    public String getWhereRb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setCondition(Customer c) {
        if (c.idCustomer > 0) {
            setCondition();
        }
        if (c.getPlace() != null) {
            setCondition(c.getPlace());
        }
    }

    public void setCondition() {
        if(place!=null){
            setCondition(place);          
        }if(name!=null){
            setCondition(name);
        }

    }

    public void setCondition(Place p) {
        if (p == null) {
            return;
        }
        if (condition != null) {
            condition += " AND customer.place=" + p.getIdPlace();
            return;
        } else {
            condition = " WHERE customer.place=" + p.getIdPlace();

        }

    }

}

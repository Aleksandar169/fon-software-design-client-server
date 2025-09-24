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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Worker implements Odo, Serializable {

    private int idWorker;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private List<WP> wp;
    private String condtion;

    public Worker() {
    }

    public Worker(int idWorker, String name, String lastname, String username, String password) {
        this.idWorker = idWorker;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;

    }

    public Worker(String username, String password) {
        this.username = username;
        this.password = password;
    }

    Worker(ResultSet rs) {

        try {
            idWorker = rs.getInt("worker.idWorker");
            name = rs.getString("worker.name");
            lastname = rs.getString("worker.lastname");
            username = rs.getString("worker.username");
            password = rs.getString("worker.password");
        } catch (SQLException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public String getCondtion() {
        return condtion;
    }

    public void setCondtion(String condtion) {
        this.condtion = condtion;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<WP> getWp() {
        return wp;
    }

    public void setWp(List<WP> wp) {
        this.wp = wp;
    }
    
    
    @Override
    public String toString() {
        return name + " " + lastname;
    }

    @Override
    public String getTableName() {
        return "worker";
    }

    @Override
    public List<Odo> getList(ResultSet rs) throws Exception {
        List<Odo> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("worker.idWorker");
            String name = rs.getString("worker.name");
            String lastname = rs.getString("worker.lastname");
            String username = rs.getString("worker.username");
            String password = rs.getString("worker.password");
            Worker worker = new Worker(id, name, lastname, username, password);
            list.add(worker);

        }

        return list;
    }

    @Override
    public String getColumnForInsert() {
        return "name,lastname,username,password";
    }

    @Override
    public String getValueForInsert() {
        return "'" + name + "', '" + lastname + "', '" + username + "', '" + password + "'";
    }

    @Override
    public String getGeneretedKey() {
        return "worker.idWorker=" + idWorker;
    }

    @Override
    public Odo getObject(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("worker.idWorker");
            String name = rs.getString("worker.name");
            String lastname = rs.getString("worker.lastname");
            String username = rs.getString("worker.username");
            String password = rs.getString("worker.password");
            return new Worker(id, name, lastname, username, password);

        }
        return null;
    }

    @Override
    public String getValueForUpdate() {
        return "name='" + name + "', lastname='" + lastname + "', username='" + username + "', password='" + password + "'";
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
        final Worker other = (Worker) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    @Override
    public String getWhere() {
        if (condtion != null) {
            return " WHERE worker.name LIKE '%" + condtion + "%' OR worker.lastname LIKE '%" + condtion + "%' OR worker.username LIKE '%" + condtion + "%'";
        }
        return "";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public Object[] getObjectArray() {
        Object[] o = {name, lastname, username};
        return o;
    }

    @Override
    public String[] getColumnName() {
        String[] s = {"Name", "Lastname", "Username"};
        return s;
    }

    @Override
    public String getWhereRb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void setWhere(){
        
    }
 
 

}

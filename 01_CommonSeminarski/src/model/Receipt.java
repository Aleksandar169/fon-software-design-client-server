/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Receipt implements Odo, Serializable {

    private int idReceipt;
    private LocalDate date;
    private double totalAmount;
    private Worker worker;
    private Customer customer;
    private List<ReceiptItem> items;
    private String condition;

    public Receipt() {
    }

    public Receipt(int idReceipt, LocalDate date, double totalAmount, Worker worker, Customer customer, List<ReceiptItem> receiptItem) {
        this.idReceipt = idReceipt;
        this.date = date;
        this.totalAmount = totalAmount;
        this.worker = worker;
        this.customer = customer;
        this.items = receiptItem;
    }

    public Receipt(LocalDate date, double totalAmount, Worker worker, Customer customer, List<ReceiptItem> receiptItem) {

        this.date = date;
        this.totalAmount = totalAmount;
        this.worker = worker;
        this.customer = customer;
        this.items = receiptItem;
    }

    Receipt(ResultSet rs) {
        try {
            idReceipt = rs.getInt("receipt.idReceipt");
            date = rs.getDate("receipt.date").toLocalDate();
            totalAmount = rs.getDouble("receipt.totalAmount");
            Worker w = new Worker(rs);
            Customer c = new Customer(rs);

        } catch (SQLException ex) {
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Receipt(Worker w, Customer c, List<ReceiptItem> list) {
         
        worker = w;
        customer = c;
        items = list;
    }

    public Receipt(int id) {
        idReceipt = id;
    }

    public int getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(int idReceipt) {
        this.idReceipt = idReceipt;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ReceiptItem> getItems() {
        if (items != null) {
            return items;
        }
        return null;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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
        final Receipt other = (Receipt) obj;
        return this.idReceipt == other.idReceipt;
    }
    

    @Override
    public String toString() {
        return "id= " + idReceipt;
    }

    @Override
    public String getTableName() {
        return " receipt ";
    }

    @Override
    public List<Odo> getList(ResultSet rs) throws Exception {
        List<Odo> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("receipt.idReceipt");
            LocalDate date = rs.getDate("receipt.date").toLocalDate();
            double price = rs.getDouble("receipt.totalAmount");
            Worker w = new Worker(rs);
            Customer c = new Customer(rs);
            Receipt r = new Receipt(id, date, price, w, c, null);
            if (!list.contains(r)) {
                list.add(r);
            }

        }
        return list;
    }

    @Override
    public String getColumnForInsert() {
        return "date,totalAmount,worker,customer";
    }

    @Override
    public String getValueForInsert() {
        return "'" + date + "', " + totalAmount + ", " + worker.getIdWorker() + ", " + customer.getIdCustomer();
    }

    @Override
    public String getGeneretedKey() {
        return " receipt.idReceipt=" + idReceipt;
    }

    @Override
    public Odo getObject(ResultSet rs) throws Exception {
        if (rs.next()) {
            int id = rs.getInt("receipt.idReceipt");
            LocalDate date = rs.getDate("receipt.date").toLocalDate();
            double price = rs.getDouble("receipt.totalAmount");
            Worker w = new Worker(rs);
            Customer c = new Customer(rs);
            return new Receipt(id, date, price, w, c, null);
        }
        return null;
    }

    @Override
    public String getValueForUpdate() {
        return " worker=" + worker.getIdWorker() + ", customer=" + customer.getIdCustomer() + ", date='" + date.toString() + "', totalAmount= " + totalAmount;
    }

    @Override
    public String getWhere() {
        if (condition == null) {
            return "";
        }
        return condition;
    }

    @Override
    public String join() {
        return " JOIN worker on receipt.worker=worker.idWorker JOIN customer on customer.idCustomer=receipt.customer JOIN place ON place.idPlace=customer.place JOIN receiptitem ON receipt.idReceipt=receiptitem.receipt JOIN phone ON receiptitem.phoneId = phone.idPhone ";
    }

    @Override
    public Object[] getObjectArray() {
        Object[] o = {date, totalAmount, worker.getName() + " " + worker.getLastname(), customer.getName() + " " + customer.getLastname()};
        return o;
    }

    @Override
    public String[] getColumnName() {
        String[] s = {"Date", "FinalPrice", "Worker", "Customer"};
        return s;
    }

    @Override
    public String getWhereRb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setCondition(Receipt r) {
        if (r.idReceipt > 0) {
            setWhere();
        }
        if (r.getWorker() != null) {
            setWhere(r.getWorker());
        }
        if (r.getCustomer() != null) {
            setWhere(r.getCustomer());
        }

        for (ReceiptItem item : r.getItems()) {
            setWhere(item.getPhone());
        }

    }

    private void setWhere() {
        if (condition != null && idReceipt > 0) {
            condition += " AND receipt.idReceipt =" + idReceipt;
        } else {
            condition = " WHERE receipt.idReceipt =" + idReceipt;
        }
    }

    private void setWhere(Worker worker) {
        if (worker == null) {
            return;
        }
        if (condition != null) {
            condition += " AND worker.idWorker =" + worker.getIdWorker();
            return;
        } else {
            condition = " WHERE worker.idWorker =" + worker.getIdWorker();
        }

    }

    private void setWhere(Customer customer) {
        if (customer == null || customer.getIdCustomer() <= 0) {
            return;
        }
        if (condition != null) {
            condition += " AND customer.idCustomer =" + customer.getIdCustomer();
            return;
        } else {
            condition = " WHERE customer.idCustomer =" + customer.getIdCustomer();
        }
    }

    private void setWhere(Phone phone) {
        if (phone == null || (phone.getIdPhone() <= 0 && phone.getMark() == null)) {
            return;
        }
        if (condition != null) {
            condition += " AND " + phone.getConditionReceipt();
            return;
        } else {
            condition = " WHERE " + phone.getConditionReceipt();
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class ReceiptItem implements Serializable, Odo {

    private int rb;
    private Receipt receipt;
    private int quantity;
    private double phonePrice;
    private double totalPrice;
    private Phone phone;

    public ReceiptItem() {
    }

    public ReceiptItem(int id, Receipt receipt, int quantity, double sellingPrice, double saleValue, Phone phone) {
        this.rb = id;
        this.receipt = receipt;
        this.quantity = quantity;
        this.phonePrice = sellingPrice;
        this.totalPrice = saleValue;
        this.phone = phone;
    }

    public ReceiptItem(Receipt r, int quantity, double price, Phone phone) {
        this.receipt = r;

        this.quantity = quantity;
        this.phonePrice = price;
        this.totalPrice = quantity * this.phonePrice;
        this.phone = phone;
    }

    public ReceiptItem(Phone p) {
        this.phone = p;
    }

    public int getId() {
        return rb;
    }

    public void setId(int id) {
        this.rb = id;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(double phonePrice) {
        this.phonePrice = phonePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ReceiptItem other = (ReceiptItem) obj;
        if (this.rb != other.rb) {
            return false;
        }
        return Objects.equals(this.receipt, other.receipt);
    }
    

    @Override
    public String toString() {
        return "ReceiptItem{" + "rb=" + rb + ", receipt=" + receipt.getIdReceipt() + ", quantity=" + quantity + ", sellingPrice=" + phonePrice + ", saleValue=" + totalPrice + ", phone=" + phone + '}';
    }

    @Override
    public String getTableName() {
        return " receiptitem ";
    }

    @Override
    public List<Odo> getList(ResultSet rs) throws Exception {
        List<Odo> list = new ArrayList<>();
        while (rs.next()) {
            int rb = rs.getInt("receiptitem.rb");

            Receipt r = new Receipt(rs);

            int quantity = rs.getInt("receiptitem.quantity");
            double phonePrice = rs.getDouble("receiptitem.phonePrice");
            double totalPrice = rs.getDouble("receiptitem.totalPrice");

            Phone p = new Phone(rs);

            ReceiptItem ri = new ReceiptItem(rb, r, quantity, phonePrice, totalPrice, p);

            list.add(ri);

        }
        return list;
    }

    @Override
    public String getColumnForInsert() {
        return "receipt,quantity,phonePrice,totalPrice,phoneId";
    }

    @Override
    public String getValueForInsert() {
        return receipt.getIdReceipt() + ", " + quantity + ", " + phonePrice + ", " + totalPrice + ", " + phone.getIdPhone();
    }

    @Override
    public String getGeneretedKey() {
        return " receiptItem.rb=" + rb + " AND  receiptitem.receipt=" + receipt.getIdReceipt();
    }

    @Override
    public Odo getObject(ResultSet rs) throws Exception {
        if (rs.next()) {
            int rb = rs.getInt("receiptItem.rb");

            Receipt r = new Receipt(rs);

            int quantity = rs.getInt("receiptItem.quantity");
            double phonePrice = rs.getDouble("receiptItem.phonePrice");
            double totalPrice = rs.getDouble("receiptItem.totalPrice");

            Phone p = new Phone(rs);

            return new ReceiptItem(rb, r, quantity, phonePrice, totalPrice, p);
        }
        return null;
    }

    @Override
    public String getValueForUpdate() {
        return " quantity=" + quantity + ", phonePrice=" + phonePrice + ", totalPrice=" + totalPrice + ", phoneId=" + phone.getIdPhone();
    }

    @Override
    public String getWhere() {

        return " WHERE receiptitem.receipt=" + receipt.getIdReceipt(); //+" AND  receiptitem.rb=" + rb ;
    }

    @Override
    public Object[] getObjectArray() {

        Object[] o = {phone.getMark(), phone.getModel(), phone.getPrice(), quantity, totalPrice};
        return o;
    }

    @Override
    public String join() {
        return " JOIN phone ON receiptitem.phoneId = phone.idPhone "
                + " JOIN receipt ON receiptitem.receipt = receipt.idReceipt "
                + " JOIN worker ON receipt.worker = worker.idWorker "
                + " JOIN customer ON receipt.customer = customer.idCustomer "
                + " JOIN place ON customer.place = place.idPlace ";
    }

    @Override
    public String[] getColumnName() {
        if (this == null) {
            String[] s1 = {""};
            return s1;
        }

        String[] s = {"Mark", "Model", "Price", "Quantity", "TotalPrice"};
        return s;
    }

    public void calculate() {
        this.totalPrice = quantity * this.phonePrice;
    }

    @Override
    public String getWhereRb() {
        return " WHERE receiptitem.receipt=" + receipt.getIdReceipt() + " AND  receiptitem.rb=" + rb;

    }
    //if condition!=null da vrati ovo getWhererb a ako nije onda vrati drugi getWhere

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.java.accessibility.util.AWTEventMonitor;
import forms.ReceiptAdd;

/**
 *
 * @author Lenovo
 */
public class MainFormController {
    private final ReceiptAdd mf;

    public MainFormController(ReceiptAdd mf) {
        this.mf = mf;
        addActionListeners();
    }

    private void addActionListeners() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void openMainForm() {
        mf.setVisible(true);
    }
    
    
}

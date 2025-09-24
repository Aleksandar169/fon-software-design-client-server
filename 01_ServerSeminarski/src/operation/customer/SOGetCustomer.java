/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.customer;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Odo;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOGetCustomer extends SystemOperation{
    private Odo customer;

    public Odo getCustomer() {
        return customer;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Customer;
    }

    @Override
    public boolean execute(Odo odo) {
        
        try {
            customer=broker.getObject(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOGetCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}

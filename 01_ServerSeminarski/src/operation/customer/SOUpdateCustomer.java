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
public class SOUpdateCustomer extends SystemOperation{

    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Customer;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            return broker.edit(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOUpdateCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

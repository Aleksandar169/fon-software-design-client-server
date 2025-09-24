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
import operation.place.SODeletePlace;

/**
 *
 * @author Lenovo
 */
public class SODeleteCustomer extends SystemOperation{

    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof Customer){
            return true;
        }return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            return broker.delete(odo);
        } catch (Exception ex) {
            Logger.getLogger(SODeleteCustomer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

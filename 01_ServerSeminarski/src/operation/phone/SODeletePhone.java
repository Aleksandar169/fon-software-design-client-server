/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.phone;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Phone;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SODeletePhone extends SystemOperation{

    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof Phone){
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        
        try {
            return broker.delete(odo);
        } catch (Exception ex) {
            Logger.getLogger(SODeletePhone.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

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
public class SOAddPhone extends SystemOperation{
    private int id;

    public int getId() {
        return id;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof Phone)
            return true;
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        
        try {
            id=broker.add(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOAddPhone.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(id>0) return true;
        return false;
    }
    
}

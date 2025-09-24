/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.place;

import databse.DBBroker;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Place;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOAddPlace extends SystemOperation{
        int id;
    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof Place)
            return true;
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        
        try {
            id=broker.add(odo);
            
        } catch (Exception ex) {
            Logger.getLogger(SOAddPlace.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(id>0)
            return true;
        return false;
    }

    public int getId() {
        return id;
    }
    
    
}

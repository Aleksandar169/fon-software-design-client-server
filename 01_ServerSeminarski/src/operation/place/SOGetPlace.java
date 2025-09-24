/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.place;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Place;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOGetPlace extends SystemOperation {
    private Odo place;
    @Override
    public boolean checkLimits(Odo odo) {
        if (odo instanceof Place) {
           
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            place=(Place) broker.getObject(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOGetPlace.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public Odo getPlace() {
        return place;
    }
    
   

}

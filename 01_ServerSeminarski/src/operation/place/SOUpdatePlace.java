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
public class SOUpdatePlace extends SystemOperation{

    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Place;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            return broker.edit(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOUpdatePlace.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            }
        
    }
    
}

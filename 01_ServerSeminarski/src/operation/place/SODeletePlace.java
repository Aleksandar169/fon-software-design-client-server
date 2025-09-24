/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.place;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Place;
import operation.SystemOperation;
import operation.phone.SODeletePhone;

/**
 *
 * @author Lenovo
 */
public class SODeletePlace extends SystemOperation{

    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof Place){
            return true;
        }return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            return broker.delete(odo);
        } catch (Exception ex) {
            Logger.getLogger(SODeletePlace.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

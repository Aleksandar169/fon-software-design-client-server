/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Worker;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOUpdateWorker extends SystemOperation{

    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof Worker){
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            return broker.edit(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOUpdateWorker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

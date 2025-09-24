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
public class SOAddWorker extends SystemOperation {
    private int id;

    public int getId() {
        return id;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        if (odo instanceof Worker) {
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        
        try {
            id = broker.add(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOAddWorker.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (id > 0) {
            return true;
        }
        return false;

    }

}

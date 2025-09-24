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
public class SOGetWorker  extends SystemOperation{
    private Odo worker;

    public Odo getWorker() {
        return worker;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Worker;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            worker=broker.getObject(odo); 
        } catch (Exception ex) {
            Logger.getLogger(SOGetWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}

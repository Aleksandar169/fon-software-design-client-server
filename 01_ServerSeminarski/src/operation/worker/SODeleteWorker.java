/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.ProfessionalDegree;
import model.WP;
import model.Worker;
import operation.SystemOperation;
import operation.phone.SODeletePhone;

/**
 *
 * @author Lenovo
 */
public class SODeleteWorker extends SystemOperation {

    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof Worker) {
            return true;
        }return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            List<Odo> list=broker.getAllJoin(new WP(null, (Worker) odo, null));
            
            for (Odo odo1 : list) {
                broker.delete(odo1);               
            }
                broker.delete(odo);
                return true;
                
        } catch (Exception ex) {
            Logger.getLogger(SODeleteWorker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}

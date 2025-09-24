/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pd;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.ProfessionalDegree;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOUpdatePD extends SystemOperation {
    boolean fleg;

    public boolean isFleg() {
        return fleg;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        if (odo instanceof ProfessionalDegree) {
            return true;
        }
        return false;

    }

    @Override
    public boolean execute(Odo odo) {
        try {
            fleg=broker.edit(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOUpdatePD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fleg;
    }

}

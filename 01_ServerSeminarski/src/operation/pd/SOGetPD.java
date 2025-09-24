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
public class SOGetPD extends SystemOperation{
    ProfessionalDegree pd;

    public ProfessionalDegree getPd() {
        return pd;
    }

    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof ProfessionalDegree){
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            pd=(ProfessionalDegree) broker.getObject(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOGetPD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(pd!=null){
            return true;
        }
        return false;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.wp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.WP;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOGetWPs extends SystemOperation {
    List<Odo> list=new ArrayList<>();

    public List<Odo> getList() {
        return list;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        if (odo instanceof WP) {
            return true;
            
        }
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            list=broker.getAllJoin(odo);
             return true;
        } catch (Exception ex) {
            Logger.getLogger(SOGetWPs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }

}

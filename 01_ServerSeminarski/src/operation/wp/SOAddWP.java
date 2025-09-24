/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.wp;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.WP;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOAddWP extends SystemOperation {

    int id ;

    public int getId() {
        return id;
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
            id = broker.add(odo);
            id=1;
        } catch (Exception ex) {
            Logger.getLogger(SOAddWP.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (id == 0) {
            return false;
        }
        return true;

    }

}

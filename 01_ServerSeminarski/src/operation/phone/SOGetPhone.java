/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.phone;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Phone;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOGetPhone extends SystemOperation{
    private Odo phone;

    public Odo getPhone() {
        return phone;
    }

    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Phone;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            phone=broker.getObject(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOGetPhone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    
}

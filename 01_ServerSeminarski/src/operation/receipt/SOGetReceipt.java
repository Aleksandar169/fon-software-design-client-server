/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.receipt;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Receipt;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOGetReceipt extends SystemOperation {

    Odo receipt;

    public Odo getReceipt() {
        return receipt;
    }

    @Override
    public boolean checkLimits(Odo odo) {
        if (odo instanceof Receipt) {
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            receipt = broker.getObject(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOGetReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (receipt != null) {
            return true;
        }
        return false;
    }

}

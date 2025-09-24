/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.customer;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Odo;
import operation.SystemOperation;
import operation.worker.SOAddWorker;

/**
 *
 * @author Lenovo
 */
public class SOAddCustomer extends SystemOperation {

    private int id;

    public int getId() {
        return id;
    }

    @Override
    public boolean checkLimits(Odo odo) {
        if (odo instanceof Customer c) {
            if (c.getName() == null || c.getLastname() == null || c.getNumber() == null || c.getPlace() == null
                    || c.getName().isEmpty() || c.getLastname().isEmpty() || c.getNumber().isEmpty() ) {
                return false;
            }
            return true;
        }else {
            return false;
        }
       // return true;
    }

    @Override
    public boolean execute(Odo odo) {

        try {
            id = broker.add(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOAddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (id > 0) {
            return true;
        }
        return false;

    }

}

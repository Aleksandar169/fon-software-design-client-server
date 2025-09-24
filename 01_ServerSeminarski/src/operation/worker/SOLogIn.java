/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import com.mysql.cj.protocol.Warning;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Worker;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOLogIn extends SystemOperation {

    private Worker worker = null;

    public Worker getWorker() {
        return worker;
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
            Worker login = (Worker) odo;
            List<Odo> workersList = broker.getAll(odo);
            for (Odo o : workersList) {
                System.out.println("sisOP usao u for");
                Worker w = (Worker) o;
                if ((w.getUsername() == null ? login.getUsername() == null : w.getUsername().equals(login.getUsername())) && (w.getPassword() == null ? login.getPassword() == null : w.getPassword().equals(login.getPassword()))) {
                    worker = w;
                    return true;
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SOLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}

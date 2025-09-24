/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.worker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.WP;
import model.Worker;
import operation.SystemOperation;
import operation.place.SOGetPlaces;

/**
 *
 * @author Lenovo
 */
public class SOGetWorkers extends SystemOperation{
    private List<Odo> list=new ArrayList<>();
    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Worker;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            list= broker.getAll(odo);
            
            for (Odo odo1 : list) {
                Worker w=(Worker) odo1;
                WP wp=new WP(null, w, null);
                wp.setCondition(w);
                List<Odo> l=broker.getAllJoin(wp);
                
              /////// w.setWp(l);
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(SOGetWorkers.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(list==null) return false;
        return true;
    }

    public List<Odo> getList() {
        return list;
    }
    
    
}

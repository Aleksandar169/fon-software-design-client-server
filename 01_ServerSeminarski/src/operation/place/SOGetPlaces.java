/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.place;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Place;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOGetPlaces extends SystemOperation{
    
    private List<Odo> list = new ArrayList<>();
   
    public List<Odo> getList() {
        return list;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        if(odo instanceof Place)
            return true;
        return false;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            list= broker.getAllJoin(odo);
            System.out.println(list);
        } catch (Exception ex) {
            Logger.getLogger(SOGetPlaces.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(list==null) return false;
        return true;
    }
    
}

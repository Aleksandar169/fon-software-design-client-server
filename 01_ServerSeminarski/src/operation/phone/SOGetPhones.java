/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.phone;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Phone;
import operation.SystemOperation;
import operation.place.SOGetPlaces;

/**
 *
 * @author Lenovo
 */
public class SOGetPhones extends SystemOperation{
    private List<Odo> list=new ArrayList<>();

    public List<Odo> getList() {
        return list;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Phone;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            list= broker.getAll(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOGetPhones.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(list==null) return false;
        return true;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Odo;
import operation.SystemOperation;
import operation.place.SOGetPlaces;

/**
 *
 * @author Lenovo
 */
public class SOGetCustomers extends SystemOperation{
    private List<Odo> list=new ArrayList<>();

    public List<Odo> getList() {
        return list;
    }
    
    
    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Customer;
    }

    @Override
    public boolean execute(Odo odo) {
         try {
            list= broker.getAllJoin(odo);
        } catch (Exception ex) {
            Logger.getLogger(SOGetCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(list==null) return false;
        return true;
    }
    
}

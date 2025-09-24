/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.source.util.DocTrees;
import communication.Operation;
import java.util.List;
import model.Odo;
import model.Phone;
import model.Place;

/**
 *
 * @author Lenovo
 */
public class PhoneController extends ClientController{
    
    private static PhoneController instance;

    private PhoneController() {
    }
    
    public static PhoneController getInstance(){
        if(instance == null) return new PhoneController();
        return instance;
    }

    public int addPhone(Phone p) throws Exception {
        return (int) sendRequest(Operation.ADD_PHONE, p);
    }
    public List<Odo> getPhones() throws Exception {
        return (List<Odo>) sendRequest(Operation.SHOW_PHONES, null);
    }
    
    public void deletePhone(Phone phone) throws Exception{
        sendRequest(Operation.DELETE_PHONE, phone);
    }
    public Phone getPhone(Phone p) throws Exception{
        return (Phone) sendRequest(Operation.GET_PHONE, p);
    }
    
    public boolean updatePhone(Phone p) throws Exception{
        return (boolean) sendRequest(Operation.UPDATE_PHONE, p);
    }

    public List<Odo> searchPhone(String text) throws Exception {
        Phone p=new Phone();
        p.setCondition(text);
        return (List<Odo>) sendRequest(Operation.CONDITION_PHONE, p);
        
    }
    
    
}

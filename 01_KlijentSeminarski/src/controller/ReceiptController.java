/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import java.util.List;
import model.Odo;
import model.Receipt;

/**
 *
 * @author Lenovo
 */
public class ReceiptController extends ClientController{
    
    private static ReceiptController instance;

    private ReceiptController() {
    }
    
    public static ReceiptController getInstance(){
        if(instance==null) return new ReceiptController();
        return instance;
    }

    public int addReceipt(Receipt receipt) throws Exception {
       return (int) sendRequest(Operation.ADD_RECEIPT, receipt);
    }

    public List<Odo> getReceipts() throws Exception {
        return (List<Odo>) sendRequest(Operation.SHOW_RECEIPT, null);
    }

    public List<Odo> searchReceipt(Receipt receipt) throws Exception {
        //Receipt r=new Receipt();
        return (List<Odo>) sendRequest(Operation.CONDITION_RECEIPT, receipt); 
        
    }

    public boolean updateReceipt(Receipt r) throws Exception {
        return (boolean) sendRequest(Operation.UPDATE_RECEIPT, r);
    }
    
    public Receipt getReceipt(Receipt r) throws Exception {
        return (Receipt) sendRequest(Operation.GET_RECEIPT, r);
    }
    
    
    
    
}

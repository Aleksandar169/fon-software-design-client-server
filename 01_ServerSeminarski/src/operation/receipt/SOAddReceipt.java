/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.receipt;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Odo;
import model.Receipt;
import model.ReceiptItem;
import operation.SystemOperation;

/**
 *
 * @author Lenovo
 */
public class SOAddReceipt extends SystemOperation{
    
    private int id;

    public int getId() {
        return id;
    }
    
    @Override
    public boolean checkLimits(Odo odo) {
        return odo instanceof Receipt;
    }

    @Override
    public boolean execute(Odo odo) {
        try {
            Receipt r=(Receipt) odo;
            id=broker.add(r);
            r.setIdReceipt(id);
            if(r.getIdReceipt()<=0){
                return false;
            }
            List<ReceiptItem> list=r.getItems();
            
            for (ReceiptItem receiptItem : list) {
                receiptItem.setReceipt(r);
                int i=broker.add(receiptItem);
                if(i<=0){
                    return false;
                }
                
                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SOAddReceipt.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
}

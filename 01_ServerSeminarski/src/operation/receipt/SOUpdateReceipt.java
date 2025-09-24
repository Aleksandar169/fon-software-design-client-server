/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.receipt;

import java.util.ArrayList;
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
public class SOUpdateReceipt extends SystemOperation {

    Receipt r = new Receipt();

    @Override
    public boolean checkLimits(Odo odo) {
        return true;
    }

    @Override
    public boolean execute(Odo odo) {
        r = (Receipt) odo;
        try {
            broker.edit(r);
            List<Odo> itemsFromBase = new ArrayList<>();
            ReceiptItem ri = new ReceiptItem();
            ri.setReceipt(r);
            
            itemsFromBase = broker.getAllJoin(ri);
            System.out.println(itemsFromBase);
            for (ReceiptItem item : r.getItems()) {
                item.setReceipt(r);
                if (broker.getObject(item) != null) {
                    broker.edit(item);
                } else {
                    //Rednii brooj provjerii
                    broker.add(item);
                };
            }
            for (Odo i : itemsFromBase) {
                
                if (!r.getItems().contains(i)) {
                    broker.delete(i);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(SOUpdateReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}

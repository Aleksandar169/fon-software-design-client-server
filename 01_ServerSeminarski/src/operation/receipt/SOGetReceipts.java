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
public class SOGetReceipts extends SystemOperation {

    List<Odo> l = new ArrayList<>();

    public List<Odo> getL() {
        return l;
    }

    @Override
    public boolean checkLimits(Odo odo) {
        if (odo instanceof Receipt) {
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(Odo odo) {

        try {
            
            l = broker.getAllJoin(odo);
            for (Odo o : l) {
                Receipt r = (Receipt) o;
                ReceiptItem ri = new ReceiptItem();
                ri.setReceipt(r );
                List<Odo> olist = broker.getAllJoin(ri);
                List<ReceiptItem> l = new ArrayList<>();
                for (Odo opstiDomenskiObjekat : olist) {
                    ReceiptItem item = (ReceiptItem) opstiDomenskiObjekat;
                    l.add(item);
                }
                r.setItems(l);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(SOGetReceipts.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (l == null) {
            return false;
        }
        return true;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Odo;
import model.Place;
import model.ReceiptItem;

/**
 *
 * @author Lenovo
 */
public class TableModel<T extends Odo> extends AbstractTableModel{

    private List<T> list;
    private String[] columns;

    public TableModel(List<T> list) {
        this.list = list;
        if (list == null || list.size() == 0) {

        } else {
            columns = list.get(0).getColumnName();
        }
    }

    

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public int getColumnCount() {
        if(columns==null) return 0;
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] o = list.get(rowIndex).getObjectArray();
        return o[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public Odo getSelectedItem(int i) {
        return list.get(i);
    }
    

}

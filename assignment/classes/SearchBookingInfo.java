/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class SearchBookingInfo {
    
    private DefaultTableModel model;
    
    public void searchBookingInfo(String fileName,String keyword, JTable table){
        model = (DefaultTableModel) table.getModel();
        Object[][] data = ReadFile.readFile(fileName);
        Object[] firstLine = ReadFile.readFile(fileName, 1);
        ArrayList<Object[]> dataArrayList = new ArrayList<Object[]>();
        
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j].toString().contains(keyword)) {
                    dataArrayList.add(data[i]);
                    break;
                }
            }
        }
        
        Object[][] newData = new Object[dataArrayList.size()][];
        for (int i = 0; i < dataArrayList.size(); i++) {
            newData[i] = dataArrayList.get(i);
        }
        
        
        model.setRowCount(0);
        model = new DefaultTableModel(newData,firstLine){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table.setModel(model);
    }
    
}

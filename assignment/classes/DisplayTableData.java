/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class DisplayTableData {
    
    public void displayTableData(String fileName, JTable table) {
        Object[][] data = ReadFile.readFile(fileName);
        Object[] firstLine = ReadFile.readFile(fileName, 1);

        DefaultTableModel model = new DefaultTableModel(data,firstLine){
            @Override
            public boolean isCellEditable(int row, int column) {
            return false;
            }
        };
        
        table.setModel(model);
    }
}
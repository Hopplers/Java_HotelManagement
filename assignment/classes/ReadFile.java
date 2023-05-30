/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class ReadFile {
    public static Object[][] readFile(String fileName) {
        ArrayList<Object[]> data = new ArrayList<Object[]>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine())!= null) {
                String[] row = line.split(",");
                Object[] obj = new Object[row.length];
                System.arraycopy(row, 0, obj, 0, row.length);
                data.add(obj);
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        Object[][] dataArray = new Object[data.size() - 1][];
        for (int i = 1; i < data.size(); i++) {
            dataArray[i-1] = data.get(i);
        }

        return dataArray;
    }

    public static Object[] readFile (String fileName, int filerow){
        Object[] data = null;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            for(int i = 0; i < (filerow - 1); ++i){
                br.readLine();
            }
            String line = br.readLine();
            String[] row = line.split(",");
            data = row;
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return data;
    }
}

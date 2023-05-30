/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class RewriteFile {
    private Object[] firstLine;
    
    public void rewriteFile(String fileName, Object[][] newData){
        firstLine = ReadFile.readFile(fileName, 1);

        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("");
            
            fw = new FileWriter(fileName,true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            
            for (Object firstLine1 : firstLine) {
                bw.write((String) firstLine1 + ",");
            }
            bw.write("\n");
            
            for (Object[] row :newData){
                for (Object info : row){
                    bw.write((String) info + ",");
                }
                bw.write("\n");
            }
            
            bw.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

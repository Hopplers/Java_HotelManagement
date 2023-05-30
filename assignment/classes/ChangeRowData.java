/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

/**
 *
 * @author Acer
 */
public class ChangeRowData {
    
    private RewriteFile rewrite = new RewriteFile();
    private Object[][] data, newData;
    private int selectedRow = 0;
    
    public void deleteRowData(String fileName,String primaryKey){
        //fetch
        data = ReadFile.readFile(fileName);
        //to store new data 
        newData = new Object[data.length - 1][data[0].length];
        //find booking id
        for (int i = 0; i < data.length; i++) {
            String firstColumn = data[i][0].toString();
            if (firstColumn.equals(primaryKey)){
                selectedRow = i;
            }
        }
        //rewrite data in array
        int newDataRow = 0;
        for(int i = 0; i < data.length; i++){
            if(i != selectedRow){
                //deleted row not written
                System.arraycopy(data[i], 0, newData[newDataRow], 0, data[i].length);
                newDataRow++;
            }
        }
        
        
        //replace textfile data 
        rewrite.rewriteFile(fileName, newData);
    }
    
    public void editRowData(String fileName, String[] editedData){
        //fetch
        data = ReadFile.readFile(fileName);
        
        //find booking id
        for (int i = 0; i < data.length; i++) {
            String firstColumn = data[i][0].toString();
            if (firstColumn.equals(editedData[0])){
                selectedRow = i;
            }
        }
        
        if(editedData.length == 4)
            //when booking detail is chged
            for(int i = 1; i < 4 ; i++){
                data[selectedRow][i] = editedData[i];
        }else if (editedData.length == 6){
            //when customer detail chged
            for (int i = 4; i < 9; i++){
                data[selectedRow][i] = editedData[i-3];
            }
        }
        
        //replace textfile data 
        rewrite.rewriteFile(fileName, data);
    }
    
}

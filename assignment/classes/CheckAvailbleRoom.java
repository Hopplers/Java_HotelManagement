/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class CheckAvailbleRoom {
    
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private Date bookingCheckin,bookingCheckout;
            
    public void checkAvailableRoom(JTable table, Date cID, Date cOD){

        ArrayList<String[]> bookings = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Acer\\OneDrive\\Documents\\NetBeansProjects\\Assignment\\src\\assignment\\data\\Booking.txt"));
            String line;
            Boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                bookings.add(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        
        Set<String> unavailableRooms = new HashSet<>();//only shows repeatable unavailable once
        for (String[] booking : bookings) {
            String roomid = booking[3];
            try{
                bookingCheckin = formatter.parse(booking[1]);
                bookingCheckout = formatter.parse(booking[2]);

            }catch(ParseException e){
                JOptionPane.showMessageDialog(null, "Error : " + e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
            }

            if ((cID.compareTo(bookingCheckin) > 0 && cID.compareTo(bookingCheckout) <= 0)||
                (cOD.compareTo(bookingCheckin) > 0 && cOD.compareTo(bookingCheckout) <= 0)||
                (cID.compareTo(bookingCheckin) < 0 && cOD.compareTo(bookingCheckout) > 0)) {
                unavailableRooms.add(roomid);
                
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        ArrayList<String> roomList = new ArrayList<String>();
        String [] allRooms = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Acer\\OneDrive\\Documents\\NetBeansProjects\\Assignment\\src\\assignment\\data\\RoomID.txt"));
            String line;
            Boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                roomList.add(line);
            }
            br.close();
            
            allRooms = roomList.toArray(new String[roomList.size()]);
            
            
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        for (String roomid : allRooms) {
            if (!unavailableRooms.contains(roomid)) {
                Object[] rowData = {roomid};
                model.addRow(rowData);
            }
        }


    }

}

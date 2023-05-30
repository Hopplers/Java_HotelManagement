/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

import assignment.MainPage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class GenerateReceipt {
    
    public static String generateReceipt(String cID, String cOD, String rID, String name, String c, String e, String iCP, String nat){
        StringBuilder sb = new StringBuilder();
        double roomCharges, tourismTax = 0,total, serviceTax,netTotal;
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dateTimeNow = now.format(formatter);
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date CIDate = null, CODate = null;
        try {
            CIDate = format.parse(cID);
            CODate = format.parse(cOD);
        } catch (ParseException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long diffInMillies = Math.abs(CODate.getTime() - CIDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        
        if (nat.equals("Foreigner")){
        roomCharges = (int)diff * 350;
        tourismTax = (int)diff * 10;
        total = roomCharges + tourismTax;
        serviceTax = 0.1 * (total);
        netTotal = roomCharges + tourismTax + serviceTax;
        }
        else{
        roomCharges = (int)diff * 350;
        tourismTax = 0;
        total = roomCharges + tourismTax;
        serviceTax = 0.1 * (total);
        netTotal = roomCharges + tourismTax + serviceTax;
        }
        
        sb.append("\n                                           RECEIPT \n");
        sb.append("The Deuce Hotel                                                          Issued On : \n");
        sb.append("Jalan 1/ 1                                                           ").append(dateTimeNow).append("\n");
        sb.append("47600 Subang Jaya, Selangor \n");
        sb.append("*******************************************************************************\n");
        sb.append("Customer's Information : \n");
        sb.append("Name                : ").append(name).append("\n");
        sb.append("Contact Number : ").append(c).append("\n");
        sb.append("Email                 : ").append(e).append("\n");
        sb.append("________________________________________________________________________________\n");
        sb.append("Booking Detail : \n");
        sb.append("Check-In Date    : ").append(cID).append("\n");
        sb.append("Check-Out Date : ").append(cOD).append("\n");
        sb.append("Room ID           : ").append(rID).append("\n");
        sb.append("________________________________________________________________________________\n");
        sb.append("                                                         Room Charges : RM ").append(roomCharges).append("\n");
        sb.append("                                                         Tourism Tax     : RM ").append(tourismTax).append("\n");
        sb.append("                                                         ___________________________________\n");
        sb.append("                                                         Total                : RM ").append(total).append("\n");
        sb.append("                                                         Serv. Tax 10%   : RM ").append(serviceTax).append("\n");
        sb.append("                                                         ___________________________________\n");
        sb.append("                                                         Net Total          : RM ").append(netTotal).append("\n");
        
        
        String string = sb.toString();
        
        
        
        return string;
    }
}

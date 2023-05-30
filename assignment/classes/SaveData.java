/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Acer
 */
public class SaveData {
    private String BookingID;
    private String CheckInDate;
    private String CheckOutDate;
    private String RoomID;
    private String Name;
    private String ContactNumber;
    private String Email;
    private String ICPassport;
    private String Nationality;
    
    public SaveData(String bID, String cID, String cOD, String rID, String name, String c, String e, String iCP, String nat){
        BookingID = bID;
        CheckInDate = cID;
        CheckOutDate = cOD;
        RoomID = rID;
        Name = name;
        ContactNumber = c;
        Email = e;
        ICPassport = iCP;
        Nationality = nat;  
    }
    
    public String saveData(){
        try{
            FileWriter fw = new FileWriter("C:\\Users\\Acer\\OneDrive\\Documents\\NetBeansProjects\\Assignment\\src\\assignment\\data\\Booking.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(BookingID + "," + CheckInDate + "," + CheckOutDate + "," + RoomID + "," + Name + "," + ContactNumber + "," + Email + "," + ICPassport + "," + Nationality);
            pw.close();
            return "Success";
            
        }
        catch (Exception e)
        {
            return e.toString();
            
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.classes;

/**
 *
 * @author Acer
 */
class IsEmpty{
    public static boolean isEmpty(String input){
        return input.equals("");
    }
}

class IsAlphabetical extends IsEmpty{
    public static boolean isAlphabetical(String input){
        return input.matches("[a-zA-Z ]+");
    }
}

class IsNumeric extends IsEmpty{
    public static boolean isNumeric(String input){
        return input.matches("\\d+");
    }
}

class IsEmail extends IsEmpty{
    public static boolean isEmail(String input){
        return input.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");
    }
}

class IsAlphaNumeric extends IsEmpty{
    public static boolean isAlphaNumeric(String input){
        return input.matches("[a-zA-Z0-9]+");
    }
}


public class Validation {
    
    public static boolean alphabetValidation(String input){
        return !IsAlphabetical.isEmpty(input) && IsAlphabetical.isAlphabetical(input);
    }
    
    public static boolean numberValidation(String input){
        return !IsNumeric.isEmpty(input) && IsNumeric.isNumeric(input);
    }
    
    public static boolean emailValidation(String input){
        return !IsEmail.isEmpty(input) && IsEmail.isEmail(input);
    }
    
    public static boolean passportValidation(String input){
        return !IsAlphaNumeric.isEmpty(input) && IsAlphaNumeric.isAlphaNumeric(input);
    }
}

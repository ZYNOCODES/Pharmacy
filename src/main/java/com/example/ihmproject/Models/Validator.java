package com.example.ihmproject.Models;


import javax.swing.*;

public class Validator {

    public boolean isValidInteger(String str)
    {
        int a;
        try {
            a = Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a number","warning", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean isValidFloat(String str)
    {
        float a;
        try {
            a = Float.parseFloat(str);
            return true;
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a number","warning",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean isStringValid(String str)
    {
        if(str.trim().isEmpty()){
            return false;
        }
        else{
            return true;
        }


    }

}


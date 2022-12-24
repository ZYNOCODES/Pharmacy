package com.example.ihmproject;


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
        //when I cancel or remove or apdate: the textfields get null value (TextField.setText(null))
        if (str == null){
            return false;
        }
        //when the textfields are empty
        if(str.trim().isEmpty()){
            return false;
        }
        else{
            return true;
        }


    }

}


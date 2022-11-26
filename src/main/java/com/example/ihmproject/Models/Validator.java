package com.example.ihmproject.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;

/**
 *
 * @author Neha Ghate
 */
public class Validator {

    public boolean isValidInteger(String str)
    {
        int a;
        try {
            a = Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a number","warning",JOptionPane.ERROR_MESSAGE);
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


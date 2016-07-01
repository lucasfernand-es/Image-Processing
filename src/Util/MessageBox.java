package Util;

import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucasfernandes
 */
public class MessageBox {
    
    public static void showMessage(String message, String title, int type)
    {
        JOptionPane.showMessageDialog(null, message, title, type);
    }
    
}

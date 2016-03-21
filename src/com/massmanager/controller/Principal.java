/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.controller;

import com.massmanager.swing.model.LoginModel;
import com.massmanager.swing.view.LoginView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Artsk
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginView view = new LoginView(null, true);
        new LoginModel(view);
        view.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        
        view.pack();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
       
    }
}

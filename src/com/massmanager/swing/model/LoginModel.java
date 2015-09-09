/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import com.massmanager.swing.view.AtencionesSpaMass;
import com.massmanager.swing.view.LoginView;
import com.massmanager.swing.view.MenuMass;
import com.massmanager.swing.view.MenuSpa;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Artsk
 */
public class LoginModel implements ActionListener{
    private LoginView view;
    //Constructor
    public LoginModel(LoginView view) {
        this.view = view;
        addListener();
    }

    private void addListener() {
        view.getAceptar().addActionListener(this);
        view.getCancelar().addActionListener(this);
    }
    
    private void showMessage(String msg) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(view, msg);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getAceptar()){
            String user = view.getUsuario().getText();
            String password = view.getPassword().getText();
            if (user.trim().length() <= 0 && password.trim().length() <= 0){
                showMessage("Ingresa tu usuario y tu contraseña");
                view.getUsuario().requestFocus();
            } else if(user.trim().length() <= 0) {
                showMessage("Ingresa tu usuario");
                view.getUsuario().requestFocus();
            } else if(password.trim().length() <=0) {
                showMessage("Ingresa tu password");
                view.getPassword().requestFocus();
            } else if(user.equals("Arturo") || user.equals("arturo") && password.equals("skate")) {
                showMessage("Bienvenido a MassAdmin");
                MenuSpa spa = new MenuSpa();
                spa.setVisible(true);
                view.setVisible(false);
            } else if(user.equals("Patricio") || user.equals("patricio") && password.equals("skate")) {
                //showMessage("Bienvenido a MassAdmin");
                MenuMass mass = new MenuMass();
                mass.setVisible(true);
                view.setVisible(false);    
            } else {
                showMessage("Usuario o contraseña Incorrectos");
            }
            return;
        }
            if (e.getSource() == view.getCancelar()){
            System.exit(0);
            return;
        }
    }
}


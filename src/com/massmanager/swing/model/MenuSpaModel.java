/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import java.awt.event.ActionListener;
import com.massmanager.swing.view.MenuSpa;
import com.sun.javafx.application.PlatformImpl;
import java.awt.event.ActionEvent;
import com.massmanager.swing.model.Conexion;
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Artsk
 */
public class MenuSpaModel implements ActionListener{
    private MenuSpa menuspa;
    //Constructor
    public MenuSpaModel(MenuSpa menuspa){
        this.menuspa = menuspa;
        addListener();
    }
    
    private void addListener() {
        menuspa.getBtnCorreo().addActionListener(this);
        menuspa.getBtnGuardar().addActionListener(this);
    }
    
    private void showMessage(String msg) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(menuspa, msg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int a = 1;
        if (e.getSource() == menuspa.getBtnCorreo()){
            //Codigo para enviar correo.
            
            showMessage("Hola que hace" +a);
        }else if (e.getSource() == menuspa.getBtnGuardar()){
            //Codigo que crea EXCEL con los datos de la atencion
            showMessage("Hola que hace"+a);
    }else {
            
        }
    }

   
    
}

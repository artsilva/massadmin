/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import com.massmanager.swing.view.MenuMass;
import com.massmanager.swing.view.MenuMassAnual;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Artsk
 */
public class MenuMassModel implements ActionListener{
    private MenuMass menumass;
    //Constructor
    public MenuMassModel(MenuMass menumass) {
        this.menumass = menumass;
    }
    
    private void addListener(){
        menumass.getBtnAnual().addActionListener(this);
        menumass.getBtnMensual().addActionListener(this);
        menumass.getBtnPeriodico().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        }
           
    }
    
    


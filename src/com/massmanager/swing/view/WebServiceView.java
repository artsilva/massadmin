/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.view;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

/**
 *
 * @author Artsk
 */
public class WebServiceView extends javax.swing.JFrame {

    JProgressBar barraProgreso;
    JFrame WebServiceView;

    /**
     * Creates new form WebServiceView2
     */

    public WebServiceView() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Artsk\\Documents\\NetBeansProjects\\massadmin\\massadmin.png"));        
        setLocationRelativeTo(null);
        btnAceptar.setVisible(false);
        progressAnual.setForeground(new Color(79, 160, 240));
        progressAnual.setBackground(new Color(255,255,255));
        UIManager.put("ScrollBar.background", (new Color(255, 255, 255)));
        
        barraProgreso = this.progressAnual;
        barraProgreso.setStringPainted(true);
        try {
        Thread t = new Thread() {
            @Override
            public void run() {
                // textField_t.setText(YOUR TEXT);
                for (int i = 0; i < 900000000; i++) {
                    if (i == 899999999) {
                        for (int j = 0; j < 900000000; j++) {
                            if (j == 899999999) {
                                for (int k = 0; k < 900000000; k++) {
                                    if (k == 899999999) {
                                        for (int l = 0; l < 900000000; l++) {
                                            if (l == 899999999) {
                                                txtActualizacion.setText("Descargando actualizaciones");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(8);
                } catch (Exception e) {
                }
                barraProgreso.setMaximum(5);
                for (int i = 0; i < 900000000; i++) {
                    if (i == 799999999) {
                        txtDescarga.setText("95587321, 9, 2, 2, 2015-05-03, Logistica, 8, 2, 1, 2, Se deriva Achs, Se deriva Achs, Si, No");
                        barraProgreso.setValue(1);
                        for (int j = 0; j < 900000000; j++) {
                            if (j == 799999999) {
                                txtDescarga.setText("106657841, 2, 1, 1, 2016-04-04, Mesa de laminado, 1, 2, 9, 1, Aposito y presion para cortar hemorragia, Se deriva a ACHS, Si, No");
                                barraProgreso.setValue(2);
                                for (int k = 0; k < 900000000; k++) {
                                    if (k == 799999999) {
                                        txtDescarga.setText("145879365, 1, 1, 1, 2015-05-04, Producción Corte, 2, 1, 9, 3, Se realiza curación., Se realiza procedimiento , No, No");
                                        barraProgreso.setValue(3);
                                        for (int l = 0; l < 900000000; l++) {
                                            if (l == 799999999) {
                                                txtDescarga.setText("116654110, 16, 4, 3, 2015-04-26, Finanza, Dolor lumbar, 8, 2, 5, 2, Se administra analgesico , Se Deriva a puesto de trabajo, No, No");
                                                barraProgreso.setValue(4);
                                                for (int m = 0; m < 900000000; m++) {
                                                    if (m == 799999999) {
                                                        txtDescarga.setText("154785219, 3, 1, 1, 2015-05-05, Horno, 7, 2, 1, 2, Se realiza curación y se administa analgesico, Se deriva a puesto de trabajo, No, No");
                                                        barraProgreso.setValue(5);
                                                        btnAceptar.setVisible(true);
                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
                txtDescarga.setText("Ha finalizado la descarga.");
            }
        };
        t.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWS = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        progressAnual = new javax.swing.JProgressBar();
        txtDescarga = new javax.swing.JLabel();
        txtActualizacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizador de Atenciones");
        setBackground(new java.awt.Color(255, 255, 255));

        panelWS.setBackground(new java.awt.Color(255, 255, 255));
        panelWS.setMinimumSize(new java.awt.Dimension(400, 111));

        btnAceptar.setBackground(new java.awt.Color(232, 243, 253));
        btnAceptar.setText("Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        progressAnual.setBackground(new java.awt.Color(255, 255, 255));

        txtDescarga.setBackground(new java.awt.Color(255, 255, 255));

        txtActualizacion.setBackground(new java.awt.Color(255, 255, 255));
        txtActualizacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtActualizacion.setText("Comprobando Actualizaciones");

        javax.swing.GroupLayout panelWSLayout = new javax.swing.GroupLayout(panelWS);
        panelWS.setLayout(panelWSLayout);
        panelWSLayout.setHorizontalGroup(
            panelWSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressAnual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelWSLayout.createSequentialGroup()
                        .addGroup(panelWSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelWSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtActualizacion, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(panelWSLayout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(btnAceptar)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelWSLayout.setVerticalGroup(
            panelWSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtActualizacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressAnual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:

        try {
            MenuMass mass = new MenuMass();
            mass.setVisible(true);
            btnAceptar.setVisible(false);
            this.setVisible(false);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel panelWS;
    private javax.swing.JProgressBar progressAnual;
    private javax.swing.JLabel txtActualizacion;
    private javax.swing.JLabel txtDescarga;
    // End of variables declaration//GEN-END:variables

}

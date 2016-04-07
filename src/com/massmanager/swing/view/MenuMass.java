/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.view;

import com.massmanager.controller.Usuarios;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Artsk
 */
public class MenuMass extends javax.swing.JFrame {

    /**
     * Creates new form MenuMass
     */
    public MenuMass() {
        initComponents();
        setLocationRelativeTo(null);
        
        grupoPrimero.add(rdGraficos);
        grupoPrimero.add(rdReportes);
        Usuarios user = new Usuarios();
        this.jLabel1.setText("Bienvenido a MassAdmin " + user.getNombreUsuario());
        this.btnHistorico.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoPrimero = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rdReportes = new javax.swing.JRadioButton();
        rdGraficos = new javax.swing.JRadioButton();
        btnPeriodico = new javax.swing.JButton();
        btnMensual = new javax.swing.JButton();
        btnHistorico = new javax.swing.JButton();
        btnAnual = new javax.swing.JButton();
        desktopMass = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuDatos = new javax.swing.JMenu();
        menuAtenciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(93, 130, 189));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(93, 130, 189));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rdReportes.setBackground(new java.awt.Color(93, 130, 189));
        rdReportes.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        rdReportes.setForeground(new java.awt.Color(255, 255, 255));
        rdReportes.setSelected(true);
        rdReportes.setText("Reportes");
        rdReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdReportesMouseClicked(evt);
            }
        });

        rdGraficos.setBackground(new java.awt.Color(93, 130, 189));
        rdGraficos.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        rdGraficos.setForeground(new java.awt.Color(255, 255, 255));
        rdGraficos.setText("Gráficos");
        rdGraficos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdGraficos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdGraficosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdReportes)
                    .addComponent(rdGraficos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(rdReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdGraficos)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnPeriodico.setText("Periodico");
        btnPeriodico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPeriodico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodicoActionPerformed(evt);
            }
        });

        btnMensual.setText("Mensual");
        btnMensual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensualActionPerformed(evt);
            }
        });

        btnHistorico.setText("Historico");
        btnHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorico.setEnabled(false);
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        btnAnual.setText("Anual");
        btnAnual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMensual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPeriodico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnAnual, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPeriodico, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        desktopMass.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        desktopMass.setPreferredSize(new java.awt.Dimension(1180, 619));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/massmanager/swing/view/logolirquenGrande.jpg"))); // NOI18N

        javax.swing.GroupLayout desktopMassLayout = new javax.swing.GroupLayout(desktopMass);
        desktopMass.setLayout(desktopMassLayout);
        desktopMassLayout.setHorizontalGroup(
            desktopMassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopMassLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(162, 162, 162))
            .addGroup(desktopMassLayout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel2)
                .addContainerGap(568, Short.MAX_VALUE))
        );
        desktopMassLayout.setVerticalGroup(
            desktopMassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopMassLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(116, 116, 116)
                .addComponent(jLabel2)
                .addContainerGap(270, Short.MAX_VALUE))
        );
        desktopMass.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopMass.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(desktopMass, java.awt.BorderLayout.CENTER);

        menuDatos.setText("Datos");
        menuDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuDatos.setPreferredSize(new java.awt.Dimension(104, 19));
        menuDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDatosActionPerformed(evt);
            }
        });

        menuAtenciones.setText("Atenciones SPA");
        menuAtenciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAtencionesActionPerformed(evt);
            }
        });
        menuDatos.add(menuAtenciones);

        jMenuBar2.add(menuDatos);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensualActionPerformed
        // TODO add your handling code here:
        MenuMassMensual m = new MenuMassMensual();
        this.desktopMass.add(m);
        m.show();
        try {
            m.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        m.setVisible(true);
    }//GEN-LAST:event_btnMensualActionPerformed

    private void btnAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnualActionPerformed
        MenuMassAnual a = new MenuMassAnual();
        desktopMass.add(a);
        a.show();
        try {
            a.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MenuMass.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.setVisible(true);
        
    }//GEN-LAST:event_btnAnualActionPerformed

    private void btnPeriodicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodicoActionPerformed
        // TODO add your handling code here
        MenuMassPeriodico p = new MenuMassPeriodico();
        desktopMass.add(p);
        p.show();
        try {
            p.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MenuMass.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
    }//GEN-LAST:event_btnPeriodicoActionPerformed

    private void menuDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuDatosActionPerformed

    private void menuAtencionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAtencionesActionPerformed
        // TODO add your handling code here:
        AtencionesSpaMass a = new AtencionesSpaMass();
        desktopMass.add(a);
        try {
            a.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MenuMass.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.setVisible(true);
    }//GEN-LAST:event_menuAtencionesActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoricoActionPerformed

    private void rdReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdReportesMouseClicked
        // TODO add your handling code here:
        if (this.rdReportes.isSelected()){
            this.btnAnual.setVisible(true);
            this.btnMensual.setVisible(true);
            this.btnPeriodico.setVisible(true);
            this.btnHistorico.setVisible(true);
            MenuMassAnual a = new MenuMassAnual();
            desktopMass.add(a);
            try {
                a.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MenuMass.class.getName()).log(Level.SEVERE, null, ex);
            }
            a.setVisible(true);
        }
    }//GEN-LAST:event_rdReportesMouseClicked

    private void rdGraficosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdGraficosMouseClicked
        // TODO add your handling code here:
        if (rdGraficos.isSelected()){
            this.btnAnual.setVisible(false);
            this.btnMensual.setVisible(false);
            this.btnPeriodico.setVisible(false);
            this.btnHistorico.setVisible(false);
            MassGraficos g = new MassGraficos();
            desktopMass.add(g);
            try {
                g.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MenuMass.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.setVisible(true);
        }
    }//GEN-LAST:event_rdGraficosMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnual;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnMensual;
    private javax.swing.JButton btnPeriodico;
    private javax.swing.JDesktopPane desktopMass;
    private javax.swing.ButtonGroup grupoPrimero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem menuAtenciones;
    private javax.swing.JMenu menuDatos;
    private javax.swing.JRadioButton rdGraficos;
    private javax.swing.JRadioButton rdReportes;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAnual() {
        return btnAnual;
    }

    public void setBtnAnual(JButton btnAnual) {
        this.btnAnual = btnAnual;
    }

    public JButton getBtnMensual() {
        return btnMensual;
    }

    public void setBtnMensual(JButton btnMensual) {
        this.btnMensual = btnMensual;
    }

    public JButton getBtnPeriodico() {
        return btnPeriodico;
    }

    public void setBtnPeriodico(JButton btnPeriodico) {
        this.btnPeriodico = btnPeriodico;
    }
    
    public JDesktopPane getDesktopMass() {
        return desktopMass;
    }

    public void setDesktopMass(JDesktopPane desktopMass) {
        this.desktopMass = desktopMass;
    }

    public JRadioButton getRdGraficos() {
        return rdGraficos;
    }

    public void setRdGraficos(JRadioButton rdGraficos) {
        this.rdGraficos = rdGraficos;
    }

    public JRadioButton getRdReportes() {
        return rdReportes;
    }

    public void setRdReportes(JRadioButton rdReportes) {
        this.rdReportes = rdReportes;
    }

    public JButton getBtnHistorico() {
        return btnHistorico;
    }

    public void setBtnHistorico(JButton btnHistorico) {
        this.btnHistorico = btnHistorico;
    }

}


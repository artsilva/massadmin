/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.view;

import com.massmanager.swing.model.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Artsk
 */
public class MenuMassHistorico extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuMassHistorico
     */
    public MenuMassHistorico() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rdTipo = new javax.swing.JRadioButton();
        rdArea = new javax.swing.JRadioButton();
        rdSector = new javax.swing.JRadioButton();
        rdExtremidad = new javax.swing.JRadioButton();
        panelTipo = new javax.swing.JPanel();
        boxOpcion = new javax.swing.JComboBox();
        boxMes = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1180, 662));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP), "Filtro Primario"));
        jPanel3.setPreferredSize(new java.awt.Dimension(340, 129));

        rdTipo.setText("Tipo");
        rdTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTipoMouseClicked(evt);
            }
        });
        rdTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTipoActionPerformed(evt);
            }
        });

        rdArea.setText("Area");
        rdArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdAreaMouseClicked(evt);
            }
        });
        rdArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAreaActionPerformed(evt);
            }
        });

        rdSector.setText("Sector");
        rdSector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdSector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdSectorMouseClicked(evt);
            }
        });

        rdExtremidad.setText("Extremidad Afectada");
        rdExtremidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdExtremidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdExtremidadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdTipo)
                    .addComponent(rdSector)
                    .addComponent(rdExtremidad)
                    .addComponent(rdArea))
                .addGap(0, 177, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(rdTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdSector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdExtremidad))
        );

        panelTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro Secundario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)));
        panelTipo.setPreferredSize(new java.awt.Dimension(340, 129));

        boxOpcion.setEditable(true);
        boxOpcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxMes.setEditable(true);
        boxMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setText("Filtrar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/massmanager/swing/view/excel-icon.png"))); // NOI18N
        jButton2.setText("Exportar");
        jButton2.setPreferredSize(new java.awt.Dimension(61, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTipoLayout = new javax.swing.GroupLayout(panelTipo);
        panelTipo.setLayout(panelTipoLayout);
        panelTipoLayout.setHorizontalGroup(
            panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTipoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelTipoLayout.setVerticalGroup(
            panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atenciones Mensuales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP), "Atenciones Historicas"));
        jPanel2.setPreferredSize(new java.awt.Dimension(1130, 555));

        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(481, 481, 481)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/massmanager/swing/view/lirquen-logo-top.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTipoMouseClicked
        // TODO add your handling code here:
        this.boxOpcion.removeAllItems();
        Conexion cn = new Conexion();
        ResultSet rs2;
        rs2 = cn.ExtraerIncidente();
        try {
            while(rs2.next()){
                boxOpcion.addItem(rs2.getString("tipo"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdTipoMouseClicked

    private void rdTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTipoActionPerformed

    private void rdAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdAreaMouseClicked
        // TODO add your handling code here:
        this.boxOpcion.removeAllItems();
        Conexion cn = new Conexion();
        ResultSet rs3;
        rs3 = cn.ExtraerArea();
        try {
            while (rs3.next()) {
                this.boxOpcion.addItem(rs3.getString("nombre_area"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdAreaMouseClicked

    private void rdAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdAreaActionPerformed

    private void rdSectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdSectorMouseClicked
        // TODO add your handling code here:
        this.boxOpcion.removeAllItems();
        Conexion cn = new Conexion();
        ResultSet rs4;
        rs4 = cn.ExtraerSector();
        try {
            while (rs4.next()) {
                this.boxOpcion.addItem(rs4.getString("nombre_sector"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdSectorMouseClicked

    private void rdExtremidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdExtremidadMouseClicked
        // TODO add your handling code here:
        this.boxOpcion.removeAllItems();
        Conexion cn = new Conexion();
        ResultSet rs5;
        rs5 = cn.ExtraerExtremidad();
        try {
            while (rs5.next()) {
                this.boxOpcion.addItem(rs5.getString("nombre"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_rdExtremidadMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxMes;
    private javax.swing.JComboBox boxOpcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPanel panelTipo;
    private javax.swing.JRadioButton rdArea;
    private javax.swing.JRadioButton rdExtremidad;
    private javax.swing.JRadioButton rdSector;
    private javax.swing.JRadioButton rdTipo;
    // End of variables declaration//GEN-END:variables
}

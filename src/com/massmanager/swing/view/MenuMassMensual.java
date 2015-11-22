/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.view;

import com.massmanager.swing.model.AnchoColumnas;
import com.massmanager.swing.model.Conexion;
import com.massmanager.swing.model.QuerysMensuales;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Artsk
 */
public class MenuMassMensual extends javax.swing.JInternalFrame {
                            
    JTable grid;
    ResultSet rs;
    
    /**
     * Creates new form MenuMassMensual
     */
    public MenuMassMensual() {
        initComponents();
        //Configuracion Grilla Mensual principal(grdMensual)
        grdMensual.setAutoResizeMode(grdMensual.AUTO_RESIZE_OFF);
        grdMensual.doLayout();
        
        //Configuracion grupoPrimario RadioButton
        grupoPrimero.add(rdArea);
        grupoPrimero.add(rdExtremidad);
        grupoPrimero.add(rdSector);
        grupoPrimero.add(rdTipo);
        
        DefaultTableModel dfm = new DefaultTableModel();
        grid = this.grdMensual;
        grid.setModel(dfm);
        
        dfm.setColumnIdentifiers(new Object[]{ "ID", "Nombre", "Apellido", "Rut", "Sector", "Area", "Jefe Area", "Fecha", "Mes" , "Lugar Incidente", "Detalles" ,"Lesion", "Incidente", "Extremidad", "Paramedico", "Tratamiento", "Comentario" });
        
        QuerysMensuales query = new QuerysMensuales();
        rs = query.ExtraerAtencionesMensual();
        try{
            while(rs.next()){
                dfm.addRow(new Object[] { rs.getInt("id_atencion"), rs.getString("nombre"),rs.getString("apellido"),  rs.getInt("rut"), rs.getString("sector"), rs.getString("area"), rs.getString("jefe_area"),rs.getDate("fecha"), rs.getString("mes") , rs.getString("lugarincidente"), rs.getString("detalles"), rs.getString("lesion"), rs.getString("incidente"), rs.getString("extremidad"), rs.getString("paramedico"), rs.getString("tratamiento"), rs.getString("comentario") });
            }
        }catch(Exception e){
            
        }
        //Setea el ancho de las columnas con valores del Metodo de la Clase AnchoColumnas
        AnchoColumnas columna = new AnchoColumnas();
        columna.setAnchoColumnasMensual(grdMensual);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    //Metodo local para mostrar mensajes
    private void showMessage(String msg) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(grid, msg);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoPrimero = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelTipo = new javax.swing.JPanel();
        boxOpcion = new javax.swing.JComboBox();
        btnFiltrar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        boxMes = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        rdTipo = new javax.swing.JRadioButton();
        rdArea = new javax.swing.JRadioButton();
        rdSector = new javax.swing.JRadioButton();
        rdExtremidad = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        panelGrillasMensuales = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdMensual = new javax.swing.JTable();

        setTitle("Reportes Mensuales");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1180, 662));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1180, 662));

        panelTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro Secundario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)));
        panelTipo.setPreferredSize(new java.awt.Dimension(340, 129));

        boxOpcion.setEditable(true);
        boxOpcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnFiltrar.setText("Filtrar");
        btnFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/massmanager/swing/view/excel-icon.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        boxMes.setEditable(true);
        boxMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelTipoLayout = new javax.swing.GroupLayout(panelTipo);
        panelTipo.setLayout(panelTipoLayout);
        panelTipoLayout.setHorizontalGroup(
            panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTipoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelTipoLayout.setVerticalGroup(
            panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportar)
                    .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP), "Filtro Primario"));
        jPanel3.setPreferredSize(new java.awt.Dimension(340, 129));

        rdTipo.setText("Tipo");
        rdTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rdTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTipoMouseClicked(evt);
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
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdTipo)
                    .addComponent(rdSector)
                    .addComponent(rdExtremidad)
                    .addComponent(rdArea))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(rdTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdSector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdExtremidad))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Documentos, datos\\lirquen-logo-top.png")); // NOI18N

        panelGrillasMensuales.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atenciones Mensuales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)));
        panelGrillasMensuales.setPreferredSize(new java.awt.Dimension(1140, 465));

        grdMensual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grdMensual.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(grdMensual);
        if (grdMensual.getColumnModel().getColumnCount() > 0) {
            grdMensual.getColumnModel().getColumn(0).setResizable(false);
            grdMensual.getColumnModel().getColumn(1).setResizable(false);
            grdMensual.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout panelGrillasMensualesLayout = new javax.swing.GroupLayout(panelGrillasMensuales);
        panelGrillasMensuales.setLayout(panelGrillasMensualesLayout);
        panelGrillasMensualesLayout.setHorizontalGroup(
            panelGrillasMensualesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGrillasMensualesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGrillasMensualesLayout.setVerticalGroup(
            panelGrillasMensualesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGrillasMensualesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(panelGrillasMensuales, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGrillasMensuales, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(panelTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelGrillasMensuales, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        //Setea variables de la Query con el contenido del ComboBox
        String mes = (String) this.boxMes.getSelectedItem();
        String extremidad = (String) this.boxOpcion.getSelectedItem();
        String tipo = (String) this.boxOpcion.getSelectedItem();
        String area = (String) this.boxOpcion.getSelectedItem();
        String sector = (String) this.boxOpcion.getSelectedItem();
        
        grdMensual.setModel(new DefaultTableModel());
        QuerysMensuales query = new QuerysMensuales();
        DefaultTableModel dfm = new DefaultTableModel();
        AnchoColumnas columna = new AnchoColumnas();
        
        if (rdExtremidad.isSelected()) {
            ResultSet rsExtr = query.ExtraerAtencionMensualExtremidad(extremidad, mes);
            this.grdMensual.setModel(dfm);
            dfm.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido", "Rut", "Sector", "Area", "Jefe Area", "Fecha", "Mes", "Lugar Incidente", "Detalles", "Lesion", "Incidente", "Extremidad", "Paramedico", "Tratamiento", "Comentario"});
            try {
                while (rsExtr.next()) {
                    dfm.addRow(new Object[]{rsExtr.getInt("id_atencion"), rsExtr.getString("nombre"), rsExtr.getString("apellido"), rsExtr.getInt("rut"), rsExtr.getString("sector"), rsExtr.getString("area"), rsExtr.getString("jefe_area"), rsExtr.getDate("fecha"), rsExtr.getString("mes"), rsExtr.getString("lugarincidente"), rsExtr.getString("detalles"), rsExtr.getString("lesion"), rsExtr.getString("incidente"), rsExtr.getString("extremidad"), rsExtr.getString("paramedico"), rsExtr.getString("tratamiento"), rsExtr.getString("comentario")});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            columna.setAnchoColumnasMensual(grdMensual);
        }
        if (rdTipo.isSelected()) {
            ResultSet rsExtr = query.ExtraerAtencionMensualTipo(tipo, mes);
            this.grdMensual.setModel(dfm);
            dfm.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido", "Rut", "Sector", "Area", "Jefe Area", "Fecha", "Mes", "Lugar Incidente", "Detalles", "Lesion", "Incidente", "Extremidad", "Paramedico", "Tratamiento", "Comentario"});
            try {
                while (rsExtr.next()) {
                    dfm.addRow(new Object[]{rsExtr.getInt("id_atencion"), rsExtr.getString("nombre"), rsExtr.getString("apellido"), rsExtr.getInt("rut"), rsExtr.getString("sector"), rsExtr.getString("area"), rsExtr.getString("jefe_area"), rsExtr.getDate("fecha"), rsExtr.getString("mes"), rsExtr.getString("lugarincidente"), rsExtr.getString("detalles"), rsExtr.getString("lesion"), rsExtr.getString("incidente"), rsExtr.getString("extremidad"), rsExtr.getString("paramedico"), rsExtr.getString("tratamiento"), rsExtr.getString("comentario")});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            columna.setAnchoColumnasMensual(grdMensual);
        }
        if (rdArea.isSelected()) {
            ResultSet rsExtr = query.ExtraerAtencionMensualArea(area, mes);
            this.grdMensual.setModel(dfm);
            dfm.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido", "Rut", "Sector", "Area", "Jefe Area", "Fecha", "Mes", "Lugar Incidente", "Detalles", "Lesion", "Incidente", "Extremidad", "Paramedico", "Tratamiento", "Comentario"});
            try {
                while (rsExtr.next()) {
                    dfm.addRow(new Object[]{rsExtr.getInt("id_atencion"), rsExtr.getString("nombre"), rsExtr.getString("apellido"), rsExtr.getInt("rut"), rsExtr.getString("sector"), rsExtr.getString("area"), rsExtr.getString("jefe_area"), rsExtr.getDate("fecha"), rsExtr.getString("mes"), rsExtr.getString("lugarincidente"), rsExtr.getString("detalles"), rsExtr.getString("lesion"), rsExtr.getString("incidente"), rsExtr.getString("extremidad"), rsExtr.getString("paramedico"), rsExtr.getString("tratamiento"), rsExtr.getString("comentario")});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            columna.setAnchoColumnasMensual(grdMensual);
        }
        if (rdSector.isSelected()) {
            ResultSet rsExtr = query.ExtraerAtencionMensualSector(sector, mes);
            this.grdMensual.setModel(dfm);
            dfm.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido", "Rut", "Sector", "Area", "Jefe Area", "Fecha", "Mes", "Lugar Incidente", "Detalles", "Lesion", "Incidente", "Extremidad", "Paramedico", "Tratamiento", "Comentario"});
            try {
                while (rsExtr.next()) {
                    dfm.addRow(new Object[]{rsExtr.getInt("id_atencion"), rsExtr.getString("nombre"), rsExtr.getString("apellido"), rsExtr.getInt("rut"), rsExtr.getString("sector"), rsExtr.getString("area"), rsExtr.getString("jefe_area"), rsExtr.getDate("fecha"), rsExtr.getString("mes"), rsExtr.getString("lugarincidente"), rsExtr.getString("detalles"), rsExtr.getString("lesion"), rsExtr.getString("incidente"), rsExtr.getString("extremidad"), rsExtr.getString("paramedico"), rsExtr.getString("tratamiento"), rsExtr.getString("comentario")});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            columna.setAnchoColumnasMensual(grdMensual);
        }
        
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportarActionPerformed

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
        //Setea el Mes en el COmboBox de MES cuando se selecciona un radioButton
        ResultSet rs6;
        rs6 = cn.ExtraerMes();
        try {
            while (rs6.next()) {
                this.boxMes.addItem(rs6.getString("mes_msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_rdTipoMouseClicked

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
        //Setea el Mes en el COmboBox de MES cuando se selecciona un radioButton
        ResultSet rs6;
        rs6 = cn.ExtraerMes();
        try {
            while (rs6.next()) {
                this.boxMes.addItem(rs6.getString("mes_msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        //Setea el Mes en el COmboBox de MES cuando se selecciona un radioButton
        ResultSet rs6;
        rs6 = cn.ExtraerMes();
        try {
            while (rs6.next()) {
                this.boxMes.addItem(rs6.getString("mes_msg"));
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
        //Setea el Mes en el COmboBox de MES cuando se selecciona un radioButton
        ResultSet rs6;
        rs6 = cn.ExtraerMes();
        try {
            while (rs6.next()) {
                this.boxMes.addItem(rs6.getString("mes_msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_rdExtremidadMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxMes;
    private javax.swing.JComboBox boxOpcion;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JTable grdMensual;
    private javax.swing.ButtonGroup grupoPrimero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGrillasMensuales;
    private javax.swing.JPanel panelTipo;
    private javax.swing.JRadioButton rdArea;
    private javax.swing.JRadioButton rdExtremidad;
    private javax.swing.JRadioButton rdSector;
    private javax.swing.JRadioButton rdTipo;
    // End of variables declaration//GEN-END:variables
}

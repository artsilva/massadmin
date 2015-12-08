    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.view;

import com.massmanager.swing.model.PropiedadesColumnas;
import com.massmanager.swing.model.Conexion;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Artsk
 */
public class AtencionesSpaMass extends javax.swing.JInternalFrame {
    JTable grid;
    ResultSet rs;
    /**
     * Creates new form AtencionesSpaMass
     */
    public AtencionesSpaMass() {
        initComponents();
    
        DefaultTableModel dfm = new DefaultTableModel();
        grid = this.grdAtenciones;
        grid.setModel(dfm);
        
        dfm.setColumnIdentifiers(new Object[]{ "ID Atencion", "Rut Trabajador", "Sector", "Area", "Jefe Area", "Fecha", "Lesion", "Incidente", "Extremidad", "Paramedico" });
    
        Conexion cn = new Conexion();
        rs = cn.ExtraerAtencionesDiarias();
        try{
            while(rs.next()) {
                dfm.addRow(new Object[]{ rs.getInt("id_atencion"), rs.getInt("rut_trabajador"), rs.getString("sector"), rs.getString("area"), rs.getString("jefe_area"),rs.getDate("fecha"), rs.getString("lesion"), rs.getString("incidente"), rs.getString("etremidad_afectada"), rs.getString("paramedico") });
            }
        }catch(Exception e){
            
        }
        
        PropiedadesColumnas columna = new PropiedadesColumnas();
        columna.setPropiedadesCabeceras(grdAtenciones);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenuMassPrueba = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdAtenciones = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1180, 662));

        panelMenuMassPrueba.setPreferredSize(new java.awt.Dimension(1180, 662));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atenciones del Mes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)));

        grdAtenciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grdAtenciones.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(grdAtenciones);
        if (grdAtenciones.getColumnModel().getColumnCount() > 0) {
            grdAtenciones.getColumnModel().getColumn(0).setResizable(false);
            grdAtenciones.getColumnModel().getColumn(1).setResizable(false);
            grdAtenciones.getColumnModel().getColumn(2).setResizable(false);
            grdAtenciones.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/massmanager/swing/view/excel-icon.png"))); // NOI18N
        jButton2.setText("Exportar");

        javax.swing.GroupLayout panelMenuMassPruebaLayout = new javax.swing.GroupLayout(panelMenuMassPrueba);
        panelMenuMassPrueba.setLayout(panelMenuMassPruebaLayout);
        panelMenuMassPruebaLayout.setHorizontalGroup(
            panelMenuMassPruebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuMassPruebaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuMassPruebaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMenuMassPruebaLayout.setVerticalGroup(
            panelMenuMassPruebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuMassPruebaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuMassPrueba, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenuMassPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable grdAtenciones;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMenuMassPrueba;
    // End of variables declaration//GEN-END:variables
}

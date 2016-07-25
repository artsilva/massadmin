/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.view;

import com.massmanager.controller.Atencion;
import com.massmanager.controller.Trabajador;
import com.massmanager.swing.model.Conexion;
import com.massmanager.swing.model.EnviadorMail;
import com.massmanager.swing.model.FechaHora;
import com.massmanager.swing.model.Utils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Artsk
 */
public class MenuSpaNuevo extends javax.swing.JFrame {

    /**
     * Creates new form MenuSpaNuevo
     */
    public MenuSpaNuevo() {
        initComponents();
        setLocationRelativeTo(null);
        
        this.boxLesion.removeAllItems();
        this.boxIncidente.removeAllItems();
        this.boxExtremidad.removeAllItems();
        this.boxParamedico.removeAllItems();
        
        Conexion cn = new Conexion();
        ResultSet rs;
        //btnLesion
        rs = cn.ExtraerLesion();
        try{
            while(rs.next()){
                boxLesion.addItem(rs.getString("lesion"));
            }
        }catch(SQLException e){  
            e.printStackTrace();
        }
        //btnIncidente
        rs = cn.ExtraerIncidente();
        try{
            while(rs.next()){
                boxIncidente.addItem(rs.getString("tipo"));
            }
        }catch(SQLException e){ 
            e.printStackTrace();
        }
        //btnExtremidad
        rs = cn.ExtraerExtremidad();
        try{
            while(rs.next()){
                boxExtremidad.addItem(rs.getString("nombre"));
            }
        }catch(SQLException e){ 
            e.printStackTrace();
        }
        //btnParamedico
        rs = cn.ExtraerParamedico();
        try{
            while(rs.next()){
                boxParamedico.addItem(rs.getString("nombre_paramedico"));
            }
        }catch(SQLException e){ 
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblRut = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblSector = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        lblLugar = new javax.swing.JLabel();
        lblJefe = new javax.swing.JLabel();
        lblDeriva = new javax.swing.JLabel();
        lblDeriva1 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtSector = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtJefe = new javax.swing.JTextField();
        txtLugar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        boxDeriva = new javax.swing.JComboBox();
        boxControl = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblLesion = new javax.swing.JLabel();
        lblIncidente = new javax.swing.JLabel();
        lblExtremidad = new javax.swing.JLabel();
        lblParamedico = new javax.swing.JLabel();
        lblDetalles = new javax.swing.JLabel();
        lblTto = new javax.swing.JLabel();
        lblComentario = new javax.swing.JLabel();
        txtDetalles = new javax.swing.JTextField();
        txtTto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaComentario = new javax.swing.JTextPane();
        boxLesion = new javax.swing.JComboBox();
        boxIncidente = new javax.swing.JComboBox();
        boxExtremidad = new javax.swing.JComboBox();
        boxParamedico = new javax.swing.JComboBox();
        btnCorreo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuTrabajador = new javax.swing.JMenuItem();
        menuPatologia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/massmanager/swing/view/lirquen-logo-top.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)), "Datos Atención", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 10))); // NOI18N

        lblRut.setText("Rut");

        lblNombre.setText("Nombre");

        lblSector.setText("Sector");

        lblArea.setText("Area");

        lblLugar.setText("Jefe de Area");

        lblJefe.setText("Lugar");

        lblDeriva.setText("Deriva");

        lblDeriva1.setText("Control");

        txtRut.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(250, 250, 250));

        txtSector.setEditable(false);
        txtSector.setBackground(new java.awt.Color(250, 250, 250));

        txtArea.setEditable(false);
        txtArea.setBackground(new java.awt.Color(250, 250, 250));

        txtJefe.setEditable(false);
        txtJefe.setBackground(new java.awt.Color(250, 250, 250));

        txtLugar.setToolTipText("");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        boxDeriva.setEditable(true);
        boxDeriva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Si" }));
        boxDeriva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxControl.setEditable(true);
        boxControl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Si" }));
        boxControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJefe)
                    .addComponent(lblLugar)
                    .addComponent(lblArea)
                    .addComponent(lblSector)
                    .addComponent(lblNombre)
                    .addComponent(lblRut)
                    .addComponent(lblDeriva)
                    .addComponent(lblDeriva1))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtRut)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar)
                            .addGap(2, 2, 2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtJefe)
                                .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(boxDeriva, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxControl, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRut)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSector)
                    .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArea)
                    .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLugar)
                    .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJefe)
                    .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeriva)
                    .addComponent(boxDeriva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDeriva1)
                    .addComponent(boxControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel2.setText("Registro de Atenciones Spa Santiago");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)), "Datos Atención", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 10))); // NOI18N

        lblLesion.setText("Lesion");

        lblIncidente.setText("Incidente");

        lblExtremidad.setText("Extremidad");

        lblParamedico.setText("Paramedico");

        lblDetalles.setText("Detalles");

        lblTto.setText("Tratamiento");

        lblComentario.setText("Comentario");

        txtDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txtTto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(166, 76));
        jScrollPane2.setViewportView(textAreaComentario);

        boxLesion.setEditable(true);
        boxLesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxIncidente.setEditable(true);
        boxIncidente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxExtremidad.setEditable(true);
        boxExtremidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxParamedico.setEditable(true);
        boxParamedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDetalles)
                    .addComponent(lblExtremidad)
                    .addComponent(lblIncidente)
                    .addComponent(lblLesion)
                    .addComponent(lblParamedico)
                    .addComponent(lblTto)
                    .addComponent(lblComentario))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTto)
                    .addComponent(boxLesion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxIncidente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxExtremidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(boxParamedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDetalles))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLesion)
                    .addComponent(boxLesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIncidente)
                    .addComponent(boxIncidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExtremidad)
                    .addComponent(boxExtremidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxParamedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParamedico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetalles)
                    .addComponent(txtDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblComentario)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnCorreo.setText("Enviar Correo");
        btnCorreo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(btnCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(102, 153, 255));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenu1.setBackground(new java.awt.Color(102, 153, 255));
        jMenu1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Menu");

        menuTrabajador.setBackground(new java.awt.Color(102, 153, 255));
        menuTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        menuTrabajador.setText("Agregar Trabajador");
        menuTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTrabajadorActionPerformed(evt);
            }
        });
        jMenu1.add(menuTrabajador);

        menuPatologia.setBackground(new java.awt.Color(102, 153, 255));
        menuPatologia.setForeground(new java.awt.Color(255, 255, 255));
        menuPatologia.setText("Agregar Patología");
        menuPatologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPatologiaActionPerformed(evt);
            }
        });
        jMenu1.add(menuPatologia);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String rut = this.txtRut.getText();
        try {
            Conexion cn = new Conexion();
            ResultSet rs;
            rs = cn.ExtraerTrabajador(Integer.parseInt(rut));

            Trabajador trabajador = new Trabajador();
            try {
                while (rs.next()) {
                    trabajador.setRut(Integer.parseInt(rut.trim()));
                    trabajador.setNombre(rs.getString("nombre"));
                    trabajador.setApellido(rs.getString("apellido"));
                    trabajador.setArea(rs.getString("nombre_area"));
                    trabajador.setSector(rs.getString("nombre_sector"));
                    trabajador.setJefeArea(rs.getString("jefe_area"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(MenuSpa.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.txtNombre.setText(trabajador.getNombre() + " " + trabajador.getApellido());
            this.txtArea.setText(trabajador.getArea());
            this.txtJefe.setText(trabajador.getJefeArea());
            this.txtSector.setText(trabajador.getSector());
        } catch (Exception e) {
            Utils.showMessageWarning("Ingrese un rut válido", "Advertencia");
            this.txtRut.requestFocus();
        } 
    
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void menuTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTrabajadorActionPerformed
        // TODO add your handling code here:
        InsertarTrabajador nuevo = new InsertarTrabajador(); 
        nuevo.setLocationRelativeTo(null);
        nuevo.setTitle("Insertar datos nuevos");
        nuevo.setVisible(true); 
    }//GEN-LAST:event_menuTrabajadorActionPerformed

    private void btnCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorreoActionPerformed
        // TODO add your handling code here:
        List<Atencion> listaAtencion = new ArrayList<>();
        Atencion atencion = new Atencion();
        String rut = this.txtRut.getText();
        Conexion cn = new Conexion();
        ResultSet rs;
        rs = cn.ExtraerTrabajador(Integer.parseInt(rut));
        FechaHora fecha = new FechaHora("yyyy-MM-dd");

        try {
            while (rs.next()) {
                atencion.setRut(Integer.parseInt(rut.trim()));
                atencion.setNombre(rs.getString("nombre"));
                atencion.setApellido(rs.getString("apellido"));
                atencion.setSector(rs.getString("nombre_sector"));
                atencion.setArea(rs.getString("nombre_area"));
                atencion.setJefearea(rs.getString("jefe_area"));
                atencion.setFecha(fecha.getFecha());
                atencion.setLugar(this.txtLugar.getText());
                atencion.setDeriva((String) this.boxDeriva.getSelectedItem());
                atencion.setLesion((String) this.boxLesion.getSelectedItem());
                atencion.setIncidente((String) this.boxIncidente.getSelectedItem());
                atencion.setExtremidad((String) this.boxExtremidad.getSelectedItem());
                atencion.setParamedico((String) this.boxParamedico.getSelectedItem());
                atencion.setTratamiento(this.txtTto.getText());
                atencion.setDetalles(this.txtDetalles.getText());
                atencion.setComentario(this.textAreaComentario.getText());
                atencion.setControl((String)this.boxControl.getSelectedItem());
                listaAtencion.add(atencion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //INSERTA LA ATENCION DIRECTO A BD
        cn.InsertarAtenciones(listaAtencion,cn.convierteAtenciones(listaAtencion));

        try {
            EnviadorMail mail = new EnviadorMail("arturosk8_art13@hotmail.com", Utils.asuntoCorreo(listaAtencion), Utils.cuerpoCorreo(listaAtencion));
            JOptionPane.showMessageDialog(null, "Se envio el mail correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            Utils.showMessageWarning("Ocurrio un problema al mandar el mail", "Advertencia");            
        }
    }//GEN-LAST:event_btnCorreoActionPerformed

    private void menuPatologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPatologiaActionPerformed
        // TODO add your handling code here:
        InsertarPatologia nuevo = new InsertarPatologia(); 
        nuevo.setLocationRelativeTo(null);
        nuevo.setTitle("Insertar datos nuevos");
        nuevo.setVisible(true);
    }//GEN-LAST:event_menuPatologiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxControl;
    private javax.swing.JComboBox boxDeriva;
    private javax.swing.JComboBox boxExtremidad;
    private javax.swing.JComboBox boxIncidente;
    private javax.swing.JComboBox boxLesion;
    private javax.swing.JComboBox boxParamedico;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblDeriva;
    private javax.swing.JLabel lblDeriva1;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblExtremidad;
    private javax.swing.JLabel lblIncidente;
    private javax.swing.JLabel lblJefe;
    private javax.swing.JLabel lblLesion;
    private javax.swing.JLabel lblLugar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblParamedico;
    private javax.swing.JLabel lblRut;
    private javax.swing.JLabel lblSector;
    private javax.swing.JLabel lblTto;
    private javax.swing.JMenuItem menuPatologia;
    private javax.swing.JMenuItem menuTrabajador;
    private javax.swing.JTextPane textAreaComentario;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JTextField txtJefe;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtSector;
    private javax.swing.JTextField txtTto;
    // End of variables declaration//GEN-END:variables
}

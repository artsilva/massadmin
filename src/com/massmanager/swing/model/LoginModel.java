/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import com.massmanager.controller.Usuarios;
import com.massmanager.swing.view.LoginView;
import com.massmanager.swing.view.MenuMass;
import com.massmanager.swing.view.MenuSpa;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Artsk
 */
public class LoginModel implements ActionListener {

    private LoginView view;

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
        Conexion cn = new Conexion();
        ResultSet rsUsuario = cn.extraeUsuarios();
        List<Usuarios> listaUsuarios = new ArrayList<>();
        String user = view.getUsuario().getText();
        String password = view.getPassword().getText();

        try {
            while (rsUsuario.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setUserid(rsUsuario.getInt("id_usuario"));
                usuario.setUsuario(rsUsuario.getString("usuario"));
                usuario.setPassword(rsUsuario.getString("password"));
                usuario.setEmail(rsUsuario.getString("email"));
                usuario.setPermisoid(rsUsuario.getInt("id_permiso"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (e.getSource() == view.getAceptar()) {
            boolean usuarioexistente = false;
            boolean passwordCorrecto = false;
            Integer permisoUsuario = null;

            for (Usuarios listaUsuario : listaUsuarios) {
                if (user.equals(listaUsuario.getUsuario()) && password.equals(listaUsuario.getPassword())) {
                    usuarioexistente = true;
                    passwordCorrecto = true;
                    permisoUsuario = listaUsuario.getPermisoid();
                }
            }
            //permisoUsuario 1: Acceso a MenuMASS, permisoUsuario 2: Acceso a menuSPA
            if (usuarioexistente && passwordCorrecto && permisoUsuario == 1) {
                MenuMass mass = new MenuMass();
                view.setVisible(false);
                mass.setVisible(true);
            } else if (usuarioexistente && passwordCorrecto && permisoUsuario == 2) {
                MenuSpa spa = new MenuSpa();
                view.setVisible(false);
                spa.setVisible(true);
            } else if (!usuarioexistente || !passwordCorrecto) {
                showMessage("Usuario o contraseña incorrectos");
            }
        }
        if (e.getSource() == view.getCancelar()) {
            System.exit(0);
        }
    }
}


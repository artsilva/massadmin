/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Artsk
 */
public class QuerysGraficos extends Conexion {
    
    public ResultSet graficoIncidenteArea(String area, String fecha) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT count(id_atencion) \n"
                    + "FROM mass_dim.dim_rep_periodico \n"
                    + "WHERE area = ? AND (fecha)::text LIKE ?;");
            pst.setString(1, area);
            pst.setString(2, fecha);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.getSQLState();
        }
        return rs;
    }
    public ResultSet graficoIncidenteSector(String sector, String fecha) {
        Connection cn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            cn = Conectar();
            pst = cn.prepareStatement("SELECT count(id_atencion) \n"
                    + "FROM mass_dim.dim_rep_periodico \n"
                    + "WHERE sector = ? AND (fecha)::text LIKE ? ;");
            pst.setString(1, sector);
            pst.setString(2, fecha);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.getSQLState();
        }
        return rs;
    }
}

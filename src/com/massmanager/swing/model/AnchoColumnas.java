/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.swing.model;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Artsk
 */
public class AnchoColumnas {

    public void setAnchoColumnasAnual(JTable nombreTabla) {

        //TableColumn nos provee de métodos para minimizar, maximizar,etc. columnas de tabla.
        TableColumn columnaTabla = null;
        int anchoTabla = 638;  //Ancho del jScrollPane1.
        int anchoColumna = 0, anchoColumnaMin = 0, anchoColumnaMax = 0;

        for (int i = 0; i < nombreTabla.getColumnCount(); i++) {
            //Obtenemos el modelo de las columnas de la tabla.
            columnaTabla = nombreTabla.getColumnModel().getColumn(i);
            switch (i) {

                case 0://ID  
                    anchoColumna = (5 * anchoTabla) / 100;
                    anchoColumnaMin = (5 * anchoTabla) / 100;   //que ocupara la primera columna.
                    anchoColumnaMax = (5 * anchoTabla) / 100;
                    break;
                case 1://Nombre
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 2://Apellido
                    anchoColumna = (20 * anchoTabla) / 100;
                    anchoColumnaMin = (20 * anchoTabla) / 100;
                    anchoColumnaMax = (20 * anchoTabla) / 100;
                    break;
                case 3://Rut
                    anchoColumna = (13 * anchoTabla) / 100;
                    anchoColumnaMin = (13 * anchoTabla) / 100;
                    anchoColumnaMax = (13 * anchoTabla) / 100;
                    break;
                case 4://Sector
                    anchoColumna = (20 * anchoTabla) / 100;
                    anchoColumnaMin = (20 * anchoTabla) / 100;
                    anchoColumnaMax = (20 * anchoTabla) / 100;
                    break;
                case 5://Area
                    anchoColumna = (15 * anchoTabla) / 100;
                    anchoColumnaMin = (15 * anchoTabla) / 100;
                    anchoColumnaMax = (15 * anchoTabla) / 100;
                    break;
                case 6://Jefe Area
                    anchoColumna = (30 * anchoTabla) / 100;
                    anchoColumnaMin = (30 * anchoTabla) / 100;
                    anchoColumnaMax = (30 * anchoTabla) / 100;
                    break;
                case 7://Fecha
                    anchoColumna = (13 * anchoTabla) / 100;
                    anchoColumnaMin = (13 * anchoTabla) / 100;
                    anchoColumnaMax = (13 * anchoTabla) / 100;
                    break;
                case 8://Lugar Incidente
                    anchoColumna = (25 * anchoTabla) / 100;
                    anchoColumnaMin = (25 * anchoTabla) / 100;
                    anchoColumnaMax = (25 * anchoTabla) / 100;
                    break;
                case 9://Detalles
                    anchoColumna = (50 * anchoTabla) / 100;
                    anchoColumnaMin = (50 * anchoTabla) / 100;
                    anchoColumnaMax = (50 * anchoTabla) / 100;
                    break;
                case 10://Lesion
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 11://Incidente
                    anchoColumna = (12 * anchoTabla) / 100;
                    anchoColumnaMin = (12 * anchoTabla) / 100;
                    anchoColumnaMax = (12 * anchoTabla) / 100;
                    break;
                case 12://Extremidad
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 13://Paramedico
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 14://Tratamiento
                    anchoColumna = (50 * anchoTabla) / 100;
                    anchoColumnaMin = (50 * anchoTabla) / 100;
                    anchoColumnaMax = (50 * anchoTabla) / 100;
                    break;
                case 15://Comentario
                    anchoColumna = (60 * anchoTabla) / 100;
                    anchoColumnaMin = (60 * anchoTabla) / 100;
                    anchoColumnaMax = (60 * anchoTabla) / 100;
                    break;
            }

            //Aplicamos el ancho para cada columna de la tabla.
            columnaTabla.setPreferredWidth(anchoColumna);
            columnaTabla.setMinWidth(anchoColumnaMin);
            columnaTabla.setMaxWidth(anchoColumnaMax);
        }
        //Seteamos el alto de cada columna
        nombreTabla.setRowHeight(22);
    }
    
    public void setAnchoColumnasMensual(JTable nombreTabla) {

        //TableColumn nos provee de métodos para minimizar, maximizar,etc. columnas de tabla.
        TableColumn columnaTabla = null;
        int anchoTabla = 638;  //Ancho del jScrollPane1.
        int anchoColumna = 0, anchoColumnaMin = 0, anchoColumnaMax = 0;

        for (int i = 0; i < nombreTabla.getColumnCount(); i++) {
            //Obtenemos el modelo de las columnas de la tabla.
            columnaTabla = nombreTabla.getColumnModel().getColumn(i);
            switch (i) {

                case 0://ID  
                    anchoColumna = (5 * anchoTabla) / 100;
                    anchoColumnaMin = (5 * anchoTabla) / 100;   //que ocupara la primera columna.
                    anchoColumnaMax = (5 * anchoTabla) / 100;
                    break;
                case 1://Nombre
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 2://Apellido
                    anchoColumna = (20 * anchoTabla) / 100;
                    anchoColumnaMin = (20 * anchoTabla) / 100;
                    anchoColumnaMax = (20 * anchoTabla) / 100;
                    break;
                case 3://Rut
                    anchoColumna = (13 * anchoTabla) / 100;
                    anchoColumnaMin = (13 * anchoTabla) / 100;
                    anchoColumnaMax = (13 * anchoTabla) / 100;
                    break;
                case 4://Sector
                    anchoColumna = (20 * anchoTabla) / 100;
                    anchoColumnaMin = (20 * anchoTabla) / 100;
                    anchoColumnaMax = (20 * anchoTabla) / 100;
                    break;
                case 5://Area
                    anchoColumna = (15 * anchoTabla) / 100;
                    anchoColumnaMin = (15 * anchoTabla) / 100;
                    anchoColumnaMax = (15 * anchoTabla) / 100;
                    break;
                case 6://Jefe Area
                    anchoColumna = (30 * anchoTabla) / 100;
                    anchoColumnaMin = (30 * anchoTabla) / 100;
                    anchoColumnaMax = (30 * anchoTabla) / 100;
                    break;
                case 7://Fecha
                    anchoColumna = (13 * anchoTabla) / 100;
                    anchoColumnaMin = (13 * anchoTabla) / 100;
                    anchoColumnaMax = (13 * anchoTabla) / 100;
                    break;
                case 8://Mes
                    anchoColumna = (14 * anchoTabla) / 100;
                    anchoColumnaMin = (14 * anchoTabla) / 100;
                    anchoColumnaMax = (14 * anchoTabla) / 100;
                    break;
                case 9://Lugar Incidente
                    anchoColumna = (25 * anchoTabla) / 100;
                    anchoColumnaMin = (25 * anchoTabla) / 100;
                    anchoColumnaMax = (25 * anchoTabla) / 100;
                    break;
                case 10://Detalles
                    anchoColumna = (50 * anchoTabla) / 100;
                    anchoColumnaMin = (50 * anchoTabla) / 100;
                    anchoColumnaMax = (50 * anchoTabla) / 100;
                    break;
                case 11://Lesion
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 12://Incidente
                    anchoColumna = (12 * anchoTabla) / 100;
                    anchoColumnaMin = (12 * anchoTabla) / 100;
                    anchoColumnaMax = (12 * anchoTabla) / 100;
                    break;
                case 13://Extremidad
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 14://Paramedico
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 15://Tratamiento
                    anchoColumna = (50 * anchoTabla) / 100;
                    anchoColumnaMin = (50 * anchoTabla) / 100;
                    anchoColumnaMax = (50 * anchoTabla) / 100;
                    break;
                case 16://Comentario
                    anchoColumna = (60 * anchoTabla) / 100;
                    anchoColumnaMin = (60 * anchoTabla) / 100;
                    anchoColumnaMax = (60 * anchoTabla) / 100;
                    break;
            }

            //Aplicamos el ancho para cada columna de la tabla.
            columnaTabla.setPreferredWidth(anchoColumna);
            columnaTabla.setMinWidth(anchoColumnaMin);
            columnaTabla.setMaxWidth(anchoColumnaMax);
        }
        //Seteamos el alto de cada columna
        nombreTabla.setRowHeight(22);
    }
    
    public void setAnchoColumnasPeriodico(JTable nombreTabla) {

        //TableColumn nos provee de métodos para minimizar, maximizar,etc. columnas de tabla.
        TableColumn columnaTabla = null;
        int anchoTabla = 638;  //Ancho del jScrollPane1.
        int anchoColumna = 0, anchoColumnaMin = 0, anchoColumnaMax = 0;

        for (int i = 0; i < nombreTabla.getColumnCount(); i++) {
            //Obtenemos el modelo de las columnas de la tabla.
            columnaTabla = nombreTabla.getColumnModel().getColumn(i);
            switch (i) {

                case 0://ID  
                    anchoColumna = (5 * anchoTabla) / 100;
                    anchoColumnaMin = (5 * anchoTabla) / 100;   //que ocupara la primera columna.
                    anchoColumnaMax = (5 * anchoTabla) / 100;
                    break;
                case 1://Nombre
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 2://Apellido
                    anchoColumna = (20 * anchoTabla) / 100;
                    anchoColumnaMin = (20 * anchoTabla) / 100;
                    anchoColumnaMax = (20 * anchoTabla) / 100;
                    break;
                case 3://Rut
                    anchoColumna = (13 * anchoTabla) / 100;
                    anchoColumnaMin = (13 * anchoTabla) / 100;
                    anchoColumnaMax = (13 * anchoTabla) / 100;
                    break;
                case 4://Sector
                    anchoColumna = (20 * anchoTabla) / 100;
                    anchoColumnaMin = (20 * anchoTabla) / 100;
                    anchoColumnaMax = (20 * anchoTabla) / 100;
                    break;
                case 5://Area
                    anchoColumna = (15 * anchoTabla) / 100;
                    anchoColumnaMin = (15 * anchoTabla) / 100;
                    anchoColumnaMax = (15 * anchoTabla) / 100;
                    break;
                case 6://Jefe Area
                    anchoColumna = (30 * anchoTabla) / 100;
                    anchoColumnaMin = (30 * anchoTabla) / 100;
                    anchoColumnaMax = (30 * anchoTabla) / 100;
                    break;
                case 7://Fecha
                    anchoColumna = (13 * anchoTabla) / 100;
                    anchoColumnaMin = (13 * anchoTabla) / 100;
                    anchoColumnaMax = (13 * anchoTabla) / 100;
                    break;
                case 8://Semana del Año
                    anchoColumna = (14 * anchoTabla) / 100;
                    anchoColumnaMin = (14 * anchoTabla) / 100;
                    anchoColumnaMax = (14 * anchoTabla) / 100;
                    break;
                case 9://Semana del Mes
                    anchoColumna = (14 * anchoTabla) / 100;
                    anchoColumnaMin = (14 * anchoTabla) / 100;
                    anchoColumnaMax = (14 * anchoTabla) / 100;
                    break;
                case 10://Semestre
                    anchoColumna = (14 * anchoTabla) / 100;
                    anchoColumnaMin = (14 * anchoTabla) / 100;
                    anchoColumnaMax = (14 * anchoTabla) / 100;
                    break;
                case 11://Trimestre
                    anchoColumna = (14 * anchoTabla) / 100;
                    anchoColumnaMin = (14 * anchoTabla) / 100;
                    anchoColumnaMax = (14 * anchoTabla) / 100;
                    break;
                case 12://Lugar Incidente
                    anchoColumna = (25 * anchoTabla) / 100;
                    anchoColumnaMin = (25 * anchoTabla) / 100;
                    anchoColumnaMax = (25 * anchoTabla) / 100;
                    break;
                case 13://Detalles
                    anchoColumna = (50 * anchoTabla) / 100;
                    anchoColumnaMin = (50 * anchoTabla) / 100;
                    anchoColumnaMax = (50 * anchoTabla) / 100;
                    break;
                case 14://Lesion
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 15://Incidente
                    anchoColumna = (12 * anchoTabla) / 100;
                    anchoColumnaMin = (12 * anchoTabla) / 100;
                    anchoColumnaMax = (12 * anchoTabla) / 100;
                    break;
                case 16://Extremidad
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 17://Paramedico
                    anchoColumna = (18 * anchoTabla) / 100;
                    anchoColumnaMin = (18 * anchoTabla) / 100;
                    anchoColumnaMax = (18 * anchoTabla) / 100;
                    break;
                case 18://Tratamiento
                    anchoColumna = (50 * anchoTabla) / 100;
                    anchoColumnaMin = (50 * anchoTabla) / 100;
                    anchoColumnaMax = (50 * anchoTabla) / 100;
                    break;
                case 19://Comentario
                    anchoColumna = (60 * anchoTabla) / 100;
                    anchoColumnaMin = (60 * anchoTabla) / 100;
                    anchoColumnaMax = (60 * anchoTabla) / 100;
                    break;
            }

            //Aplicamos el ancho para cada columna de la tabla.
            columnaTabla.setPreferredWidth(anchoColumna);
            columnaTabla.setMinWidth(anchoColumnaMin);
            columnaTabla.setMaxWidth(anchoColumnaMax);
        }
        //Seteamos el alto de cada columna
        nombreTabla.setRowHeight(22);
    }
}

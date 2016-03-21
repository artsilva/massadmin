/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.controller;

/**
 *
 * @author Artsk
 */
public class Trabajador {
    private Integer rut;
    private String nombre;
    private String apellido;
    private String sector;
    private String area;
    private String jefeArea;
    
    public Trabajador() {
        
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getJefeArea() {
        return jefeArea;
    }

    public void setJefeArea(String jefeArea) {
        this.jefeArea = jefeArea;
    }

}

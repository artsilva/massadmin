/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.massmanager.controller;

import java.sql.Date;

/**
 *
 * @author Artsk
 */
public class Atencion {

    private Integer atencionid;
    private Integer rut;
    private String nombre;
    private String apellido;
    private String sector;
    private String area;
    private String jefearea;
    private String fecha;
    private String lugar;
    private String lesion;
    private String incidente;
    private String extremidad;
    private String paramedico;
    private String detalles;
    private String tratamiento;
    private String comentario;
    private String deriva;
    
    public Atencion() {
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public Integer getAtencionid() {
        return atencionid;
    }

    public void setAtencionid(Integer atencionid) {
        this.atencionid = atencionid;
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

    public String getJefearea() {
        return jefearea;
    }

    public void setJefearea(String jefearea) {
        this.jefearea = jefearea;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLesion() {
        return lesion;
    }

    public void setLesion(String lesion) {
        this.lesion = lesion;
    }

    public String getIncidente() {
        return incidente;
    }

    public void setIncidente(String incidente) {
        this.incidente = incidente;
    }

    public String getExtremidad() {
        return extremidad;
    }

    public void setExtremidad(String extremidad) {
        this.extremidad = extremidad;
    }

    public String getParamedico() {
        return paramedico;
    }

    public void setParamedico(String paramedico) {
        this.paramedico = paramedico;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDeriva() {
        return deriva;
    }

    public void setDeriva(String deriva) {
        this.deriva = deriva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

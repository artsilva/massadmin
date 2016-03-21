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
public class Usuarios {
    
    private Integer userid;
    private String usuario;
    private String password;
    private String email;
    private Integer permisoid;
    
    public Usuarios() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPermisoid() {
        return permisoid;
    }

    public void setPermisoid(Integer permisoid) {
        this.permisoid = permisoid;
    } 
}

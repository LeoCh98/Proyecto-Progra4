/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.logic;

import java.util.Objects;

/**
 *
 * @author javir
 */
public class Poliza {
    private String nombre;
    private int id;
    private int costo;
    User usuario;

    public Poliza(String nombre, int id, int costo, User usuario) {
        this.nombre = nombre;
        this.id = id;
        this.costo = costo;
        this.usuario = usuario;
    }

    public Poliza() {
         this("",0,0,new User());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poliza other = (Poliza) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.costo != other.costo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    
}

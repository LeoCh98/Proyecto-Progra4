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
    String placa;
    private int costo;
    Modelo modelo;
    Client cliente;

    public Poliza(String nombre, int id, String placa, int costo, Modelo modelo, Client cliente) {
        this.nombre = nombre;
        this.id = id;
        this.placa = placa;
        this.costo = costo;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public Poliza() {
         this("",0,"",0,new Modelo(), new Client());
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

    public String getPlaca(){
        return placa;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (this.costo != other.costo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.presentation.admin;

import com.proyect.progra.proyectoprogra4.logic.Client;
import com.proyect.progra.proyectoprogra4.logic.Poliza;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leoch
 */
public class Model {
    List<Client> clientes;
    List<Poliza> polizas;
    
    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Poliza> rows = new ArrayList<>();         
        this.setPolizas(rows);
        List<Client> rows1 = new ArrayList<>();         
        this.setClientes(rows1);
    }
    
    public void setPolizas(List<Poliza> cuentas){
        this.polizas =cuentas;    
    }

     public List<Poliza> getPolizas() {
        return polizas;
    }

    public List<Client> getClientes() {
        return clientes;
    }

    public void setClientes(List<Client> clientes) {
        this.clientes = clientes;
    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.presentation.update;

import com.proyect.progra.proyectoprogra4.logic.Client;

/**
 *
 * @author leoch
 */
public class Model {
    Client cliente;

    public Model() {
        this.reset();
    }

    public void reset() {
        setCliente(new Client());
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
    
}

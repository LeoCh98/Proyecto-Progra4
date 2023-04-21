/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.presentation.signup;

import com.proyect.progra.proyectoprogra4.logic.Client;
import com.proyect.progra.proyectoprogra4.logic.User;

/**
 *
 * @author leoch
 */
public class Model {

    Client cliente;
    User usuario;

    public Model() {
        this.reset();
    }

    public void reset() {
        setCliente(new Client());
        setUsuario(new User());
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Client getCliente() {
        return cliente;
    }

    public User getUsuario() {
        return usuario;
    }

}

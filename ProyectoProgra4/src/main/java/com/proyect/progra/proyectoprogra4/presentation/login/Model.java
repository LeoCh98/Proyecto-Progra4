/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.presentation.login;
import com.proyect.progra.proyectoprogra4.logic.User;
/**
 *
 * @author javir
 */
public class Model {
    User current;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new User());        
    }
    
    public User getCurrent() {
        return current;
    }

    public void setCurrent(User current) {
        this.current = current;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.logic;

import com.proyect.progra.proyectoprogra4.data.ClienteDao;
import com.proyect.progra.proyectoprogra4.data.MarcaDao;
import com.proyect.progra.proyectoprogra4.data.ModeloDao;
import com.proyect.progra.proyectoprogra4.data.PolizaDao;
import com.proyect.progra.proyectoprogra4.data.RelDatabase;
import com.proyect.progra.proyectoprogra4.data.UsuarioDao;

/**
 *
 * @author javir
 */
public class Service {

    private static Service uniqueInstance;

    public static Service instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    RelDatabase relDatabase;
    ClienteDao clienteDao;
    MarcaDao marcaDao;
    ModeloDao modeloDao;
    PolizaDao polizaDao;
    UsuarioDao usuarioDao;

    private Service() {
        relDatabase = new RelDatabase();
        clienteDao = new ClienteDao(relDatabase);
        marcaDao = new MarcaDao(relDatabase);
        modeloDao = new ModeloDao(relDatabase);
        polizaDao = new PolizaDao(relDatabase);
        usuarioDao = new UsuarioDao(relDatabase);
    }
    
    public User usuarioFind(String cedula, String clave) throws Exception{
        User u = usuarioDao.read(cedula);
        if(u.getClave()==clave)
            return u;
        else return null;
    }
    
}

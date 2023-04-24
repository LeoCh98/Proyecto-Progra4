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
import java.util.List;

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

    public User usuarioFind(String cedula, String clave) throws Exception {
        User u = usuarioDao.read(cedula);
        if (u.getClave().equals(clave)) {
            return u;
        } else {
            return null;
        }
    }

    public Client clienteFind(User usuario) throws Exception {
        return clienteDao.read(usuario.getCedula());
    }

    public List<Poliza> polizasFind(Client cliente) throws Exception {
        List<Poliza> polizas = polizaDao.findByClient(cliente);
        for (Poliza p : polizas) {
            p.setCliente(cliente);
        }
        cliente.setPolizas(polizas);
        return polizas;
    }

    public void clienteUpdate(Client c) throws Exception {
        clienteDao.update(c);
    }

    public void clienteInsert(Client c) throws Exception {
        clienteDao.write(c);
    }

    public void userInsert(User u) throws Exception {
        usuarioDao.write(u);
    }

    public void polizaInsert(Poliza p) throws Exception {
        polizaDao.write(p);
    }
    
}

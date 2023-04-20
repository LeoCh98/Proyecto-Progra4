/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.data;

import com.proyect.progra.proyectoprogra4.logic.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leoch
 */
public class ClienteDao {

    RelDatabase db;

    public ClienteDao(RelDatabase db) {
        this.db = db;
    }

    public Client read(String cedula) throws Exception {
        String sql = "select "
                + "* "
                + "from Cliente c inner join Usuario u on c.usuario=u.cedula "
                + "where c.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        UsuarioDao usuarioDao = new UsuarioDao(db);
        Client c;
        if (rs.next()) {
            c = from(rs, "c");
            c.setUsuario(usuarioDao.from(rs, "u"));
            return c;
        } else {
            throw new Exception("Cliente no existe");
        }
    }

public Client from(ResultSet rs, String alias){
        try{
            Client c = new Client();
            c.setNombre(rs.getString(alias + ".nombre"));
            c.setCedula(rs.getString(alias + ".cedula"));
            c.setTarjeta(rs.getInt(alias + ".tarjeta"));
            c.setTelefono(rs.getString(alias + ".telefono"));
            c.setCorreo(rs.getString(alias + ".correo"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
}

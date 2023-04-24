/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.data;

import com.proyect.progra.proyectoprogra4.logic.Client;
import com.proyect.progra.proyectoprogra4.logic.Modelo;
import com.proyect.progra.proyectoprogra4.logic.Poliza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leoch
 */
public class PolizaDao {

    RelDatabase db;

    public PolizaDao(RelDatabase db) {
        this.db = db;
    }

    public List<Poliza> findByClient(Client cliente) throws Exception {
        List<Poliza> resultado = new ArrayList<>();
        try {
            String sql = "select p.*, m.* "
                    + "from Poliza p "
                    + "inner join Modelo m on p.modeloId = m.idModelo "
                    + "where p.clienteId=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, cliente.getCedula());
            ResultSet rs = db.executeQuery(stm);
            ModeloDao modeloDao = new ModeloDao(db);
            while (rs.next()) {
                Poliza p = from(rs, "p");
                Modelo modelo = modeloDao.read(rs.getString("modeloId"));
                p.setModelo(modelo);
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public Poliza from(ResultSet rs, String alias) {
        try {
            Poliza p = new Poliza();
            p.setNombre(rs.getString(alias + ".nombre"));
            p.setId(rs.getInt(alias + ".idPoliza"));
            p.setPlaca(rs.getString(alias + ".placa"));
            p.setCosto(rs.getInt(alias + ".costo"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void write(Poliza poliza) throws Exception {
        try {
            String sql = "insert into Poliza (nombre, placa, costo, modeloId, clienteId) values (?, ?, ?, ?, ?)";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, poliza.getNombre());
            stm.setString(2, poliza.getPlaca());
            stm.setInt(3, poliza.getCosto());
            if (poliza.getModelo() != null) {
                stm.setInt(4, poliza.getModelo().getId());
            } else {
                stm.setNull(4, Types.INTEGER);
            }
            if (poliza.getCliente() != null) {
                stm.setString(5, poliza.getCliente().getCedula());
            } else {
                stm.setNull(5, Types.VARCHAR);
            }
            int rowsAffected = db.executeUpdate(stm);
            if (rowsAffected == 0) {
                throw new SQLException("No se pudo ingresar la poliza");
            }
            try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    poliza.setId(id);
                } else {
                    throw new SQLException("No se pudo ingresar el idPoliza");
                }
            }
        } catch (SQLException ex) {
            throw new Exception("No se pudo escribir la poliza", ex);
        }
    }

}

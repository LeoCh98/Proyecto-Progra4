/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.data;

import com.proyect.progra.proyectoprogra4.logic.Client;
import com.proyect.progra.proyectoprogra4.logic.Marca;
import com.proyect.progra.proyectoprogra4.logic.Modelo;
import com.proyect.progra.proyectoprogra4.logic.Poliza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}

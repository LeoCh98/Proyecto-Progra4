/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.data;

import com.proyect.progra.proyectoprogra4.logic.Client;
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

    public Poliza read(String id) throws Exception {
        String sql = "select "
                + "* "
                + "from  Poliza p "
                + "where p.idPolza=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "p");
        } else {
            throw new Exception("Poliza no existe");
        }
    }
    
    public List<Poliza> findByClient(Client cliente){
        List<Poliza> resultado = new ArrayList<>();
        try{
            String sql = "select * " +
                    "from " +
                    "Poliza p " +
                    "where p.clienteId=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, cliente.getCedula());
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "p"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Poliza from(ResultSet rs, String alias){
        try{
            Poliza p = new Poliza();
            p.setNombre(rs.getString(alias + ".nombre"));
            p.setId(rs.getInt(alias + ".idPoliza"));
            p.setPlaca(rs.getString(alias + ".placa"));
            p.setCosto(rs.getInt(alias + ".costo"));
            return p;
        } catch (SQLException ex){
            return null;
        }
    }
}

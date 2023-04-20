/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyect.progra.proyectoprogra4.data;

import com.proyect.progra.proyectoprogra4.logic.Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leoch
 */
public class ModeloDao {
    RelDatabase db;
    
    public ModeloDao(RelDatabase db){
    this.db = db;
    }
    
    public Modelo read(String id) throws Exception {
        String sql = "select " +
                "* " +
                "from Modelo m inner join Marca b on m.marca=b.idModelo " +
                "where m.idModelo=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        MarcaDao marcaDao = new MarcaDao(db);
        Modelo m;
        if (rs.next()){
            m = from(rs, "m");
            m.setMarca(marcaDao.from(rs,"m"));
            return m;
        } else {
            throw new Exception("Modelo no existe");
        }
    }
    
    public Modelo from(ResultSet rs, String alias){
        try {
            Modelo m = new Modelo();
            m.setNombre(rs.getString(alias + ".nombre"));
            m.setId(rs.getInt(alias + ".idModelo"));
            return m;
        } catch (SQLException ex) {
            return null;
        }
    }
}

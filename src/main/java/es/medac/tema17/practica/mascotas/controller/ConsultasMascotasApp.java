/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.tema17.practica.mascotas.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrés
 */
public class ConsultasMascotasApp {
    
    private Connection conexion;
    
    public ConsultasMascotasApp(){
        this.conexion= new ConexionSQL().getConnection();
    }
    
    public void insertarMascotas(int IdMascota, int IdCliente, String AliasMascota,
            String Especie, String Raza, String ColorPelo, String FechaNacimiento,
            int Vacaciones) throws SQLException{
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try{
            String sql = "INSERT INTO pacientes VALUES (?,?,?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setInt(2, IdCliente);
            ps.setString(3,AliasMascota);
            ps.setString(4, Especie);
            ps.setString(5, Raza);
        } catch (SQLException ex){
            System.out.println("No se ha podido insertar ningún valor: "
            +ex.getMessage());
        }
     
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.tema17.practica.mascotas.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andrés
 */
public class ConexionSQL {
    protected Connection conexion;
    String url = "jdbc:mysql://localhost:3306/clientes";
    String usuario = "Admin";
    String pwd = "admin12345678.";
    
    public Connection getConnection(){
        try{
            conexion = (Connection) DriverManager.getConnection(url, usuario, pwd);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Conexion errónea "+e.toString());
        }
        return conexion;
    }
    
    public void cerrarConexion(){
        try{
            this.conexion.close();
            
        } catch (SQLException ex){
            System.out.println("No se ha podido cerrar la conexión");
        }
    }
}

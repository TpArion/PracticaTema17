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
    
    /////////////////////////////////////////////////////////
    // Clase para la conexión a nuestro SQL.
    /////////////////////////////////////////////////////////
    protected Connection conexion;
    String url = "jdbc:mysql://localhost:3306/mascotasapp";
    String usuario = "Admin";
    String pwd = "admin12345678.";
    //Tal y como nos dijo el profesor, podíamos utilizar el ejemplo de nuestra
    //primera tarea con una conexión a base de datos para utilizarla en esta
    //práctica.
    
    
    //Método para iniciar una conexión a base, básicamente la comprobación.
    public Connection getConnection(){
        try{
            conexion = (Connection) DriverManager.getConnection(url, usuario, pwd);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Conexion errónea "+e.toString());
        }
        return conexion;
    }
    
    //Método para cerrar la conexión.
    public void cerrarConexion(){
        try{
            this.conexion.close();
            
        } catch (SQLException ex){
            System.out.println("No se ha podido cerrar la conexión");
        }
    }
}

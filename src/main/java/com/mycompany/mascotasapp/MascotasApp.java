/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mascotasapp;

import es.medac.tema17.practica.mascotas.controller.ConexionSQL;
import es.medac.tema17.practica.mascotas.controller.ConsultasMascotasApp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Andrés
 */
public class MascotasApp {

    public static void main(String[] args) throws SQLException {
        Logger log = Logger.getLogger(MascotasApp.class.getName());
        
        
        ConexionSQL con = new ConexionSQL();
        Connection conex = con.getConnection();
        ConsultasMascotasApp con1 = new ConsultasMascotasApp();
        
        
        //con1.insertarClientes(1, "Redondo", 73492474, 655042714);
        //con1.insertarMascotas(1, 1, "Perico", "Cacatua", 
         //       "Alba", "Marrón", "2020-04-25", 2);
         
         
         System.out.println(con1.listadoPacientes());
    }
}

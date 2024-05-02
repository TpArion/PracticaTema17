package com.mycompany.mascotasapp.MascotasApp;

import es.medac.tema17.practica.mascotas.controller.ConexionSQL;
import es.medac.tema17.practica.mascotas.controller.ConsultasMascotasApp;
import java.sql.Connection;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrés
 */
public class MascotasApp {
    
    
    ///////////////////////////////////////////////////////////
    // Main para probar los métodos construidos para nuestra aplicación.
    // No tiene nada que aportar a la aplicación, sirve para probar.
    ///////////////////////////////////////////////////////////
     Logger log = Logger.getLogger(MascotasApp.class.getName());
        
        
        ConexionSQL con = new ConexionSQL();
        Connection conex = con.getConnection();
        ConsultasMascotasApp con1 = new ConsultasMascotasApp();
        
        
        //con1.insertarClientes(1, "Redondo", 73492474, 655042714);
        //con1.insertarMascotas(1, 1, "Perico", "Cacatua", 
         //       "Alba", "Marrón", "2020-04-25", 2);
         
         //con1.insertarPesos(1, "2020-10-01", 40);
         //System.out.println(con1.listadoPacientes());
         //con1.eliminarMascota(1);
         //con1.insertarVacunas(1, "2020-11-11", "Sifilis", "2021-11-10");
    
    
}

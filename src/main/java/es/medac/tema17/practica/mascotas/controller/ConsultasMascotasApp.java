/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.tema17.practica.mascotas.controller;

import es.medac.tema17.practica.mascotas.model.pacientes;
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
    
    
    // CONEXION
    private Connection conexion;
    
    public ConsultasMascotasApp(){
        this.conexion= new ConexionSQL().getConnection();
    }
    
    
    ////////////////////////////////////////////////////////////////////////
    // MÉTODOS PARA LOS PACIENTES
    ////////////////////////////////////////////////////////////////////////
    public boolean insertarMascotas(int IdMascota, int IdCliente, String AliasMascota,
            String Especie, String Raza, String ColorPelo, String FechaNacimiento,
            int Vacunaciones) throws SQLException{
        PreparedStatement ps = null;
        boolean InserccionExitosa = false;
        try{
            String sql = "INSERT INTO pacientes VALUES (?,?,?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setInt(2, IdCliente);
            ps.setString(3,AliasMascota);
            ps.setString(4, Especie);
            ps.setString(5, Raza);
            ps.setString(6, ColorPelo);
            ps.setString(7, FechaNacimiento);
            ps.setInt(8, Vacunaciones);
            
            int filasActualizadas = ps.executeUpdate();
             
             if (filasActualizadas > 0){
                 System.out.println("Insercción exitosa");
                 InserccionExitosa= true;
             } else {
                 System.out.println("No se encontró al paciente con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido insertar ningún valor: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
        return InserccionExitosa;
     
    }
    
    public boolean modificarMascotas(int IdMascota, int IdCliente, String AliasMascota,
            String Especie, String Raza, String ColorPelo, String FechaNacimiento,
            int Vacunaciones){
        PreparedStatement ps = null;
            boolean actualizacionExitosa = false;
        try{
            String sql = "UPDATE pacientes SET IdMascota = ?, IdCliente = ?,"
                    + "AliasMascota = ?, Especie = ?, Raza = ?, ColorPelo = ?,"
                    + "FechaNacimiento = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setInt(2, IdCliente);
            ps.setString(3,AliasMascota);
            ps.setString(4, Especie);
            ps.setString(5, Raza);
            ps.setString(6, ColorPelo);
            ps.setString(7, FechaNacimiento);
            ps.setInt(8, Vacunaciones);
            
            int filasActualizadas = ps.executeUpdate();
             
             if (filasActualizadas > 0){
                 System.out.println("Actualización exitosa");
                 actualizacionExitosa= true;
             } else {
                 System.out.println("No se encontró al paciente con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido modificar ningún valor: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
         return actualizacionExitosa;
    }
     
    public boolean eliminarMascota(int IdMascota){
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try{
            String sql = "DELETE FROM pacientes WHERE IdMascotas = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            
            
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0){
                 System.out.println("Actualización exitosa");
                 actualizacionExitosa= true;
             } else {
                 System.out.println("No se encontró al paciente con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido eliminar la fila: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
         return actualizacionExitosa;
        
        
    }
    
    public ArrayList<pacientes> listadoPacientes(){
        ArrayList<pacientes> pacientes = new ArrayList<pacientes>();
        
        try{
            String sql = "SELECT IdMascotas, IdCliente, AliasMascota, Especie,"
                    + "Raza, Color_Pelo, Fecha_Nacimiento, Vacunaciones FROM "
                    + "pacientes;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                int IdMascota = rs.getInt("IdMascotas");
                int IdCliente = rs.getInt("IdCliente");
                String AliasMascota = rs.getString("AliasMascota");
                String Especie = rs.getString("Especie");
                String Raza = rs.getString("Raza");
                String ColorPelo = rs.getString("Color_Pelo");
                String FechaNacimiento = rs.getString ("Fecha_Nacimiento");
                int Vacunaciones = rs.getInt ("Vacunaciones");
                pacientes pacient = new pacientes(IdMascota,IdCliente, 
                AliasMascota,Especie,Raza, ColorPelo,FechaNacimiento, Vacunaciones);
                pacientes.add(pacient);
            }
            rs.close();
            ps.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex){
            System.out.println("Error al crear la lista "+ex.getMessage());
        }
        return pacientes;
    }
    ////////////////////////////////////////////////////////////////////////
    
    
    ////////////////////////////////////////////////////////////////////////
    // MÉTODOS PARA LOS CLIENTES
    ////////////////////////////////////////////////////////////////////////
    public boolean insertarClientes(int IdCliente, String PrimerApellido,
            int CuentaBanco, int Telefono) throws SQLException{
        PreparedStatement ps = null;
        boolean InserccionExitosa = false;
        try{
            String sql = "INSERT INTO clientes VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdCliente);
            ps.setString(2, PrimerApellido);
            ps.setInt(3,CuentaBanco);
            ps.setInt(4, Telefono);
            
            
            int filasActualizadas = ps.executeUpdate();
             
             if (filasActualizadas > 0){
                 System.out.println("Insercción exitosa");
                 InserccionExitosa= true;
             } else {
                 System.out.println("No se encontró al cliente con id: "+IdCliente);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido insertar ningún valor: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
        return InserccionExitosa;
     
    }
    public boolean eliminarCliente(int IdCliente){
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try{
            String sql = "DELETE FROM clientes WHERE IdCliente = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdCliente);
            
            
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0){
                 System.out.println("Actualización exitosa");
                 actualizacionExitosa= true;
             } else {
                 System.out.println("No se encontró al cliente con id: "+IdCliente);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido eliminar la fila: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
         return actualizacionExitosa;
        
        
    }
    ////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////
    // MÉTODOS PARA LOS PESOS
    ////////////////////////////////////////////////////////////////////////
    public boolean insertarPesos(int IdMascota, String Fecha, double Peso) throws SQLException {
         PreparedStatement ps = null;
        boolean InserccionExitosa = false;
        try{
            String sql = "INSERT INTO Pesos VALUES (?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setString(2, Fecha);
            ps.setDouble(3,Peso);
           
            int filasActualizadas = ps.executeUpdate();
             
             if (filasActualizadas > 0){
                 System.out.println("Insercción exitosa");
                 InserccionExitosa= true;
             } else {
                 System.out.println("No se encontró la mascota con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido insertar ningún valor: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                   
                }
            }
         }
        return InserccionExitosa;
     
    }
    
    public boolean modificarPesos(int IdMascota, String Fecha, double Peso){
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try{
            String sql = "UPDATE pesos SET IdMascota = ?, Fecha = ?,"
                    + "Peso = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setString(2, Fecha);
            ps.setDouble(3,Peso);
            
            int filasActualizadas = ps.executeUpdate();
             
             if (filasActualizadas > 0){
                 System.out.println("Actualización exitosa");
                 actualizacionExitosa= true;
             } else {
                 System.out.println("No se encontró al paciente con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido modificar ningún valor: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
         return actualizacionExitosa;
    }
    public boolean eliminarPesos(int IdMascota){
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try{
            String sql = "DELETE FROM pesos WHERE IdMascotas = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            
            
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0){
                 System.out.println("Actualización exitosa");
                 actualizacionExitosa= true;
             } else {
                 System.out.println("No se encontró al paciente con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido eliminar la fila: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
         return actualizacionExitosa;
        
        
    }
    //////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////
    // MÉTODOS PARA LAS VACUNAS
    ////////////////////////////////////////////////////////////////////////
    public boolean insertarVacunas(int IdMascota, String Fecha, String Enfermedad, String FechaProxima) throws SQLException {
         PreparedStatement ps = null;
        boolean InserccionExitosa = false;
        try{
            String sql = "INSERT INTO Vacunas VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setString(2, Fecha);
            ps.setString(3,Enfermedad);
            ps.setString(4,FechaProxima);
           
            int filasActualizadas = ps.executeUpdate();
             
             if (filasActualizadas > 0){
                 System.out.println("Insercción exitosa");
                 InserccionExitosa= true;
             } else {
                 System.out.println("No se encontró la vacuna con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido insertar ningún valor: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                   
                }
            }
         }
        return InserccionExitosa;
     
    }
    public boolean modificarVacunas(int IdMascota, String Fecha, String Enfermedad,
            String FechaProxima){
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try{
            String sql = "UPDATE vacunas SET IdMascota = ?, Fecha = ?, "
                    + "Enfermedad = ?, FechaProxima = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setString(2, Fecha);
            ps.setString(3,Enfermedad);
            ps.setString(4,FechaProxima);
            
            int filasActualizadas = ps.executeUpdate();
             
             if (filasActualizadas > 0){
                 System.out.println("Actualización exitosa");
                 actualizacionExitosa= true;
             } else {
                 System.out.println("No se encontró la vacuna con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido modificar ningún valor: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
         return actualizacionExitosa;
    }
    public boolean eliminarVacunas(int IdMascota){
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try{
            String sql = "DELETE FROM vacunas WHERE IdMascotas = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            
            
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0){
                 System.out.println("Actualización exitosa");
                 actualizacionExitosa= true;
             } else {
                 System.out.println("No se encontró al paciente con id: "+IdMascota);
             }
        } catch (SQLException ex){
            System.out.println("No se ha podido eliminar la fila: "
            +ex.getMessage());
        } finally {
             if (ps != null){
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                }catch (SQLException e){
                    System.out.println("Error al cerrar PreparedStatement: "+e.getMessage());
                    
                }
            }
         }
         return actualizacionExitosa;
        
        
    }
    
}

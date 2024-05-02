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

    public ConsultasMascotasApp() {
        this.conexion = new ConexionSQL().getConnection();
    }

    ////////////////////////////////////////////////////////////////////////
    // MÉTODOS PARA LOS PACIENTES
    ////////////////////////////////////////////////////////////////////////
    
    
    //Método para la insercción de Mascotas (Pacientes), se necesitará de la
    //insercción de un Cliente para poder introducir una mascota.
    public boolean insertarMascotas(int IdMascota, int IdCliente, String AliasMascota,
            String Especie, String Raza, String ColorPelo, String FechaNacimiento,
            int Vacunaciones) throws SQLException {
        PreparedStatement ps = null;
        boolean InserccionExitosa = false;
        
        //Utilizamos lo visto anteriormente con el profesor, en este caso, la
        //utilización de los "ps" o PreparedStatement donde alojaremos las variables
        //que necesitamos para colocar en nuestro string sql "?".
        try {
            String sql = "INSERT INTO pacientes VALUES (?,?,?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setInt(2, IdCliente);
            ps.setString(3, AliasMascota);
            ps.setString(4, Especie);
            ps.setString(5, Raza);
            ps.setString(6, ColorPelo);
            ps.setString(7, FechaNacimiento);
            ps.setInt(8, Vacunaciones);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Insercción exitosa");
                InserccionExitosa = true;
            } else {
                System.out.println("No se encontró al paciente con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido insertar ningún valor: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return InserccionExitosa;

    }
    
    
    //Método para introducir a las mascotas mediante un TXT.
    //La utilización de este método viene ligada a su contraparte en la aplicación
    //pues necesita de la variable String "consulta" que será aquella que almacene
    //lo que el txt tiene escrito.
    public boolean insertarMascotasTXT(String consulta) throws SQLException {
    PreparedStatement ps = null;
    boolean insercionExitosa = false;
    
    try {
        ps = conexion.prepareStatement(consulta);
        int filasActualizadas = ps.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Insercción exitosa");
            insercionExitosa = true;
        } else {
            System.out.println("No se insertaron filas.");
        }
    } catch (SQLException ex) {
        System.out.println("Error al ejecutar la consulta de inserción: " + ex.getMessage());
    } finally {
        if (ps != null) {
            try {
                ps.close();
                System.out.println("Conexión cerrada con éxito.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }
    
    return insercionExitosa;
}

    //Con este método tuve bastantes problemas pues, me cegué completamente
    //en que el IdCliente debía modificarse también pero, no era así. Tras
    //hora y media de sufrimiento buscando el problema, le pregunté a un compañero
    //y me dió la clave para hacerlo funcionar; quitar el IdCliente de las variables
    //a pedir. Funcionó.
    public boolean modificarMascotas(int IdMascota, String AliasMascota,
            String Especie, String Raza, String ColorPelo, String FechaNacimiento,
            int Vacunaciones) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try {
            String sql
                    = "UPDATE pacientes SET "
                    + "AliasMascota = ?, "
                    + "Especie = ?, "
                    + "Raza = ?, "
                    + "Color_Pelo = ?, "
                    + "Fecha_Nacimiento = ?, "
                    + "Vacunaciones = ? "
                    + "WHERE IdMascotas = ?; ";

            ps = conexion.prepareStatement(sql);
            ps.setString(1, AliasMascota);
            ps.setString(2, Especie);
            ps.setString(3, Raza);
            ps.setString(4, ColorPelo);
            ps.setString(5, FechaNacimiento);
            ps.setInt(6, Vacunaciones);
            ps.setInt(7, IdMascota);
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se encontró al paciente con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido modificar ningún valor: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return actualizacionExitosa;
    }

    
    //El método para eliminar una mascota, no tiene mucho más misterio, le 
    //introduces una IdMascota.
    public boolean eliminarMascota(int IdMascota) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try {
            String sql = "DELETE FROM pacientes WHERE IdMascotas = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);

            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se encontró al paciente con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido eliminar la fila: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return actualizacionExitosa;

    }

    //Este es el método con el que hacemos un listado completo.
    //Se toma una consulta con todos los datos, un while y la creación de un objeto
    //"pacientes" para almacenar las variables de esa primera vuelta del bucle.
    //Se devuelve el método "imprimir" que es un toString.
    public String obtenerTextoPacientes() {
        StringBuilder texto = new StringBuilder();

        try {
            String sql = "SELECT IdMascotas, IdCliente, AliasMascota, Especie,"
                    + "Raza, Color_Pelo, Fecha_Nacimiento, Vacunaciones FROM "
                    + "pacientes;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int IdMascota = rs.getInt("IdMascotas");
                int IdCliente = rs.getInt("IdCliente");
                String AliasMascota = rs.getString("AliasMascota");
                String Especie = rs.getString("Especie");
                String Raza = rs.getString("Raza");
                String ColorPelo = rs.getString("Color_Pelo");
                String FechaNacimiento = rs.getString("Fecha_Nacimiento");
                int Vacunaciones = rs.getInt("Vacunaciones");
                pacientes pacient = new pacientes(IdMascota, IdCliente,
                        AliasMascota, Especie, Raza, ColorPelo, FechaNacimiento, Vacunaciones);
                texto.append(pacient.imprimir()).append("\n");
            }
            rs.close();
            ps.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            System.out.println("Error al crear la lista " + ex.getMessage());
        }

        return texto.toString();
    }

    
    //Este caso tiene una base al 90% exacta al anterior método, con solo un cambio
    //y es que la consulta está hecha para tomar a los 3 primeros del top.
    public String obtenerTextoTopMascotasConMasVacunas(int cantidad) {
        StringBuilder texto = new StringBuilder();

        try {
            String sql = "SELECT IdMascotas, IdCliente, AliasMascota, Especie,"
                    + "Raza, Color_Pelo, Fecha_Nacimiento, Vacunaciones FROM "
                    + "pacientes ORDER BY Vacunaciones DESC LIMIT ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            //Aquí se puede observar como nuestro limit de rows es "?"
            //Pues, si quisiesemos, podríamos introducir aquí mismo el número
            //de pacientes que querramos en el top, pero preferí dejarlo a elección.
            ps.setInt(1, cantidad); 
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int IdMascota = rs.getInt("IdMascotas");
                int IdCliente = rs.getInt("IdCliente");
                String AliasMascota = rs.getString("AliasMascota");
                String Especie = rs.getString("Especie");
                String Raza = rs.getString("Raza");
                String ColorPelo = rs.getString("Color_Pelo");
                String FechaNacimiento = rs.getString("Fecha_Nacimiento");
                int Vacunaciones = rs.getInt("Vacunaciones");
                pacientes pacient = new pacientes(IdMascota, IdCliente,
                        AliasMascota, Especie, Raza, ColorPelo, FechaNacimiento, Vacunaciones);
                texto.append(pacient.imprimir()).append("\n");
            }
            rs.close();
            ps.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            System.out.println("Error al obtener el top de mascotas: " + ex.getMessage());
        }

        return texto.toString();
    }

    //Exactamente lo mismo que el método anterior.
    public String obtenerTextoTopMascotasMasPesadas(int cantidad) {
        StringBuilder texto = new StringBuilder();

        try {
            String sql = "SELECT p.IdMascotas, p.IdCliente, p.AliasMascota, p.Especie,"
                    + "p.Raza, p.Color_Pelo, p.Fecha_Nacimiento, pe.Peso "
                    + "FROM pacientes p "
                    + "INNER JOIN pesos pe ON p.IdMascotas = pe.IdMascotas "
                    + "ORDER BY pe.Peso DESC LIMIT ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cantidad); // Establecer el límite de resultados
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int IdMascota = rs.getInt("IdMascotas");
                int IdCliente = rs.getInt("IdCliente");
                String AliasMascota = rs.getString("AliasMascota");
                String Especie = rs.getString("Especie");
                String Raza = rs.getString("Raza");
                String ColorPelo = rs.getString("Color_Pelo");
                String FechaNacimiento = rs.getString("Fecha_Nacimiento");
                int Peso = rs.getInt("Peso");
                pacientes pacient = new pacientes(IdMascota, IdCliente,
                        AliasMascota, Especie, Raza, ColorPelo, FechaNacimiento, Peso);
                texto.append(pacient.imprimir()).append("\n");
            }
            rs.close();
            ps.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            System.out.println("Error al obtener el top de mascotas más pesadas: " + ex.getMessage());
        }

        return texto.toString();
    }

    //Más de lo mismo, solo cambia la consulta.
    public String obtenerTextoTopMascotasMenosPesadas(int cantidad) {
        StringBuilder texto = new StringBuilder();

        try {
            String sql = "SELECT p.IdMascotas, p.IdCliente, p.AliasMascota, p.Especie,"
                    + "p.Raza, p.Color_Pelo, p.Fecha_Nacimiento, pe.Peso "
                    + "FROM pacientes p "
                    + "INNER JOIN pesos pe ON p.IdMascotas = pe.IdMascotas "
                    + "ORDER BY pe.Peso ASC LIMIT ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cantidad); // Establecer el límite de resultados
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int IdMascota = rs.getInt("IdMascotas");
                int IdCliente = rs.getInt("IdCliente");
                String AliasMascota = rs.getString("AliasMascota");
                String Especie = rs.getString("Especie");
                String Raza = rs.getString("Raza");
                String ColorPelo = rs.getString("Color_Pelo");
                String FechaNacimiento = rs.getString("Fecha_Nacimiento");
                int Peso = rs.getInt("Peso");
                pacientes pacient = new pacientes(IdMascota, IdCliente,
                        AliasMascota, Especie, Raza, ColorPelo, FechaNacimiento, Peso);
                texto.append(pacient.imprimir()).append("\n");
            }
            rs.close();
            ps.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            System.out.println("Error al obtener el top de mascotas menos pesadas: " + ex.getMessage());
        }

        return texto.toString();
    }

    //Lo mismo.
    public String obtenerRecuentoPorEspecie() {
        StringBuilder texto = new StringBuilder();

        try {
            String sql = "SELECT Especie, COUNT(*) AS Cantidad FROM pacientes GROUP BY Especie";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String especie = rs.getString("Especie");
                int cantidad = rs.getInt("Cantidad");
                texto.append(especie).append(": ").append(cantidad).append("\n");
            }
            rs.close();
            ps.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            System.out.println("Error al obtener el recuento por especie: " + ex.getMessage());
        }

        return texto.toString();
    }

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    // MÉTODOS PARA LOS CLIENTES
    ////////////////////////////////////////////////////////////////////////
    public boolean insertarClientes(int IdCliente, String PrimerApellido,
            int CuentaBanco, int Telefono) throws SQLException {
        PreparedStatement ps = null;
        boolean InserccionExitosa = false;
        try {
            String sql = "INSERT INTO clientes VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdCliente);
            ps.setString(2, PrimerApellido);
            ps.setInt(3, CuentaBanco);
            ps.setInt(4, Telefono);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Insercción exitosa");
                InserccionExitosa = true;
            } else {
                System.out.println("No se encontró al cliente con id: " + IdCliente);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido insertar ningún valor: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return InserccionExitosa;

    }

    public boolean eliminarCliente(int IdCliente) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try {
            String sql = "DELETE FROM clientes WHERE IdCliente = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdCliente);

            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se encontró al cliente con id: " + IdCliente);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido eliminar la fila: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

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
        try {
            String sql = "INSERT INTO Pesos VALUES (?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setString(2, Fecha);
            ps.setDouble(3, Peso);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Insercción exitosa");
                InserccionExitosa = true;
            } else {
                System.out.println("No se encontró la mascota con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido insertar ningún valor: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return InserccionExitosa;

    }

    public boolean modificarPesos(int IdMascota, String Fecha, double Peso) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try {
            String sql = "UPDATE pesos SET IdMascota = ?, Fecha = ?,"
                    + "Peso = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setString(2, Fecha);
            ps.setDouble(3, Peso);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se encontró al paciente con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido modificar ningún valor: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return actualizacionExitosa;
    }

    public boolean eliminarPesos(int IdMascota) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try {
            String sql = "DELETE FROM pesos WHERE IdMascotas = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);

            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se encontró al paciente con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido eliminar la fila: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

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
        try {
            String sql = "INSERT INTO Vacunas VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setString(2, Fecha);
            ps.setString(3, Enfermedad);
            ps.setString(4, FechaProxima);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Insercción exitosa");
                InserccionExitosa = true;
            } else {
                System.out.println("No se encontró la vacuna con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido insertar ningún valor: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return InserccionExitosa;

    }

    public boolean modificarVacunas(int IdMascota, String Fecha, String Enfermedad,
            String FechaProxima) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try {
            String sql = "UPDATE vacunas SET IdMascota = ?, Fecha = ?, "
                    + "Enfermedad = ?, FechaProxima = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);
            ps.setString(2, Fecha);
            ps.setString(3, Enfermedad);
            ps.setString(4, FechaProxima);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se encontró la vacuna con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido modificar ningún valor: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return actualizacionExitosa;
    }

    public boolean eliminarVacunas(int IdMascota) {
        PreparedStatement ps = null;
        boolean actualizacionExitosa = false;
        try {
            String sql = "DELETE FROM vacunas WHERE IdMascotas = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdMascota);

            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Actualización exitosa");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se encontró al paciente con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido eliminar la fila: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return actualizacionExitosa;

    }

    
    
    //////////////////////////////////////////////////////////////
    // Métodos para las personas
    //////////////////////////////////////////////////////////////
    public boolean insertarPersonas(int IdPersona, String Nombre, String Apellido, int Telefono) throws SQLException {
        PreparedStatement ps = null;
        boolean InserccionExitosa = false;
        try {
            String sql = "INSERT INTO personas VALUES (?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, IdPersona);
            ps.setString(2, Nombre);
            ps.setString(3, Apellido);
            ps.setInt(4, Telefono);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Insercción exitosa");
                InserccionExitosa = true;
            } else {
                System.out.println("No se encontró a la persona con id: " + IdPersona);
            }
        } catch (SQLException ex) {
            System.out.println("No se ha podido insertar ningún valor: "
                    + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    System.out.println("Conexión cerrada con éxito.");
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());

                }
            }
        }
        return InserccionExitosa;

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.tema17.practica.mascotas.model;

/**
 *
 * @author Andrés
 */
public class clientes {
    private int IdCliente;
    private String PrimerApellido;
    private String CuentaBanco;
    private int Telefono;

    

    //Constructores
    
    public clientes(int IdCliente, String PrimerApellido, String CuentaBanco, int Telefono) {
        this.IdCliente = IdCliente;
        this.PrimerApellido = PrimerApellido;
        this.CuentaBanco = CuentaBanco;
        this.Telefono = Telefono;
    }

    public clientes() {
        this.IdCliente = 0;
        this.PrimerApellido= "Ninguno";
        this.CuentaBanco = "Nada";
        this.Telefono = 0;
    }
    
    //Metodos
    @Override
    public String toString() {
        return "El cliente es" + this.IdCliente + ", su primer apellido es" 
                + this.PrimerApellido + ", su cuenta del banco es "
                + this.CuentaBanco + " y su teléfono es " + this.Telefono;
    }
    //Getter y Setters
    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getCuentaBanco() {
        return CuentaBanco;
    }

    public void setCuentaBanco(String CuentaBanco) {
        this.CuentaBanco = CuentaBanco;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
}

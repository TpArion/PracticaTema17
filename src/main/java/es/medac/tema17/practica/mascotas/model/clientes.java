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
    private int CuentaBanco;
    private int Telefono;

    

    //Constructores
    
    public clientes(int IdCliente, String PrimerApellido, int CuentaBanco, int Telefono) {
        this.IdCliente = IdCliente;
        this.PrimerApellido = PrimerApellido;
        this.CuentaBanco = CuentaBanco;
        this.Telefono = Telefono;
    }

    public clientes() {
        this.IdCliente = 0;
        this.PrimerApellido= "Ninguno";
        this.CuentaBanco = 0;
        this.Telefono = 0;
    }
    
    //Metodos
    
    public String imprimir() {
        return "INFORME DEL CLIENTE CREADO" +"\n"
                +"-----------------------" + "\n"
                +"Su id es: "+this.IdCliente + "\n"
                +"Su primer apellido es: " 
                + this.PrimerApellido + "\n"
                +"Su cuenta del banco es : "
                + this.CuentaBanco +"\n"
                +"Su teléfono es " + this.Telefono;
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

    public int getCuentaBanco() {
        return CuentaBanco;
    }

    public void setCuentaBanco(int CuentaBanco) {
        this.CuentaBanco = CuentaBanco;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
}

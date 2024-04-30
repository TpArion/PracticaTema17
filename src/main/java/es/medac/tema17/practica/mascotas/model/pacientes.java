/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.tema17.practica.mascotas.model;

/**
 *
 * @author Andrés
 */
public class pacientes {
    
    private int IdMascota;
    private int IdCliente;
    private String AliasMascota;
    private String Especie;
    private String Raza;
    private String ColorPelo;
    private String FechaNacimiento;
    private int Vacunaciones;

    //Constructores
    
    public pacientes(){
        this.IdMascota = 0;
        this.IdCliente= 0;
        this.AliasMascota= "Nada";
        this.Especie= "Nada";
        this.Raza= "Nada";
        this.ColorPelo= "Ninguno";
        this.FechaNacimiento= "DD-MM-YYYY";
        this.Vacunaciones = 0;
    }
    
    public pacientes(int IdMascota, int IdCliente, 
            String AliasMascota, String Especie, String Raza, 
            String ColorPelo, String FechaNacimiento,
            int Vacunaciones) {
        this.IdMascota = IdMascota;
        this.IdCliente = IdCliente;
        this.AliasMascota = AliasMascota;
        this.Especie = Especie;
        this.Raza = Raza;
        this.ColorPelo = ColorPelo;
        this.FechaNacimiento = FechaNacimiento;
        this.Vacunaciones = Vacunaciones;
    }
    public pacientes(int IdMascota, 
            String AliasMascota, String Especie, String Raza, 
            String ColorPelo, String FechaNacimiento,
            int Vacunaciones) {
        this.IdMascota = IdMascota;
        this.AliasMascota = AliasMascota;
        this.Especie = Especie;
        this.Raza = Raza;
        this.ColorPelo = ColorPelo;
        this.FechaNacimiento = FechaNacimiento;
        this.Vacunaciones = Vacunaciones;
    }
    //Metodo ToString
    public String imprimir (){
        return "GESTIÓN DE DATOS" + "\n"
                + "Id Mascota: "+this.IdMascota+ "\n"
                + "Id Cliente: "+this.IdCliente+ "\n"
                + "Alias Mascota: "+this.AliasMascota+ "\n"
                + "Especie: "+this.Especie+ "\n"
                + "Raza: "+this.Raza+ "\n"
                + "ColorPelo: "+this.ColorPelo+ "\n"
                + "FechaNacimiento: "+this.FechaNacimiento+ "\n"
                + "Vacunaciones: "+this.Vacunaciones;
                
                        
    }
    
    //Getters Y Setters.
    
    public int getIdMascota() {
        return IdMascota;
    }

    public void setIdMascota(int IdMascota) {
        this.IdMascota = IdMascota;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getAliasMascota() {
        return AliasMascota;
    }

    public void setAliasMascota(String AliasMascota) {
        this.AliasMascota = AliasMascota;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public String getColorPelo() {
        return ColorPelo;
    }

    public void setColorPelo(String ColorPelo) {
        this.ColorPelo = ColorPelo;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public int getVacunaciones() {
        return Vacunaciones;
    }

    public void setVacunaciones(int Vacunaciones) {
        this.Vacunaciones = Vacunaciones;
    }
    
}

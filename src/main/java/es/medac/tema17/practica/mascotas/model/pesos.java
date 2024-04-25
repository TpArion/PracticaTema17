/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.tema17.practica.mascotas.model;

/**
 *
 * @author Andrés
 */
public class pesos extends pacientes {
    
    private int IdMascota;
    private String Fecha;
    private double Peso;
    
    public pesos(){
        this.IdMascota= 0;
        this.Fecha= "0000-00-00";
        this.Peso= 0;
    }

    public pesos(int IdMascota, String Fecha, int Peso) {
        this.IdMascota = IdMascota;
        this.Fecha = Fecha;
        this.Peso = Peso;
    }
    
    public int getIdMascota() {
        return IdMascota;
    }

    public void setIdMascota(int IdMascota) {
        this.IdMascota = IdMascota;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }
    
}

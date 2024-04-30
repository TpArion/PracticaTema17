/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.tema17.practica.mascotas.model;

/**
 *
 * @author Andrés
 */
public class vacunas extends pacientes {
    private int IdMascota;
    private String Fecha;
    private String Enfermedad;
    private String FechaProxima;

    public vacunas() {
        this.IdMascota = 0;
        this.Fecha = "0000-00-00";
        this.Enfermedad = "nada";
        this.FechaProxima = "0000-00-00";
    }
    
    public vacunas(int IdMascota, String Fecha, String Enfermedad,
            String FechaProxima){
        this.IdMascota = IdMascota;
        this.Fecha = Fecha;
        this.Enfermedad = Enfermedad;
        this.FechaProxima = FechaProxima;
    }
    
    public String imprimir(){
        return "VACUNAS" + "\n" 
                + "Id Mascota: "+this.IdMascota+ "\n"
                + "Enfermedad: "+this.Enfermedad+ "\n"
                + "Fecha: "+this.Fecha+ "\n"
                + "Fecha Próxima: "+this.FechaProxima+ "\n";
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

    public String getEnfermedad() {
        return Enfermedad;
    }

    public void setEnfermedad(String Enfermedad) {
        this.Enfermedad = Enfermedad;
    }

    public String getFechaProxima() {
        return FechaProxima;
    }

    public void setFechaProxima(String FechaProxima) {
        this.FechaProxima = FechaProxima;
    }
    
}

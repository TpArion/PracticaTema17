/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.medac.tema17.practica.mascotas.model;

/**
 *
 * @author Andrés
 */
public class personas extends clientes {
    
    private int IdPersona;
    private String NombrePersona;
    private String ApellidoPersona;
    
    public personas(){
        this.IdPersona = 0;
        this.NombrePersona = "nada";
        this.ApellidoPersona = "nada";
    }

    public personas(int IdPersona, String NombrePersona, String ApellidoPersona){
        this.IdPersona = IdPersona;
        this.NombrePersona = NombrePersona;
        this.ApellidoPersona = ApellidoPersona;
    }
    

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getNombrePersona() {
        return NombrePersona;
    }

    public void setNombrePersona(String NombrePersona) {
        this.NombrePersona = NombrePersona;
    }

    public String getApellidoPersona() {
        return ApellidoPersona;
    }

    public void setApellidoPersona(String ApellidoPersona) {
        this.ApellidoPersona = ApellidoPersona;
    }
    
}

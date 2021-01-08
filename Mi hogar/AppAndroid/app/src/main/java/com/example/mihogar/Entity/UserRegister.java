
package com.example.mihogar.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegister {

    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("nombres")
    @Expose
    private String nombres;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("contrasenia")
    @Expose
    private String contrasenia;
    @SerializedName("fecha_naci")
    @Expose
    private String fechaNaci;
    @SerializedName("sexo")
    @Expose
    private String sexo;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserRegister() {
    }

    /**
     * 
     * @param fechaNaci
     * @param correo
     * @param contrasenia
     * @param telefono
     * @param sexo
     * @param nombres
     */
    public UserRegister(String correo, String nombres, String telefono, String contrasenia, String fechaNaci, String sexo) {
        super();
        this.correo = correo;
        this.nombres = nombres;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.fechaNaci = fechaNaci;
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(String fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}

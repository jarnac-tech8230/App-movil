
package com.example.mihogar.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imagen {

    @SerializedName("ruta")
    @Expose
    private String ruta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Imagen() {
    }

    /**
     * 
     * @param ruta
     */
    public Imagen(String ruta) {
        super();
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}

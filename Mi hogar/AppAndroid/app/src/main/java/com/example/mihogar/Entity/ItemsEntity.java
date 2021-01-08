
package com.example.mihogar.Entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemsEntity {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("categoria")
    @Expose
    private String categoria;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("banio")
    @Expose
    private String banio;
    @SerializedName("dormitorio")
    @Expose
    private String dormitorio;
    @SerializedName("anio_construido")
    @Expose
    private String anioConstruido;
    @SerializedName("bien_estar")
    @Expose
    private String bienEstar;
    @SerializedName("orientacion")
    @Expose
    private String orientacion;
    @SerializedName("cocina")
    @Expose
    private String cocina;
    @SerializedName("parking")
    @Expose
    private String parking;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("visto")
    @Expose
    private String visto;
    @SerializedName("rut_empresa")
    @Expose
    private String rutEmpresa;
//    @SerializedName("imagen")
//    @Expose
//    private List<Imagen> imagen = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ItemsEntity() {
    }

    /**
     * 
     * @param descripcion
     * @param area
     * @param parking
     * @param categoria
     * @param banio
     * @param direccion
     * @param rutEmpresa
//     * @param imagen
     * @param orientacion
     * @param video
     * @param visto
     * @param nombre
     * @param dormitorio
     * @param id
     * @param bienEstar
     * @param anioConstruido
     * @param cocina
     */
    public ItemsEntity(String id, String nombre, String categoria, String direccion, String descripcion, String area, String banio, String dormitorio, String anioConstruido, String bienEstar, String orientacion, String cocina, String parking, String video, String visto, String rutEmpresa) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.area = area;
        this.banio = banio;
        this.dormitorio = dormitorio;
        this.anioConstruido = anioConstruido;
        this.bienEstar = bienEstar;
        this.orientacion = orientacion;
        this.cocina = cocina;
        this.parking = parking;
        this.video = video;
        this.visto = visto;
        this.rutEmpresa = rutEmpresa;
//        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBanio() {
        return banio;
    }

    public void setBanio(String banio) {
        this.banio = banio;
    }

    public String getDormitorio() {
        return dormitorio;
    }

    public void setDormitorio(String dormitorio) {
        this.dormitorio = dormitorio;
    }

    public String getAnioConstruido() {
        return anioConstruido;
    }

    public void setAnioConstruido(String anioConstruido) {
        this.anioConstruido = anioConstruido;
    }

    public String getBienEstar() {
        return bienEstar;
    }

    public void setBienEstar(String bienEstar) {
        this.bienEstar = bienEstar;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getCocina() {
        return cocina;
    }

    public void setCocina(String cocina) {
        this.cocina = cocina;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVisto() {
        return visto;
    }

    public void setVisto(String visto) {
        this.visto = visto;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

//    public List<Imagen> getImagen() {
//        return imagen;
//    }
//
//    public void setImagen(List<Imagen> imagen) {
//        this.imagen = imagen;
//    }

}

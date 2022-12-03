

package com.emergentes.modelo;


import java.io.InputStream;



public class Producto {
    private int id;
    private String nombre;
    private String codigo;
    private String descripcion;
   
    private String img;

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion + ", img=" + img + '}';
    }

    
    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   
 
}

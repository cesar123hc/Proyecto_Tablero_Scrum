/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author cesar
 */
public class ProyectoVO {
    int id;
    String nombre ;
    
    String creador;
    String fecha;

    public ProyectoVO(int id, String nombre, String creador, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.creador = creador;
        this.fecha = fecha;
        
    }

    public ProyectoVO() {
        
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCreador() {
        return creador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ProyectoVO{" + "id=" + id + ", nombre=" + nombre + ", creador=" + creador + ", fecha=" + fecha + '}';
    }

    
    
}

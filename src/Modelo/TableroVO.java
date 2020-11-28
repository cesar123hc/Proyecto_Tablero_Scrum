/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class TableroVO {
    private int id;
    private String nombre;
    private String fecha;
    private String creador;
    private int idProyecto;

    public TableroVO(int id, String nombre, String fecha, String creador, int idProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.creador = creador;
        this.idProyecto = idProyecto;
    }

    public TableroVO() {
        
    }

    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCreador() {
        return creador;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "TableroVO{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", creador=" + creador + ", idProyecto=" + idProyecto + '}';
    }

    
    
    
    
}

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
public class UsuarioVO {
    private String  correo;
    private String nombre;
    private String contras;
    private String apellido;
    private String fechaNac;
    private String pregunta;

    public UsuarioVO(String correo, String nombre, String contras, String fechaNac, String pregunta) {
        this.correo = correo;
        this.nombre = nombre;
        this.contras = contras;
        this.fechaNac = fechaNac;
        this.pregunta = pregunta;
    }

    public UsuarioVO() {
        
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContras() {
        return contras;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContras(String contras) {
        this.contras = contras;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" + "correo=" + correo + ", nombre=" + nombre + ", contras=" + contras + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", pregunta=" + pregunta + '}';
    }
    

}

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
public class SincronizacionVO {
    private String Correo;
    private int id;

    public SincronizacionVO(String Correo, int id) {
        this.Correo = Correo;
        this.id = id;
    }

    public SincronizacionVO() {
       
    }

    public String getCorreo() {
        return Correo;
    }

    public int getId() {
        return id;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SincronizacionVO{" + "Correo=" + Correo + ", id=" + id + '}';
    }
    
}

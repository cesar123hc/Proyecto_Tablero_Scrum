/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author cesar
 */
public interface Proyecto_DAO {
    public boolean create(ProyectoVO proyecto)throws Exception;

    public List<ProyectoVO> readAll()throws Exception;
    
    public ProyectoVO read(String clave)throws Exception;
    
    public boolean update(ProyectoVO proyecto)throws Exception;
    
    public boolean delete(ProyectoVO proyecto)throws Exception; 
    
    public boolean validar(String correo,String contrasena)throws Exception;
}

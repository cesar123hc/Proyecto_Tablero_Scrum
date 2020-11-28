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
public interface Usuario_DAO {
    
    public boolean create(UsuarioVO usuario)throws Exception;

    public List<UsuarioVO> readAll()throws Exception;
    
    public UsuarioVO read(String clave)throws Exception;
    
    public boolean update(UsuarioVO usuario)throws Exception;
    
    public boolean delete(UsuarioVO usuario)throws Exception; 
    
    public boolean validar(String correo,String contrasena)throws Exception;
}

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
public interface Sincronizacion_DAO {
    public boolean create(SincronizacionVO sincr)throws Exception;

    public List<SincronizacionVO> readAll()throws Exception;
    
    public SincronizacionVO read(String clave)throws Exception;
    
    public boolean update(SincronizacionVO sincr)throws Exception;
    
    public boolean delete(SincronizacionVO sincr)throws Exception;
    
    public List<SincronizacionVO> readAllIntegrantes(int id) throws Exception;
    
    
}

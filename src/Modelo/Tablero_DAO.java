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
public interface Tablero_DAO {
    public boolean create(TableroVO tablero)throws Exception;

    public List<TableroVO> readAll()throws Exception;
    
    public TableroVO read(String clave)throws Exception;
    
    public boolean update(TableroVO tablero)throws Exception;
    
    public boolean delete(TableroVO tablero)throws Exception; 
}

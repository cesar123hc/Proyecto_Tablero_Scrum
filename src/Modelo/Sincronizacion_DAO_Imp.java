/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author cesar
 */
public class Sincronizacion_DAO_Imp implements Sincronizacion_DAO{

    @Override
    public boolean create(SincronizacionVO sincr) throws Exception {
        System.out.println(sincr.toString());
        boolean created = false;
        Statement stm = null;
        Connection con = null;
        String auxId=Integer.toString(sincr.getId());
        String sql = "INSERT INTO sincronizacion values ('" + sincr.getCorreo()+"',"+auxId+")";
        System.out.println(sql);
        ConexionDB cc = new ConexionDB();
        System.out.println(sql);
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            System.out.println("Creacion Realizada");
            stm.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en create SQLException: " + e.getMessage());
        } catch (NullPointerException e){
            throw new Exception("Error en create objeto null: " + e.getMessage());
        } catch(Exception e){
            throw new Exception("Error en create: " + e.getMessage());
        }
        return created;
    }

    @Override
    public List<SincronizacionVO> readAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SincronizacionVO read(String clave) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SincronizacionVO sincr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(SincronizacionVO sincr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

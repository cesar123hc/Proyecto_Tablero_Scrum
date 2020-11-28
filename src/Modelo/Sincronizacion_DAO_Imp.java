/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from sincronizacion ";
         System.out.println(sql);
        List<SincronizacionVO> listaSicroni = new ArrayList<SincronizacionVO>();

        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                SincronizacionVO c = new SincronizacionVO(rs.getString(1),rs.getInt(2));
                listaSicroni.add(c);
             
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en readAll SQLException: " + e.getCause().toString());
        }catch(Exception e){
            throw new Exception("Error en readAll: " + e.getCause().toString());
        }

        return listaSicroni;
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
    @Override
     public List<SincronizacionVO> readAllIntegrantes(int id) throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String auxId=Integer.toString(id);
        String sql = "select * from sincronizacion where id= "+auxId;
         System.out.println(sql);
        List<SincronizacionVO> listaSicroni = new ArrayList<SincronizacionVO>();

        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                SincronizacionVO c = new SincronizacionVO(rs.getString(1),rs.getInt(2));
                listaSicroni.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en readAll SQLException: " + e.getCause().toString());
        }catch(Exception e){
            throw new Exception("Error en readAll: " + e.getCause().toString());
        }

        return listaSicroni;
    }
    
}

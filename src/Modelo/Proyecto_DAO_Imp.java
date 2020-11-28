/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
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
public class Proyecto_DAO_Imp implements Proyecto_DAO{
    @Override
    public boolean create(ProyectoVO proyecto)throws Exception{
        System.out.println(proyecto.toString());
        boolean created = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO proyecto values (NULL,'" + proyecto.getNombre()+"','"+proyecto.getCreador()+"','"+ proyecto.getFecha()+"')";
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
    public List<ProyectoVO> readAll()throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from proyecto order by id";

        List<ProyectoVO> listaProyectos = new ArrayList<ProyectoVO>();

        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                ProyectoVO c = new ProyectoVO(rs.getInt(1),
                        rs.getString(2),rs.getString(3),rs.getString(4));
                listaProyectos.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en readAll SQLException: " + e.getCause().toString());
        }catch(Exception e){
            throw new Exception("Error en readAll: " + e.getCause().toString());
        }

        return listaProyectos;
        
    }
    
    @Override
    public ProyectoVO read(String clave)throws Exception{
        return null;
        
    }
    
    @Override
    public boolean update(ProyectoVO proyecto)throws Exception{
       // System.out.println(proyecto.toString());
        boolean update = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "update proyecto set nombre='"+proyecto.getNombre()+"' where id=" + proyecto.getId();
        ConexionDB cc = new ConexionDB();
        System.out.println(sql);
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            update = true;
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
        return update;
    }
    
    @Override
    public boolean delete(ProyectoVO proyecto)throws Exception{
        System.out.println(proyecto.toString());
        boolean delete = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "delete from proyecto where id=" + proyecto.getId();
        ConexionDB cc = new ConexionDB();
        System.out.println(sql);
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            delete = true;
            System.out.println("proyecto eliminado");
            stm.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en create SQLException: " + e.getMessage());
        } catch (NullPointerException e){
            throw new Exception("Error en create objeto null: " + e.getMessage());
        } catch(Exception e){
            throw new Exception("Error en create: " + e.getMessage());
        }
        return delete;
    }
    
    @Override
    public boolean validar(String correo,String contrasena)throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean band=false;
        String sql = "select * from usuario where correo= '"+correo+"'";
        System.out.println(sql);
       
        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            System.out.println("-------Ejecuto consulta de validación de usuario----");
            while (rs.next()) {
                band=true;
            }

            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en validar SQLException de usuario: " + e.getMessage());
        } catch(Exception e){
            throw new Exception("Error en validar Exception de usuario: " + e.getMessage());
        }
      
        return band;
        
    }
    public int sicronizar()throws Exception{
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(id) AS id FROM proyecto";
        int id = 0;

        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                id=rs.getInt(1);
                
            }
            
            stm.close();
            rs.close();
            con.close();
        } catch (CommunicationsException e) {
            throw new Exception("Error en read ComunicationsException: " + e.getCause().toString());
        } catch (SQLException e){
            throw new Exception("Error en read SQLException: " + e.getCause().toString());
        }catch(Exception e){
            throw new Exception("Error en read Exception: " + e.getMessage());
        }
        return id;
    }
}

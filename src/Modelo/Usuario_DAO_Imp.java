/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.CommunicationsException;
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
public class Usuario_DAO_Imp implements Usuario_DAO{
    @Override
    public boolean create(UsuarioVO usuario) throws Exception{
        System.out.println(usuario.toString());
        boolean created = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO usuario values ('" + usuario.getCorreo() +"','"+ usuario.getNombre()+"','"+usuario.getApellido()+"','"+ usuario.getContras()+"','"+ usuario.getFechaNac()+"','"+usuario.getPregunta() +"')";
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
    public UsuarioVO read(String correo) throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from usuario where correo='" + correo+"'";

        UsuarioVO usuario = new UsuarioVO();

        try {
            con = new ConexionDB().conectarMySQL();//cambiar aquí la conexión
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                //CAMBIAR AQUI SI LOS MÉTODOS VAREAN
                usuario.setCorreo(rs.getString(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setContras(rs.getString(4));
                usuario.setFechaNac(rs.getString(5));
                usuario.setPregunta(rs.getString(6));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (CommunicationsException e) {
            throw new Exception("Error en read ComunicationsException de usuario: " + e.getCause().toString());
        } catch (SQLException e){
            throw new Exception("Error en read SQLException de usuario: " + e.getCause().toString());
        }catch(Exception e){
            throw new Exception("Error en read Exception de usuario: " + e.getMessage());
        }
        return usuario;
    }

    public List<UsuarioVO> readAll() throws Exception{
        return null;
   
        
    }

   
    @Override
    public boolean update(UsuarioVO usuario) throws Exception {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;        
        String sql = "update usuario set nombre='" + usuario.getNombre()+"', apellido='"+usuario.getApellido()+"', contra='"+usuario.getContras()+"' ,fecha_nacimiento='"+usuario.getFechaNac()+"' ,pregunta='"+usuario.getPregunta()+"' where correo = '"+usuario.getCorreo()+"'";
        System.out.println(sql);
        try {
            connect = new ConexionDB().conectarMySQL();//abría que cambiar aquí
            stm = connect.createStatement();
            actualizar= stm.execute(sql);
            stm.close();
            connect.close();
        } catch (SQLException e) {
            throw new Exception("Error en update SQLException: " + e.getMessage());
        } catch(Exception e){
            throw new Exception("Error en update Exception " + e.getMessage());
        }
        return actualizar;
    }

   
    public boolean delete(UsuarioVO usuario) throws Exception{
        return false;
        
    }

    @Override
    public boolean validar(String correo, String contrasena) throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean band=false;
        String sql = "select * from usuario where contra='"+contrasena+"' and correo= '"+correo+"'";
       
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
    
    
}

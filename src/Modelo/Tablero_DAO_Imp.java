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
public class Tablero_DAO_Imp implements Tablero_DAO{

    @Override
    public boolean create(TableroVO tablero) throws Exception {
        System.out.println(tablero.toString());
        boolean created = false;
        Statement stm = null;
        Connection con = null;
        String auxId=Integer.toString(tablero.getIdProyecto());
        String sql = "INSERT INTO tablero values (NULL,'" + tablero.getNombre()+"','"+tablero.getFecha()+"','"+ tablero.getCreador()+"',"+auxId+")";
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
    public List<TableroVO> readAll() throws Exception {
       Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from tablero order by id";
        System.out.println(sql);
        List<TableroVO> listaTableros = new ArrayList<TableroVO>();

        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                TableroVO c = new TableroVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5));
                listaTableros.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en readAll SQLException: " + e.getCause().toString());
        }catch(Exception e){
            throw new Exception("Error en readAll: " + e.getCause().toString());
        }

        return listaTableros;
    }

    @Override
    public TableroVO read(String clave) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(TableroVO tablero) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(TableroVO tablero) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<TableroVO> readAllProyecto(int id) throws Exception {
       Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
         String auxId=Integer.toString(id);
        String sql = "select * from tablero where  idProyecto="+auxId;

        List<TableroVO> listaTableros = new ArrayList<TableroVO>();

        try {
            con = new ConexionDB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                TableroVO c = new TableroVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5));
                listaTableros.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en readAll SQLException: " + e.getCause().toString());
        }catch(Exception e){
            throw new Exception("Error en readAll: " + e.getCause().toString());
        }

        return listaTableros;
    }
    
    
}

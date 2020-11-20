/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProyectoVO;
import Modelo.Proyecto_DAO_Imp;
import Modelo.TableroVO;
import Modelo.Tablero_DAO_Imp;
import Modelo.UsuarioVO;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cesar
 */
public class FXMLCrearTableroController implements Initializable {
    private UsuarioVO usuario_Principal;
    private ProyectoVO proyecto_Principal;
    private TableroVO tablero;
    private ProyectoVO proyecto;
    private Proyecto_DAO_Imp proyecto_imple;
    private Tablero_DAO_Imp tablero_imple;
    void setUsuarioPrincipal(UsuarioVO usuario_principal,ProyectoVO proyecto_Principal){
        this.usuario_Principal=usuario_principal;
        this.proyecto_Principal=proyecto_Principal;
    }
    //////////////////////////////7
    private Stage stagePrincipal;
    private Stage stageVentana;
    
    public void setStageVentana(Stage stageVentana){
        this.stageVentana =stageVentana;
    }
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
    ////////////////////////////////////
    @FXML
    private Button btnCrear;

    @FXML
    private TextField txtNombre;

    @FXML
    void CrearProyecto(ActionEvent event) throws Exception {
        datosTablero();
    }
    void datosTablero() throws Exception{
        //System.out.println(this.usuario_Principal.toString());
        this.tablero.setNombre(txtNombre.getText());
        this.tablero.setCreador(this.usuario_Principal.getCorreo());
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha: "+dateFormat.format(date));
        this.tablero.setFecha(dateFormat.format(date));
        this.tablero.setIdProyecto(this.proyecto_Principal.getId());
        System.out.println(this.tablero.toString());//
        this.tablero_imple.create(tablero);
        //this.proyecto_imple.create(proyecto);
        System.out.println(this.tablero.toString());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tablero=new TableroVO();
        this.tablero_imple= new Tablero_DAO_Imp();
    }  
    
    
}

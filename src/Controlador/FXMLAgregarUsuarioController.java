/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProyectoVO;
import Modelo.Proyecto_DAO_Imp;
import Modelo.SincronizacionVO;
import Modelo.Sincronizacion_DAO_Imp;
import Modelo.UsuarioVO;
import Modelo.Usuario_DAO_Imp;
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
public class FXMLAgregarUsuarioController implements Initializable {
    /////////////////////////////////7
    private Stage stagePrincipal;
    private Stage stageVentana;
    
    public void setStageVentana(Stage stageVentana){
        this.stageVentana =stageVentana;
    }
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
     ///////////////////////
    private UsuarioVO usuario_Principal;
    private ProyectoVO proyecto_Principal;
    private Usuario_DAO_Imp usuario_Impl;
    private ProyectoVO proyecto;
    private Proyecto_DAO_Imp proyecto_imple;
    private SincronizacionVO sincr;
    private Sincronizacion_DAO_Imp sincr_imple;
    
    ////////////////////////
     @FXML
    private TextField txtCorreo;

    @FXML
    private Button btnagregar;

    @FXML
    void agregarUsuarioProy(ActionEvent event) throws Exception {
        datosUsuario();
    }
    void setUsuarioPrincipal(UsuarioVO usuario_principal,ProyectoVO proyecto_Principal){
        this.usuario_Principal=usuario_principal;
        this.proyecto_Principal=proyecto_Principal;
    }
    void datosUsuario() throws Exception{
        System.out.println(this.usuario_Principal.toString());
        boolean band=this.proyecto_imple.validar(txtCorreo.getText(), "");
        if (band){
            this.sincr.setCorreo(txtCorreo.getText());
            this.sincr.setId(this.proyecto_Principal.getId());
            this.sincr_imple.create(sincr);
            
        }else{
            System.out.println("Error ..........");
        }
        
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.proyecto=new ProyectoVO();
        this.proyecto_imple= new Proyecto_DAO_Imp();
        this.sincr=new SincronizacionVO();
        this.sincr_imple=new Sincronizacion_DAO_Imp();
        this.usuario_Impl=new Usuario_DAO_Imp();
    }    
    
}

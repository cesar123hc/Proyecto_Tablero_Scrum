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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FXML Controller class
 *
 * @author cesar
 */
public class FXMLCrearProyectoController implements Initializable {
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
     @FXML
    private TextField txtNombre;

    @FXML
    private Button btnCrear;
    private UsuarioVO usuario_Principal;
    private ProyectoVO proyecto;
    private Proyecto_DAO_Imp proyecto_imple;
    private SincronizacionVO sincr;
    private Sincronizacion_DAO_Imp sincr_imple;
    
    

    @FXML
    void CrearProyecto(ActionEvent event) throws Exception {
        datosProyecto();
    }
    void datosProyecto() throws Exception{
        System.out.println(this.usuario_Principal.toString());
        this.proyecto.setNombre(txtNombre.getText());
        this.proyecto.setCreador(this.usuario_Principal.getCorreo());
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha: "+dateFormat.format(date));
        this.proyecto.setFecha(dateFormat.format(date));
        this.proyecto_imple.create(proyecto);
        System.out.println();
        System.out.println();
        
        int auxId=this.proyecto_imple.sicronizar();
        System.out.println(auxId);
        System.out.println(auxId);
        System.out.println(auxId);
        this.sincr.setCorreo(this.usuario_Principal.getCorreo());
        this.sincr.setId(auxId);
        this.sincr_imple.create(sincr);
        
    }
    void setUsuarioPrincipal(UsuarioVO usuario_principal){
        this.usuario_Principal=usuario_principal;
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.proyecto=new ProyectoVO();
        this.proyecto_imple= new Proyecto_DAO_Imp();
        this.sincr=new SincronizacionVO();
        this.sincr_imple=new Sincronizacion_DAO_Imp();
    }    
    
}

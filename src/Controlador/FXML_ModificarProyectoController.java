/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProyectoVO;
import Modelo.Proyecto_DAO_Imp;
import java.net.URL;
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
 * @author agust
 */
public class FXML_ModificarProyectoController implements Initializable {
    
    private Stage stagePrincipal;    
    private Stage stageVentana;
    
    public void setStageVentana(Stage stageVentana){
        this.stageVentana =stageVentana;
    }
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
    
    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnGuardar;
    
    private ProyectoVO proyecto;
    private Proyecto_DAO_Imp proyecto_imple;
    private boolean esEdicion;
    
    public void setProyecto(ProyectoVO proyecto){
        this.proyecto=proyecto;
        this.txtNombre.setText(this.proyecto.getNombre());
    }
    public boolean getEsEdicion(){
        return esEdicion;
    }

    @FXML
    void GuardarProyecto(ActionEvent event) throws Exception {
        proyecto.setNombre(txtNombre.getText());
        this.proyecto_imple.update(proyecto);
        this.stageVentana.close();
        this.stagePrincipal.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.proyecto=new ProyectoVO();
        this.proyecto_imple= new Proyecto_DAO_Imp();
    }    
    
}

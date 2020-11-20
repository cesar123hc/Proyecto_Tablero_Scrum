/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioVO;
import Modelo.Usuario_DAO_Imp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cesar
 */
public class FXMLRegistroUsuarioController implements Initializable {
    
    @FXML
    private TextField nombre;

    @FXML
    private TextField correo;

    @FXML
    private TextField nacimiento;

    @FXML
    private TextField apellido;

    @FXML
    private TextField pregunta;

    @FXML
    private PasswordField contra;

    @FXML
    private Button botonRegistrar;

    @FXML
    private Button botonDialogoCarcelar;
    private UsuarioVO usuario;
    private Usuario_DAO_Imp imple;

    @FXML
    void agregarUsuario(ActionEvent event) throws Exception {
        mandarDatos();
    }

    @FXML
    void cancelarEdicion(ActionEvent event) {

    }
    ///////////////////////7
    private Stage stagePrincipal;
    
    
    private Stage stageVentana;
    
   public void setStageVentana(Stage stageVentana){
        this.stageVentana =stageVentana;
    }
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
    //////////////////////
    /**
     * Initializes the controller class.
     */
    public void mandarDatos() throws Exception{
        this.usuario.setCorreo(correo.getText());
        this.usuario.setNombre(nombre.getText());
        this.usuario.setContras(contra.getText());
        this.usuario.setApellido(apellido.getText());
        this.usuario.setFechaNac(nacimiento.getText());
        this.usuario.setPregunta(pregunta.getText());
        this.imple=new Usuario_DAO_Imp();
        this.imple.create(usuario);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.usuario=new UsuarioVO();
        
                
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioVO;
import Modelo.Usuario_DAO_Imp;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author petra
 */
public class FXML_InicioSesionController implements Initializable {
     @FXML
    private Button btnRegistrarse;

    @FXML
    private Button recuperarContra;

    
    @FXML
    private Button Ingresar;

    @FXML
    private TextField campoCorreo;

    private UsuarioVO usuario;
    @FXML
    private PasswordField campoContrasena;
    @FXML
    void RecuperarContrase(ActionEvent event) {
        this.mostrarRecuperarContra();
    }
    private FXML_Recuperar_ContraController controlador_REC;
    private FXMLRegistroUsuarioController controlador_REG;
    private FXML_MenuPrincipalController controlador_Men;

    @FXML
    void registrarUsuario(ActionEvent event) {
        this.mostrarRegistroUsu();
    }
    
    private Stage stagePrincipal;
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
    
    private String correo="";
    private String contra="";
    private Usuario_DAO_Imp controlValidar;
    private boolean correcto=false;
    @FXML
    void validar(ActionEvent event){
        this.correo=this.campoCorreo.getText();
        this.contra=this.campoContrasena.getText();
        
        try{
            this.usuario=controlValidar.read(correo);
            correcto=controlValidar.validar(correo,contra);
            if(correcto){
                
                Node source= (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                // do what you have to do
                stage.close();
                this.mostrarMenu();
            }else{
                JOptionPane.showMessageDialog(null,"Datos incorrectos");
                this.campoCorreo.setText("");
                this.campoContrasena.setText("");
            }
        }catch(SQLException e){
            System.out.println("error al verificar usuario");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("error al verificar usuario");
            e.printStackTrace();
        }
        
    }
    public void mostrarRecuperarContra(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXML_Recuperar_Contra.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Recuperar Contraseña");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXML_Recuperar_ContraController controlador = loader.getController();
            controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            
            dialogoStage.showAndWait();
           
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    public void mostrarRegistroUsu(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXMLRegistroUsuario.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Registro Usuario");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXMLRegistroUsuarioController controlador = loader.getController();
            controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            
            dialogoStage.showAndWait();
           
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    public void mostrarMenu(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXML_MenuPrincipal.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Registro Usuario");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXML_MenuPrincipalController controlador = loader.getController();
            controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            controlador.setUsuarioPrincipal(this.usuario);
            dialogoStage.showAndWait();
           
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controlValidar=new Usuario_DAO_Imp();
        this.usuario=new UsuarioVO();
    }    
    
}
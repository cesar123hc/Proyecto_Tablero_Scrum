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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cesar
 */
public class FXML_Recuperar_ContraController implements Initializable {
    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtPregunta;

    @FXML
    private TextField txtContrase;

    @FXML
    private Button verificar;
     @FXML
    private Label MensajeContra;
     @FXML
    private Label Mensaje;
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
    private Button btnActualizarContr;
    private UsuarioVO usuario;
    private Usuario_DAO_Imp usu_Impl;

    @FXML
    void cambiarContra(ActionEvent event) throws Exception {
        actualizarContrasenia();
    }

    @FXML
    void verificarContra(ActionEvent event) throws Exception {
        this.Mensaje.setVisible(false);
        mandarDatos();
        
        
    }
    public void actualizarContrasenia() throws Exception{
        this.usuario.setContras(txtContrase.getText());
        boolean ban =this.usu_Impl.update(usuario);
        try{
           if(ban){
            System.out.println("Datos actualizados ");
            }
            else{
                 System.out.println("Datos no  actualizados ");
            } 
        }catch(Exception e){
            System.out.println("Datos no  actualizados ERROR");
        }
        
    }
     public void mandarDatos() throws Exception{
         
         
         this.usuario=this.usu_Impl.read(txtCorreo.getText());
         System.out.println(txtCorreo.getText());
         System.out.println(usuario.getPregunta());
         try{
             if(usuario.getPregunta().equals(txtPregunta.getText())){
                 usuario.setPregunta(txtPregunta.getText());
                 //boolean ban =this.usu_Impl.update(usuario);
                
               
                //this.Mensaje.setVisible(true);
                this.txtContrase.setVisible(true);
                this.btnActualizarContr.setVisible(true);
                this.MensajeContra.setVisible(true);
                System.out.println("Datos correctos");
             }else{
                 System.out.println("Datos no correctos");
                 this.Mensaje.setVisible(true);
             }
         }catch(Exception e){
             
         }
         
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.usuario=new UsuarioVO();
        this.usu_Impl=new Usuario_DAO_Imp();
        this.Mensaje.setVisible(false);
        this.txtContrase.setVisible(false);
        this.btnActualizarContr.setVisible(false);
        this.MensajeContra.setVisible(false);
    }    
    
}

package Controlador;

import Modelo.UsuarioVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author petra
 */
public class FXML_InfoPersonalController implements Initializable {
    
    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblApellidos;

    @FXML
    private Button editarInformacion;

    @FXML
    private Label lblFechaNacimiento;

    @FXML
    private Label lblContrasena;

    @FXML
    private Label lblRespRecuperacion;
    
    private Stage stagePrincipal;
    private Stage stageVentana;
    private UsuarioVO usuario_principal;
    private FXML_ModificarUsuarioController controladorModificar;
    private UsuarioVO usuario_Principal;
    
    public void setStageVentana(Stage stageVentana){
        this.stageVentana =stageVentana;
    }
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
    
    public void setControlador(FXML_ModificarUsuarioController controlador){
        this.controladorModificar=controlador;
    }
    
    void setUsuarioPrincipal(UsuarioVO usuario_principal){
        this.usuario_principal=usuario_principal;
        this.lblCorreo.setText(this.usuario_principal.getCorreo());
        this.lblNombre.setText(this.usuario_principal.getNombre());
        this.lblApellidos.setText(this.usuario_principal.getApellido());
        this.lblFechaNacimiento.setText(this.usuario_principal.getFechaNac());
        this.lblContrasena.setText(this.usuario_principal.getContras());
        this.lblRespRecuperacion.setText(this.usuario_principal.getPregunta());
    }
    
    public boolean modificarUsuario(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXML_ModificarUsuario.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Modificación del usuario");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXML_ModificarUsuarioController controladorMod = loader.getController();
            controladorMod.setStageVentana(dialogoStage);
            //this.setControlador(controladorMod);
            controladorMod.setUsuarioPrincipal(this.usuario_principal);
            dialogoStage.showAndWait();
            //dialogoStage.show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @FXML
    void modificarInformacion(ActionEvent event) {
        if(this.modificarUsuario()){
            System.out.println("Hecho en la modificación");
        }else{
            System.out.println("No hecho en la modificación");
        }
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controladorModificar=new FXML_ModificarUsuarioController();
    }    

    

   
    
}

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
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author petra
 */
public class FXML_ModificarUsuarioController implements Initializable {

    @FXML
    private Label lblCorreo;

    @FXML
    private TextField lblNombre;

    @FXML
    private TextField lblApellidos;

    @FXML
    private TextField lblFechaNacimiento;

    @FXML
    private TextField lblRespuesta;

    @FXML
    private TextField lblContrasena;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;

    @FXML
    private PasswordField lblConfirmacionContrasena;
    
    private Stage stagePrincipal;
    private Stage stageVentana;
    private UsuarioVO usuario_principal;
    private Usuario_DAO_Imp usuarioImplementacion;
    
    public void setStageVentana(Stage stageVentana){
        this.stageVentana =stageVentana;
    }
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
    void setUsuarioPrincipal(UsuarioVO usuario){
        if(usuario!=null){
            this.usuario_principal=usuario;
            this.lblCorreo.setText(this.usuario_principal.getCorreo());
            this.lblNombre.setText(this.usuario_principal.getNombre());
            this.lblApellidos.setText(this.usuario_principal.getApellido());
            this.lblFechaNacimiento.setText(this.usuario_principal.getFechaNac());
            this.lblRespuesta.setText(this.usuario_principal.getPregunta());
            this.lblContrasena.setText(this.usuario_principal.getContras());
        }else{
            System.out.println("********************************usuario vacio****************");
        }
    }

    @FXML
    void accionCancelar(ActionEvent event) {
        Node source= (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void accionGuardar(ActionEvent event) {
        String contra1=this.lblContrasena.getText();
        String contra2=this.lblConfirmacionContrasena.getText();
        
        if(contra1.equals(contra2)){
                this.usuario_principal.setCorreo(this.lblCorreo.getText());
                this.usuario_principal.setNombre(this.lblNombre.getText());
                this.usuario_principal.setApellido(this.lblApellidos.getText());
                this.usuario_principal.setFechaNac(this.lblFechaNacimiento.getText());
                this.usuario_principal.setPregunta(this.lblRespuesta.getText());
                this.usuario_principal.setContras(contra1);
                try{
                    this.usuarioImplementacion.update(usuario_principal);
                        JOptionPane.showMessageDialog(null,"Se guardó correctamente su información");
                        stageVentana.close();
                    
                }catch(Exception e){
                    System.out.println("Hubo un error al actualizar la información del usuario "+e);
                    e.printStackTrace();    
                }
            
        }else{
            if(contra2.equals("")){
                if(contra1.equals(this.usuario_principal.getContras())){
                    this.usuario_principal.setCorreo(this.lblCorreo.getText());
                    this.usuario_principal.setNombre(this.lblNombre.getText());
                    this.usuario_principal.setApellido(this.lblApellidos.getText());
                    this.usuario_principal.setFechaNac(this.lblFechaNacimiento.getText());
                    this.usuario_principal.setPregunta(this.lblRespuesta.getText());
                    this.usuario_principal.setContras(contra1);
                    try{
                        this.usuarioImplementacion.update(usuario_principal);
                            JOptionPane.showMessageDialog(null,"Se guardó correctamente su información");
                            stageVentana.close();
                        
                    }catch(Exception e){
                        System.out.println("Hubo un error al actualizar la información del usuario "+e);
                        e.printStackTrace();    
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"haz modificado la contraseña, recuerda confirmarla");
                    stageVentana.close();
                }
            }else{
                JOptionPane.showMessageDialog(null,"las contraseñas no coinciden");
                stageVentana.close();
            }//stagePrincipal.close();
        }

    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       usuarioImplementacion=new Usuario_DAO_Imp();
    }    
    
}

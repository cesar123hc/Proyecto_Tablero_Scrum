/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TableroVO;
import Modelo.UsuarioVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cesar
 */
public class FXML_VentanaTableroController implements Initializable {
    private TableroVO tablero_principal;
    /**
     * Initializes the controller class.
     */
    ////////////////////////////////////////////////////
    private Stage stagePrincipal;
    private Stage stageVentana;
    
    public void setStageVentana(Stage stageVentana){
        this.stageVentana =stageVentana;
    }
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
    
    ///////////////////////////////////////////////////
    void setUsuarioPrincipal(TableroVO tablero_principal){
        this.tablero_principal=tablero_principal;
        
    }
    /////////77///////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

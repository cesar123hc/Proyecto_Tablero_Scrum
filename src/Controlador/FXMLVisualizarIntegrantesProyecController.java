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
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cesar
 */
public class FXMLVisualizarIntegrantesProyecController implements Initializable {
    @FXML
    private TableView<SincronizacionVO> Usuarios;

    @FXML
    private TableColumn<SincronizacionVO, String> correo;

    @FXML
    private TableColumn<SincronizacionVO, Integer> Id;
    private ObservableList<SincronizacionVO> listaDeUsuarios;
    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnVisualizar;

    @FXML
    void visualizarIntegrantes(ActionEvent event) {
        llenadoTabla();
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
    private UsuarioVO usuario_Principal;
    private ProyectoVO proyecto_Principal;
    private Sincronizacion_DAO_Imp implementacionDAO;
    void setUsuarioPrincipal(ProyectoVO proyecto_Principal){
        this.proyecto_Principal=proyecto_Principal;
    }
    public void obtenerProyectos(){
        System.out.println(this.proyecto_Principal.getId());
        List listaConsulta=null;
        
        try {
            System.out.println(this.proyecto_Principal.getId());
            listaConsulta=implementacionDAO.readAllIntegrantes(this.proyecto_Principal.getId());
        } catch (Exception e) {
            System.out.println("Error al leer la consulta");
        }
        Iterator it=listaConsulta.iterator();
        listaDeUsuarios.clear();
        while(it.hasNext()){
            listaDeUsuarios.add((SincronizacionVO)it.next());
        }
    }
    void llenadoTabla(){
        this.listaDeUsuarios= FXCollections.observableArrayList();
        this.colocarProyectosTabla();
        
    }
    
    public void colocarProyectosTabla(){
        this.obtenerProyectos();
        this.correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        this.Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.Usuarios.setItems(listaDeUsuarios);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.implementacionDAO=new Sincronizacion_DAO_Imp();
        
    }    
    
}

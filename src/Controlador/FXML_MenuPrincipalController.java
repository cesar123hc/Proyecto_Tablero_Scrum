  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProyectoVO;
import Modelo.Proyecto_DAO_Imp;
import Modelo.UsuarioVO;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cesar
 */
public class FXML_MenuPrincipalController implements Initializable {
    @FXML
    private Button agregarIntegrante;
    @FXML
    private Button btnCrearTablero;
    @FXML
    private MenuItem btnmostrarInfo;

    @FXML
    private MenuItem btnCerrarSesion;
    
    @FXML
    private TableView<ProyectoVO> Tabla_Proyectos;

    @FXML
    private TableColumn<ProyectoVO, String> columnaProyectos;
    @FXML
    private Label lblSaludo;
    
    private FXMLCrearProyectoController controlador_CrearProy;
    private FXMLCrearTableroController controlador_CrearTablero;
    private FXML_InfoPersonalController controlador_infoUsuario;
    private FXMLAgregarUsuarioController controlador_AgregarUsuario;
    
    private Stage stagePrincipal;
    private Stage stageVentana;
    
    public void setStageVentana(Stage stageVentana){
        this.stageVentana =stageVentana;
    }
    public void setStagePrincipal(Stage stagePrincipal){
        this.stagePrincipal=stagePrincipal;
    }
    @FXML
    private AnchorPane panel_P;

    @FXML
    private Pane Titulo;
    private UsuarioVO usuario_Principal;
    
    @FXML
    private ImageView Imagen_Perfil;

    @FXML
    private MenuButton MenuPerfil;
    private ObservableList<ProyectoVO> listaDeProyectos;
     private Proyecto_DAO_Imp implementacionDAO;
   
    @FXML
    private Button btnProyecto;
    @FXML
    void crearProyecto(ActionEvent event) {
        this.usuario_Principal.toString();
        System.out.println("toString");
        System.out.println(this.usuario_Principal.toString());
        
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha: "+dateFormat.format(date));
        mostrarCrearProy();
    }

    @FXML
    void ElegirOpcionPerfil(ActionEvent event) {
       
    }
    @FXML
    void agregarIntegranteProyecto(ActionEvent event) {
        ProyectoVO proyectoSeleccionado = this.Tabla_Proyectos.getSelectionModel().getSelectedItem();
        if(proyectoSeleccionado!=null){
            agregarUsuario(proyectoSeleccionado);
        }else{
            System.out.println("Error al crear tablero");
        }
    }
    @FXML
    void crearTablero(ActionEvent event) {
        ProyectoVO proyectoSeleccionado = this.Tabla_Proyectos.getSelectionModel().getSelectedItem();
        if(proyectoSeleccionado!=null){
            mostrarCrearTablero(proyectoSeleccionado);
        }else{
            System.out.println("Error al crear tablero");
        }
    }
    void setUsuarioPrincipal(UsuarioVO usuario_principal){
        this.usuario_Principal=usuario_principal;
        this.lblSaludo.setText("Hola "+this.usuario_Principal.getNombre());
    }
    public void mostrarCrearProy(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXMLCrearProyecto.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Registro Usuario");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXMLCrearProyectoController controlador = loader.getController();
            controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            controlador.setUsuarioPrincipal(this.usuario_Principal);
            dialogoStage.showAndWait();   
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    public void mostrarCrearTablero(ProyectoVO proyectoSeleccionado){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXMLCrearTablero.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Crear Tablero");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXMLCrearTableroController controlador = loader.getController();
            controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            System.out.println(proyectoSeleccionado.toString());
            controlador.setUsuarioPrincipal(this.usuario_Principal,proyectoSeleccionado);
            
            dialogoStage.showAndWait();   
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    public void agregarUsuario(ProyectoVO proyectoSeleccionado){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXMLAgregarUsuario.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Crear Tablero");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXMLAgregarUsuarioController controlador = loader.getController();
            controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            System.out.println(proyectoSeleccionado.toString());
            controlador.setUsuarioPrincipal(this.usuario_Principal,proyectoSeleccionado);
            
            dialogoStage.showAndWait();   
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    public void obtenerProyectos(){
        List listaConsulta=null;
        try {
            listaConsulta=implementacionDAO.readAll();
        } catch (Exception e) {
            System.out.println("Error al leer la consulta");
        }
        Iterator it=listaConsulta.iterator();
        listaDeProyectos.clear();
        while(it.hasNext()){
            listaDeProyectos.add((ProyectoVO)it.next());
        }
    }
    
    public void colocarProyectosTabla(){
        this.obtenerProyectos();
        this.columnaProyectos.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.Tabla_Proyectos.setItems(listaDeProyectos);
        
    }
    
    @FXML
    void cerrarSesion(ActionEvent event) {

    }
    
    
    public boolean mostrarInformacionUsuario(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXML_InfoPersonal.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Información del usuario");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXML_InfoPersonalController controladorInfo = loader.getController();
            controladorInfo.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            controladorInfo.setUsuarioPrincipal(this.usuario_Principal);
            dialogoStage.showAndWait();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @FXML
    void mostrarInfo(ActionEvent event) {
        if(this.mostrarInformacionUsuario()){
            System.out.println("Hecho la información");
        }else{
            System.out.println("No hecho la información");
        }
    }

    
    /**
     * Initializes
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // Image image = new Image("file:" + "C:\Users\cesar\Desktop\Metodologias de desarrollo\Nueva Carpeta\Proyecto_Final\Imagenes\Perfil.png");
         //   this.imagenCuadro.setImage(image);
        this.implementacionDAO=new Proyecto_DAO_Imp();
        this.listaDeProyectos= FXCollections.observableArrayList();
        this.colocarProyectosTabla();
        this.controlador_infoUsuario= new FXML_InfoPersonalController();
        
         
    }    
    
}

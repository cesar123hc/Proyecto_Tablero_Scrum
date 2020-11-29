  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProyectoVO;
import Modelo.Proyecto_DAO_Imp;
import Modelo.TableroVO;
import Modelo.Tablero_DAO_Imp;
import Modelo.UsuarioVO;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private Button btn2;

    @FXML
    private Button btn1;
    @FXML
    private Button btn3;

    @FXML
    private Button btn7;

    @FXML
    private Button btn6;

    @FXML
    private Button btn5;

    @FXML
    private Button btn4;

    @FXML
    private Button btn9;

    @FXML
    private Button btn8;
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
    private FXMLVisualizarIntegrantesProyecController controlador_visualizarIntegrantes;
    
    private ProyectoVO proyecto;
    
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
    private Tablero_DAO_Imp implementacionTablero;
    
    @FXML
    private ImageView Imagen_Perfil;

    @FXML
    private MenuButton MenuPerfil;
    private ObservableList<ProyectoVO> listaDeProyectos;
     private ObservableList<TableroVO> listaDeTableros;
     private Proyecto_DAO_Imp implementacionDAO;
   
    @FXML
    private Button btnProyecto;
    
    @FXML
    private Button botonEliminarP;

    @FXML
    private Button botonModificarP;
    @FXML
    private Button btnVerIntegrantes;
    
    @FXML
    void ModificarProyecto(ActionEvent event) {
        int seleccionado = this.Tabla_Proyectos.getSelectionModel().getSelectedIndex();
        if(seleccionado>=0){
            this.proyecto=this.Tabla_Proyectos.getSelectionModel().getSelectedItem();
            System.out.println("1"+proyecto.getNombre());
            boolean esEdicion = this.mostrarModificarProy();
            if(esEdicion){
                this.colocarProyectosTabla();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.NONE,"Selecciona el proyecto a modificar");
            alert.show();
        }
    }
    @FXML
    void verIntegrantesProyecto(ActionEvent event) {
        ProyectoVO proyectoSeleccionado = this.Tabla_Proyectos.getSelectionModel().getSelectedItem();
        if(proyectoSeleccionado!=null){
            System.out.println(proyectoSeleccionado.toString());
            mostrarIntegrantesProyecto(proyectoSeleccionado);
        }else{
            System.out.println("Error al visualizar integrantes");
        }
    }
    
    public boolean mostrarModificarProy(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXML_ModificarProyecto.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Editar Usuario");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXML_ModificarProyectoController controlador = loader.getController();
            controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            controlador.setProyecto(this.proyecto);
            dialogoStage.showAndWait();
            return controlador.getEsEdicion();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @FXML
    void eliminarProyecto(ActionEvent event) {
        int seleccionado = this.Tabla_Proyectos.getSelectionModel().getSelectedIndex();
        if(seleccionado>=0){
            ProyectoVO proyecto=this.Tabla_Proyectos.getSelectionModel().getSelectedItem();
            this.Tabla_Proyectos.getSelectionModel().selectLast();
            try {
                this.implementacionDAO.delete(proyecto);
            } catch (Exception e) {
                System.out.println("Error al eliminar Usuario");
            }
            if(seleccionado!=0){
                seleccionado--;
                this.Tabla_Proyectos.getSelectionModel().select(seleccionado);
            }
        }
    }
    
    @FXML
    void crearProyecto(ActionEvent event) {
        this.usuario_Principal.toString();
        System.out.println("toString");
        System.out.println(this.usuario_Principal.toString());
        
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha: "+dateFormat.format(date));
        mostrarCrearProy();
        this.colocarProyectosTabla();
        this.Tabla_Proyectos.getSelectionModel().selectLast();
        
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
    public void mostrarIntegrantesProyecto(ProyectoVO proyectoSeleccionado){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXMLVisualizarIntegrantesProyec.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Visualizar Integrante");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXMLVisualizarIntegrantesProyecController controlador = loader.getController();
            controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            System.out.println(proyectoSeleccionado.toString());
            controlador.setUsuarioPrincipal(proyectoSeleccionado);
            
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
        obtenerProyectos();
        this.columnaProyectos.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.Tabla_Proyectos.setItems(listaDeProyectos);
        
    }
    
    @FXML
    void cerrarSesion(ActionEvent event) {
        Stage stage = (Stage) this.MenuPerfil.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Vista/FXML_Iniciar_Sesion.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Iniciar sesion");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stagePrincipal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXML_InicioSesionController controlador = loader.getController();
            //controlador.setStageVentana(dialogoStage);
            //this.setControlador(controlador);
            
            dialogoStage.showAndWait();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    void actulizarGridPanel(ProyectoVO proyectoSeleccionado) {
        System.out.println("Mensaje importante"+ proyectoSeleccionado.toString());
        
        restaurarTblero();
        obtenerTableros(proyectoSeleccionado.getId());
        AgregarTableros();
    }
    void obtenerTableros(int id) {
        
          List listaConsulta=null;
        try {
            listaConsulta=this.implementacionTablero.readAllProyecto(id);
        } catch (Exception e) {
            System.out.println("Error al leer la consulta");
        }
         System.out.println(listaConsulta);
         System.out.println("Mensaje ");
        Iterator it=listaConsulta.iterator();
        this.listaDeTableros.clear();
        while(it.hasNext()){
            this.listaDeTableros.add((TableroVO)it.next());
             
            ;
        }
         
    }
    void AgregarTableros() {
        System.out.println("Mensaje ");
       //System.out.println(this.listaDeTableros.toString());
        System.out.println( this.listaDeTableros.isEmpty());
        System.out.println(this.listaDeTableros.size());
        int i=0;
        
        if(!this.listaDeTableros.isEmpty()){
            
            System.out.println("Mensaje dentro");
            if(i<this.listaDeTableros.size()){
                this.btn1.setText(this.listaDeTableros.get(0).getNombre());
                this.btn1.setVisible(true);
                
            }
            i++;
            if(i<this.listaDeTableros.size()){
                this.btn2.setText(this.listaDeTableros.get(1).getNombre());
                this.btn2.setVisible(true);
            }
            i++;
            if( i < this.listaDeTableros.size()){
                this.btn3.setText(this.listaDeTableros.get(2).getNombre());
                this.btn3.setVisible(true);
            }
            i++;
            if(i<this.listaDeTableros.size()){
                this.btn4.setText(this.listaDeTableros.get(3).getNombre());
                this.btn4.setVisible(true);
            }
            i++;
            if( i<this.listaDeTableros.size()){
                this.btn5.setText(this.listaDeTableros.get(4).getNombre());
                this.btn5.setVisible(true);
            }
            i++;
            if(i<this.listaDeTableros.size()){
                this.btn6.setText(this.listaDeTableros.get(5).getNombre());
                this.btn6.setVisible(true);
            }
            i++;
            if( i<this.listaDeTableros.size()){
                this.btn7.setText(this.listaDeTableros.get(6).getNombre());
                this.btn7.setVisible(true);
            }
            i++;
            if(i<this.listaDeTableros.size()){
                this.btn8.setText(this.listaDeTableros.get(7).getNombre());
                this.btn8.setVisible(true);
            }
            i++;
            if(i<this.listaDeTableros.size()){
                this.btn9.setText(this.listaDeTableros.get(8).getNombre());
                this.btn9.setVisible(true);
            }
        }
    }
    void restaurarTblero(){
         
        this.btn1.setVisible(false);
        this.btn2.setVisible(false);
         this.btn3.setVisible(false);
         this.btn4.setVisible(false);
         this.btn5.setVisible(false);
         this.btn6.setVisible(false);
          this.btn7.setVisible(false);
          this.btn8.setVisible(false);
         
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
    @FXML
    void tablero1(ActionEvent event) {

    }

    @FXML
    void tablero2(ActionEvent event) {

    }
     @FXML
    void tablero3(ActionEvent event) {

    }

    @FXML
    void tablero4(ActionEvent event) {

    }

    @FXML
    void tablero5(ActionEvent event) {

    }

    @FXML
    void tablero6(ActionEvent event) {

    }

    @FXML
    void tablero7(ActionEvent event) {

    }

    @FXML
    void tablero8(ActionEvent event) {

    }

    @FXML
    void tablero9(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.listaDeTableros= FXCollections.observableArrayList();
        // TODO
        // Image image = new Image("file:" + "C:\Users\cesar\Desktop\Metodologias de desarrollo\Nueva Carpeta\Proyecto_Final\Imagenes\Perfil.png");
         //   this.imagenCuadro.setImage(image);
        this.implementacionDAO=new Proyecto_DAO_Imp();
        implementacionTablero=new Tablero_DAO_Imp();
        this.listaDeProyectos= FXCollections.observableArrayList();
        this.colocarProyectosTabla();
        this.controlador_infoUsuario= new FXML_InfoPersonalController();
        this.btn1.setVisible(false);
        this.btn2.setVisible(false);
         this.btn3.setVisible(false);
         this.btn4.setVisible(false);
         this.btn5.setVisible(false);
         this.btn6.setVisible(false);
          this.btn7.setVisible(false);
          this.btn8.setVisible(false);
         
          this.btn9.setVisible(false);
        this.Tabla_Proyectos.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue,newValue) ->this.actulizarGridPanel(newValue));
         
    }    
    
}

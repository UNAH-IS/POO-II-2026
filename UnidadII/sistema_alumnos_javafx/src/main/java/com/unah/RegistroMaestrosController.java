package com.unah;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.unah.clases.Alumno;
import com.unah.clases.Carrera;
import com.unah.clases.Maestro;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegistroMaestrosController implements Initializable {
    @FXML private TextField txtSueldo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtEdad;
    @FXML private TextField txtIdentidad;
    @FXML private TextField txtHorasTrabajadas;
    @FXML private Spinner<Integer> spnClasesImpartidas;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML RadioButton rbMasculino;
    @FXML RadioButton rbFemenino;

    @FXML private ComboBox<String> cboCategoriasDocentes;
    @FXML private ComboBox<Carrera> cboCarreras;
    @FXML private TableView<Maestro> tblMaestros;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;


    public RegistroMaestrosController() {
        //No se puede acceder a los elementos de la UI en el constructor, ya que estos no han sido inicializados
        // cboCarreras.setItems(App.carreras);
    }

    @FXML
    public void guardarMaestro() {
        
        Maestro maestro = new Maestro(
            txtNombre.getText(),
            txtApellido.getText(),
            txtEdad.getText().isEmpty() ? 0 : Integer.parseInt(txtEdad.getText()),
            cboCarreras.getSelectionModel().getSelectedItem(),
            txtIdentidad.getText(),
            rbMasculino.isSelected() ? "Masculino" : "Femenino",
            txtSueldo.getText().isEmpty() ? 0 : Double.parseDouble(txtSueldo.getText()),
            spnClasesImpartidas.getValue(),
            txtHorasTrabajadas.getText().isEmpty() ? 0 : Integer.parseInt(txtHorasTrabajadas.getText()),
            cboCategoriasDocentes.getSelectionModel().getSelectedItem(),
            dpFechaNacimiento.getValue()
        );

        ArrayList<String> errores = maestro.validarCampos();
        
        //Mostrar los errores en un Alert si hay alguno
        if (!errores.isEmpty()) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Errores de Validación");
            mensaje.setHeaderText("Se encontraron errores en los campos ingresados:");
            mensaje.setContentText(String.join("\n", errores));
            mensaje.showAndWait();
            return;
        }

        App.maestros.add(maestro);
        limpiarCampos();

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Guardado");
        mensaje.setHeaderText(null);
        mensaje.setContentText("Maestro guardado correctamente");
        mensaje.showAndWait();
    }

    @FXML
    public void actualizarMaestro() {
        Maestro maestroSeleccionado = tblMaestros.getSelectionModel().getSelectedItem();

        if (maestroSeleccionado != null) {
            maestroSeleccionado.setNombre(txtNombre.getText());
            maestroSeleccionado.setApellido(txtApellido.getText());
            maestroSeleccionado.setEdad(Integer.parseInt(txtEdad.getText()));
            maestroSeleccionado.setCarrera(cboCarreras.getSelectionModel().getSelectedItem());
            maestroSeleccionado.setIdentidad(txtIdentidad.getText());
            maestroSeleccionado.setGenero(rbMasculino.isSelected() ? "Masculino" : "Femenino");
            maestroSeleccionado.setSueldo(txtSueldo.getText().isBlank() ? 0 : Double.parseDouble(txtSueldo.getText()));
            maestroSeleccionado.setHorasTrabajadas(txtHorasTrabajadas.getText().isEmpty() ? 0 : Integer.parseInt(txtHorasTrabajadas.getText()));
            maestroSeleccionado.setClasesImpartidas(spnClasesImpartidas.getValue());
            maestroSeleccionado.setCategoriaDocente(cboCategoriasDocentes.getSelectionModel().getSelectedItem());
            maestroSeleccionado.setFechaNacimiento(dpFechaNacimiento.getValue());

            limpiarCampos();
            // Refrescar la lista para que se actualice la vista
            tblMaestros.refresh();
            
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Actualización");
            mensaje.setHeaderText(null);
            mensaje.setContentText("Maestro actualizado correctamente");
            mensaje.showAndWait();
        }
    }

    @FXML
    public void limpiarCampos(){
        txtSueldo.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
        txtIdentidad.clear();
        txtHorasTrabajadas.clear();
        spnClasesImpartidas.getValueFactory().setValue(0);
        dpFechaNacimiento.setValue(null);
        rbMasculino.setSelected(false);
        rbFemenino.setSelected(false);
        cboCarreras.getSelectionModel().clearSelection();
        tblMaestros.getSelectionModel().clearSelection();
        cboCategoriasDocentes.getSelectionModel().clearSelection();

        btnGuardar.setDisable(false);
        btnActualizar.setDisable(true);
        btnEliminar.setDisable(true);
    }

    @FXML
    public void eliminarMaestro() {
        Maestro maestroSeleccionado = tblMaestros.getSelectionModel().getSelectedItem();
        if (maestroSeleccionado != null) {
            Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
            mensaje.setTitle("Confirmación");
            mensaje.setHeaderText(null);
            mensaje.setContentText("¿Está seguro de que desea eliminar al maestro seleccionado?");
           
           
            mensaje.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    App.maestros.remove(maestroSeleccionado);
                    limpiarCampos();
                }
            });
        }
    }

    public void construirTablaMaestros() {
        TableColumn<Maestro, String> colSueldo = new TableColumn<Maestro, String>("Sueldo");
        TableColumn<Maestro, String> colNombre = new TableColumn<Maestro, String>("Nombre");
        TableColumn<Maestro, String> colApellido = new TableColumn<Maestro, String>("Apellido");
        TableColumn<Maestro, String> colIdentidad = new TableColumn<Maestro, String>("Identidad");
        TableColumn<Maestro, String> colCarrera = new TableColumn<Maestro, String>("Carrera");
        TableColumn<Maestro, String> colEdad = new TableColumn<Maestro, String>("Edad");
        TableColumn<Maestro, String> colPromedio = new TableColumn<Maestro, String>("Promedio");
        TableColumn<Maestro, String> colClasesImpartidas = new TableColumn<Maestro, String>("Clases Impartidas");
        TableColumn<Maestro, String> colFechaNacimiento = new TableColumn<Maestro, String>("Fecha de Nacimiento");
        TableColumn<Maestro, String> colHorasTrabajadas = new TableColumn<Maestro, String>("Horas Trabajadas");
        TableColumn<Maestro, String> colCategoriaDocente = new TableColumn<Maestro, String>("Categoría Docente");

        colSueldo.setCellValueFactory(new PropertyValueFactory<>("sueldo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colIdentidad.setCellValueFactory(new PropertyValueFactory<>("identidad"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colClasesImpartidas.setCellValueFactory(new PropertyValueFactory<>("clasesImpartidas"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colHorasTrabajadas.setCellValueFactory(new PropertyValueFactory<>("horasTrabajadas"));
        colCategoriaDocente.setCellValueFactory(new PropertyValueFactory<>("categoriaDocente"));

        tblMaestros.getColumns().addAll(colNombre, colApellido, colIdentidad, colCarrera, colEdad,colSueldo, colClasesImpartidas, colFechaNacimiento, colHorasTrabajadas, colCategoriaDocente);
    }

    public void seleccionarMaestro(Maestro nuevoValor, Maestro antiguoValor) {
        // System.out.println("Maestro seleccionado: " + nuevoValor);
        // System.out.println("Maestro anterior: " + antiguoValor);
        if (nuevoValor != null) {
            txtSueldo.setText(String.valueOf(nuevoValor.getSueldo()));
            txtNombre.setText(nuevoValor.getNombre());
            txtApellido.setText(nuevoValor.getApellido());
            txtEdad.setText(String.valueOf(nuevoValor.getEdad()));
            txtIdentidad.setText(nuevoValor.getIdentidad());
            txtHorasTrabajadas.setText(String.valueOf(nuevoValor.getHorasTrabajadas()));
            spnClasesImpartidas.getValueFactory().setValue(nuevoValor.getClasesImpartidas());
            dpFechaNacimiento.setValue(nuevoValor.getFechaNacimiento());
            cboCategoriasDocentes.getSelectionModel().select(nuevoValor.getCategoriaDocente());

            if (nuevoValor.getGenero().equals("Masculino")) {
                rbMasculino.setSelected(true);
                rbFemenino.setSelected(false);
            } else {
                rbMasculino.setSelected(false);
                rbFemenino.setSelected(true);
            }
            cboCarreras.getSelectionModel().select(nuevoValor.getCarrera());

            btnGuardar.setDisable(true);
            btnActualizar.setDisable(false);
            btnEliminar.setDisable(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ///Este metodo se ejecuta cuando la UI se ha cargado completamente
        this.cboCarreras.setItems(App.carreras);
        this.tblMaestros.setItems(App.maestros);
        this.cboCategoriasDocentes.setItems(App.categoriasDocentes);
        construirTablaMaestros();

        this.spnClasesImpartidas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
        this.tblMaestros.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Maestro>() {
            @Override
            public void changed(ObservableValue<? extends Maestro> observable, Maestro oldValue, Maestro newValue) {
                seleccionarMaestro(newValue, oldValue);
            }
            
        });
    }    
}

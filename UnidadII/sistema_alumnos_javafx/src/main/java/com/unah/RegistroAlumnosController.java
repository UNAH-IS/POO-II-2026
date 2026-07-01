package com.unah;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.unah.clases.Alumno;
import com.unah.clases.Carrera;

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

public class RegistroAlumnosController implements Initializable {
    @FXML private TextField txtCuenta;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtEdad;
    @FXML private TextField txtIdentidad;
    @FXML private TextField txtPromedio;
    @FXML private Spinner<Integer> spnClasesAprobadas;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML RadioButton rbMasculino;
    @FXML RadioButton rbFemenino;

    @FXML private ComboBox<Carrera> cboCarreras;
    @FXML private ListView<Alumno> lstAlumnos;
    @FXML private TableView<Alumno> tblAlumnos;

    @FXML private Button btnGuardar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;


    public RegistroAlumnosController() {
        //No se puede acceder a los elementos de la UI en el constructor, ya que estos no han sido inicializados
        // cboCarreras.setItems(App.carreras);
    }

    @FXML
    public void guardarAlumno() {
        
        Alumno alumno = new Alumno(
            txtNombre.getText(),
            txtApellido.getText(),
            txtEdad.getText().isEmpty() ? 0 : Integer.parseInt(txtEdad.getText()),
            cboCarreras.getSelectionModel().getSelectedItem(),
            txtIdentidad.getText(),
            rbMasculino.isSelected() ? "Masculino" : "Femenino",
            txtCuenta.getText(),
            txtPromedio.getText().isEmpty() ? 0 : Float.parseFloat(txtPromedio.getText()),
            spnClasesAprobadas.getValue(),
            dpFechaNacimiento.getValue()
        );

        ArrayList<String> errores = alumno.validarCampos();
        
        //Mostrar los errores en un Alert si hay alguno
        if (!errores.isEmpty()) {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Errores de Validación");
            mensaje.setHeaderText("Se encontraron errores en los campos ingresados:");
            mensaje.setContentText(String.join("\n", errores));
            mensaje.showAndWait();
            return;
        }

        App.alumnos.add(alumno);
        limpiarCampos();

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Guardado");
        mensaje.setHeaderText(null);
        mensaje.setContentText("Alumno guardado correctamente");
        mensaje.showAndWait();
    }

    @FXML
    public void actualizarAlumno() {
        Alumno alumnoSeleccionado = lstAlumnos.getSelectionModel().getSelectedItem();

        if (alumnoSeleccionado != null) {
            alumnoSeleccionado.setNombre(txtNombre.getText());
            alumnoSeleccionado.setApellido(txtApellido.getText());
            alumnoSeleccionado.setEdad(Integer.parseInt(txtEdad.getText()));
            alumnoSeleccionado.setCarrera(cboCarreras.getSelectionModel().getSelectedItem());
            alumnoSeleccionado.setIdentidad(txtIdentidad.getText());
            alumnoSeleccionado.setGenero(rbMasculino.isSelected() ? "Masculino" : "Femenino");
            alumnoSeleccionado.setCuenta(txtCuenta.getText());
            alumnoSeleccionado.setPromedio(Float.parseFloat(txtPromedio.getText()));
            alumnoSeleccionado.setClasesAprobadas(spnClasesAprobadas.getValue());
            alumnoSeleccionado.setFechaNacimiento(dpFechaNacimiento.getValue());

            limpiarCampos();
            // Refrescar la lista para que se actualice la vista
            lstAlumnos.refresh();
            
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Actualización");
            mensaje.setHeaderText(null);
            mensaje.setContentText("Alumno actualizado correctamente");
            mensaje.showAndWait();
        }
    }

    @FXML
    public void limpiarCampos(){
        txtCuenta.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
        txtIdentidad.clear();
        txtPromedio.clear();
        spnClasesAprobadas.getValueFactory().setValue(0);
        dpFechaNacimiento.setValue(null);
        rbMasculino.setSelected(false);
        rbFemenino.setSelected(false);
        cboCarreras.getSelectionModel().clearSelection();
        lstAlumnos.getSelectionModel().clearSelection();

        btnGuardar.setDisable(false);
        btnActualizar.setDisable(true);
        btnEliminar.setDisable(true);
    }

    @FXML
    public void eliminarAlumno() {
        Alumno alumnoSeleccionado = lstAlumnos.getSelectionModel().getSelectedItem();
        if (alumnoSeleccionado != null) {
            Alert mensaje = new Alert(Alert.AlertType.CONFIRMATION);
            mensaje.setTitle("Confirmación");
            mensaje.setHeaderText(null);
            mensaje.setContentText("¿Está seguro de que desea eliminar al alumno seleccionado?");
           
           
            mensaje.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    App.alumnos.remove(alumnoSeleccionado);
                    limpiarCampos();
                }
            });
        }
    }

    public void construirTablaAlumnos() {
        TableColumn<Alumno, String> colCuenta = new TableColumn<Alumno, String>("Cuenta");
        TableColumn<Alumno, String> colNombre = new TableColumn<Alumno, String>("Nombre");
        TableColumn<Alumno, String> colApellido = new TableColumn<Alumno, String>("Apellido");
        TableColumn<Alumno, String> colIdentidad = new TableColumn<Alumno, String>("Identidad");
        TableColumn<Alumno, String> colCarrera = new TableColumn<Alumno, String>("Carrera");
        TableColumn<Alumno, String> colEdad = new TableColumn<Alumno, String>("Edad");
        TableColumn<Alumno, String> colPromedio = new TableColumn<Alumno, String>("Promedio");
        TableColumn<Alumno, String> colClasesAprobadas = new TableColumn<Alumno, String>("Clases Aprobadas");
        TableColumn<Alumno, String> colFechaNacimiento = new TableColumn<Alumno, String>("Fecha de Nacimiento");

        colCuenta.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colIdentidad.setCellValueFactory(new PropertyValueFactory<>("identidad"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colPromedio.setCellValueFactory(new PropertyValueFactory<>("promedio"));
        colClasesAprobadas.setCellValueFactory(new PropertyValueFactory<>("clasesAprobadas"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));

        tblAlumnos.getColumns().addAll(colCuenta, colNombre, colApellido, colIdentidad, colCarrera, colEdad, colPromedio, colClasesAprobadas, colFechaNacimiento);
    }

    public void seleccionarAlumno(Alumno nuevoValor, Alumno antiguoValor) {
        // System.out.println("Alumno seleccionado: " + nuevoValor);
        // System.out.println("Alumno anterior: " + antiguoValor);
        if (nuevoValor != null) {
            txtCuenta.setText(nuevoValor.getCuenta());
            txtNombre.setText(nuevoValor.getNombre());
            txtApellido.setText(nuevoValor.getApellido());
            txtEdad.setText(String.valueOf(nuevoValor.getEdad()));
            txtIdentidad.setText(nuevoValor.getIdentidad());
            txtPromedio.setText(String.valueOf(nuevoValor.getPromedio()));
            spnClasesAprobadas.getValueFactory().setValue(nuevoValor.getClasesAprobadas());
            dpFechaNacimiento.setValue(nuevoValor.getFechaNacimiento());
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
        this.lstAlumnos.setItems(App.alumnos);
        this.tblAlumnos.setItems(App.alumnos);
        construirTablaAlumnos();

        this.spnClasesAprobadas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 70, 0));
        this.lstAlumnos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Alumno>() {
            @Override
            public void changed(ObservableValue<? extends Alumno> observable, Alumno oldValue, Alumno newValue) {
                seleccionarAlumno(newValue, oldValue);
            }
            
        });
    
        this.tblAlumnos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Alumno>() { 
            @Override
            public void changed(ObservableValue<? extends Alumno> observable, Alumno oldValue, Alumno newValue) {
                seleccionarAlumno(newValue, oldValue);
            }
        });
    }    
}

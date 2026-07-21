module com.unah {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens com.unah to javafx.fxml;
    opens com.unah.clases to javafx.base; //Esta linea es necesaria para que la clase Alumno pueda ser utilizada en la tabla, ya que la tabla utiliza reflection para acceder a los atributos de la clase Alumno, y si no se abre el paquete com.unah.clases, la tabla no podrá acceder a los atributos de la clase Alumno y no podrá mostrar los datos en la tabla.
    exports com.unah;
}

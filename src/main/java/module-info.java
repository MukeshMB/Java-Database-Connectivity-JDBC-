module com.example.mydbfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.mydbfx to javafx.fxml;
    exports com.example.mydbfx;
    exports com.example.mydbfx.Controllers;
    opens com.example.mydbfx.Controllers to javafx.fxml;
}
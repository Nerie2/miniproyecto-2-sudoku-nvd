module com.example.miniproyecto2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.miniproyecto2 to javafx.fxml;
    exports com.example.miniproyecto2;
    exports com.example.miniproyecto2.controller;
    opens com.example.miniproyecto2.controller to javafx.fxml;
}
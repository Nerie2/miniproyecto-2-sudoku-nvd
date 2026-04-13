package com.example.miniproyecto2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {

    @FXML
    private Button miBoton;

    @FXML
    private void onBotonClick() {
        System.out.println("¡El juego ha comenzado!");
        // Aquí puedes iniciar la lógica del juego
    }

}

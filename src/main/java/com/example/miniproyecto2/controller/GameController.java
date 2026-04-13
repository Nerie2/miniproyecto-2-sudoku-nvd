package com.example.miniproyecto2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;


public class GameController {

    int[] position = new int[2];
    @FXML
    private AnchorPane rootPane;
    @FXML
    int[] getButtonData(javafx.scene.control.Button button){
        try {
            String data = button.getUserData().toString();
            String[] parts = data.split(",");

            return new int[]{
                    Integer.parseInt(parts[0].trim()),
                    Integer.parseInt(parts[1].trim())
            };

        } catch (Exception e) {
            return new int[]{0, 0};
        }
    }

    Boolean checkInput(char letter){
        char[] numbers = {'1', '2', '3', '4', '5', '6'};
        for (char number : numbers) {
            if (number == letter) {
                return true;
            }
        }
        return false;

    }
    void sendUserInput(char letter){
        if(checkInput(letter)){
            //Aqui se debe de enviar la letra al modelo
        }


    }
    @FXML
    private void handleKeyPressed(KeyEvent event) {
        String input = event.getText();
        try  {
           sendUserInput(input.charAt(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    void hint(){

    }

    @FXML
    private Button miBoton;

    @FXML
    private void onBotonClick() {

        System.out.println("¡El juego ha comenzado!");
        // Aquí puedes iniciar la lógica del juego
        rootPane.requestFocus();
    }


}

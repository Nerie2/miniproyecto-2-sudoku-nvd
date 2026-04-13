package com.example.miniproyecto2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javax.swing.*;


public class GameController {

    public GridPane gridPanel;
    int[] position = new int[2];
    @FXML
    private AnchorPane rootPane;
    public Button getButtonAt(int col, int row) {

        for (Node node : gridPanel.getChildren()) {

            Integer c = GridPane.getColumnIndex(node);
            Integer r = GridPane.getRowIndex(node);


            int colIndex;

            if (c == null) {
                colIndex = 0;
            } else {
                colIndex = c;
            }

            int rowIndex;
            if (r == null) {
                rowIndex = 0;
            } else {
                rowIndex = r;
            }

            if (colIndex == col && rowIndex == row) {
                return (Button) node;
            }
        }

        return null;
    }
    public void buttonAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        position = getButtonData(button);

    }
    public int[] getButtonData(javafx.scene.control.Button button){
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

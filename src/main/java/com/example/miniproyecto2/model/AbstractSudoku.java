package com.example.miniproyecto2.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractSudoku implements ISudoku{

    int[][] tablero = new int[6][6];
    public AbstractSudoku(){
        fillSudoku();
    }
    @Override
    public boolean checkInput(int x, int y,int number) {
        if (number<1 || number>6){
            return false;
        }
        int starRow = (x/2)*2;
        int starCol= (y/3)*3;

        for (int i =0; i <2; i++){
            for (int j=0; j<3; j++){
                if (tablero [starRow+i][starCol+j]==number){
                    return false;
                }
            }
            System.out.println("verificando");
        }

        for (int col=0; col<6; col++){
            if (tablero[x][col]==number){
                return false;
            }
            System.out.println("verificando");
        }

        for (int row=0; row<6; row++){
            if (tablero[row][y]==number){
                return false;
            }
            System.out.println("verificando");
        }

        return true;

    }

    @Override
    public Boolean sendInput(int x, int y, int number) {
        if (checkInput(x,y,number)){
            tablero [x][y]=number;
            return true;
        }
        return false;
    }

    @Override
    public int[] searchInput() {
        for (int i=0; i <6; i++){
            for(int j=0; j<6; j++){
                if (tablero[i][j]==0) {
                    for (int num=1; num<=6; num++){
                        if (checkInput(i,j,num)){
                            return new int[]{i,j,num};
                        }
                    }
                }
            }
        }
        return null;
    }
    @Override
    public int infoGrid(int x , int y){
        return tablero[x][y];

    }
    @Override
    public void fillSudoku() {


        fillRecursive(0, 0);
        int kill =0;
        do {
            kill = (int)(Math.random() * 30);
        }while (kill<20);

        int killed= 0;
        while (killed < kill) {
            // Generamos coordenadas del 0 al 5
            int x = (int)(Math.random() * 6);
            int y = (int)(Math.random() * 6);

            // Si la casilla tiene un número, la ponemos a 0
            if (tablero[x][y] != 0) {
                tablero[x][y] = 0;
                killed++;
            }
        }

    }

    private boolean fillRecursive(int fila, int col) {

        if (col == 6) {
            col = 0;
            fila++;
        }
        if (fila == 6) return true;


        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        List<Integer> listaNums = Arrays.asList(numbers);
        Collections.shuffle(listaNums); //random

        for (int num : listaNums) {

            if (sendInput(fila, col, num)) {

                // Si sendInput fue true, intentamos llenar la siguiente casilla
                if (fillRecursive(fila, col + 1)) {
                    return true;
                }

                //recursivamente se llama
                tablero[fila][col] = 0;
            }
        }

        return false;
    }

}
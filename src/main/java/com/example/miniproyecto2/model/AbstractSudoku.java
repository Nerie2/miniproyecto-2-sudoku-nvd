package com.example.miniproyecto2.model;

import java.util.Collection;
import java.util.Collections;

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
        }

        for (int col=0; col<6; col++){
            if (tablero[x][col]==number){
                return false;
            }
        }

        for (int row=0; row<6; row++){
            if (tablero[row][y]==number){
                return false;
            }
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
    public void fillSudoku(){
        int[] numbers =new int[] {1, 2, 3, 4, 5, 6};

        for (int i = 1; i < 7; ++i) {

            //num
            int num = (int)(Math.random() * 5) ;

            for (int j = 0; j < i; j++) {
                //cords
                int x = (int)(Math.random() * 5);
                int y = (int)(Math.random() * 5);
                if(tablero[x][y]==0 ){
                    for (int k = 0; k < 5; k++) {
                        if (num==6){num=5;}
                        if(numbers[num]==0){
                            if(num==5){
                                num= 0;
                            }
                            else{
                                ++num;
                            }
                        }
                        else{
                            break;
                        }

                    }//Encuentra un numero sin usar

                    sendInput(x, y , numbers[num]);




                }
            }
            numbers[num]=0;
        }




    }
    //COMENTARIO PARA BORRAR AL DOCUMENTAR: la funcion elije un orden aleatorio de numeros para rellenar, donde el primero recibe 5 numeros el siguiente 4 y asi hasta llegar a 0

}

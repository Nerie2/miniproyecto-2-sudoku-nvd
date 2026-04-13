package com.example.miniproyecto2.model;

public abstract class AbstractSudoku implements ISudoku{

    int[][] tablero = new int[6][6];

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
    public String searchInput() {
        for (int i=0; i <6; i++){
            for(int j=0; j<6; j++){
                if (tablero[i][j]==0) {
                    for (int num=1; num<=6; num++){
                        if (checkInput(i,j,num)){
                            return "Pista: en la celda (" + i + "," + j + ") puedes poner el número " + num;
                        }
                    }
                }
            }
        }
        return "No hay pistas disponibles";
    }
    @Override
    public int infoGrid(int x , int y){
        return tablero[x][y];

    }

}

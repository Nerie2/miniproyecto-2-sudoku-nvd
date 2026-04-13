package com.example.miniproyecto2.model;

public abstract class AbstractSudoku implements ISudoku{
    int[][] tablero = new int[6][6];
    
    @Override
    public boolean checkInput() {
        return false;
    }

    @Override
    public String sendInput() {
        return "";
    }

    @Override
    public String searchInput() {
        return "";
    }

}

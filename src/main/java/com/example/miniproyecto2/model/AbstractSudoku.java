package com.example.miniproyecto2.model;

public class AbstractSudoku implements ISudoku{

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

package com.example.miniproyecto2.model;

public interface ISudoku {
    boolean checkInput(int x, int y, int number);

    void sendInput(int x, int y, int number);
    String searchInput();
}

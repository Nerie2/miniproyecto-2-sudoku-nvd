package com.example.miniproyecto2.model;

/**
 * Singleton class that manages the game and extends AbstractGame.
 * It is the main model of the whole project. It inherits the constructor
 * from the abstract class and contains the Singleton logic.
 */
public class Sudoku extends AbstractSudoku {


    private static final Sudoku INSTANCE = new Sudoku();


    private Sudoku() {}

    /**
     * This function helps to obtain the correct instance (the only instance).
     * @return the single instance
     */
    public static Sudoku getInstance() {
        return INSTANCE;
    } //singleton


    public static void init() {
        Sudoku game = getInstance();

    }



}
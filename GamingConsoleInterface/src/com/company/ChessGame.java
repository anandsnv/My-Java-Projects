package com.company;

public class ChessGame implements GamingConsole{


    @Override
    public void up() {
        System.out.println("Forward");
    }

    @Override
    public void down() {
        System.out.println("backward");

    }

    @Override
    public void right() {
        System.out.println("Goes right");

    }

    @Override
    public void left() {
        System.out.println("left");

    }
}

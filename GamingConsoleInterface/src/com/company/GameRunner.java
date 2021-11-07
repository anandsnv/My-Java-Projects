package com.company;

public class GameRunner {

    public static void main(String[] args) {
    MarioGame game=new MarioGame();
    game.up();
    game.down();
    game.right();
    game.left();

    ChessGame game1=new ChessGame();
        game1.up();
        game1.down();
        game1.right();
        game1.left();

    }
}

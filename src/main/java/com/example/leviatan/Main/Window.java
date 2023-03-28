package com.example.leviatan.Main;

import com.example.leviatan.States.Game;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Window {
    private Game game = new Game();
    private String gameStatus = "MENU";
    private boolean ATACK = false;
    public Window(Stage stage){
        Pane root = new Pane();
        switch (gameStatus){

        }
        Scene scene = game.GameScene(root);
        stage.show();
        stage.setScene(scene);

    }

}

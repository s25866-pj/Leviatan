package com.example.leviatan.Main;

import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.States.Game;

import com.example.leviatan.States.Menu;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Window {
    private Game game = new Game();
    private Menu menu= new Menu();
    private WindowConf.GAME_CONF.WINDOW_STATUS gameStatus = WindowConf.GAME_CONF.gameStatus;
    private boolean ATACK = false;

    public Window(Stage stage){
        Pane gameRoot = new Pane();
        Pane menuRoot = new Pane();
        Scene menuScene = menu.MenuScene(menuRoot);
        Scene gameScene = game.GameScene(gameRoot);
        switch (gameStatus){
            case GAME :
                stage.setScene(gameScene);
                break;
            case MENU:
                stage.setScene(menuScene);
                break;
        }
        stage.show();

    }

}

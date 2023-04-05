package com.example.leviatan.Main;

import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.States.Game;

import com.example.leviatan.States.Menu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Window {
    private Game game = new Game();
    private Menu menu= new Menu();
    public WindowConf.GAME_CONF.WINDOW_STATUS gameStatus = WindowConf.GAME_CONF.gameStatus;
    private boolean ATACK = false;

    public Window(Stage stage){
        Pane gameRoot = new Pane();
        Pane menuRoot = new Pane();
        Scene menuScene = menu.MenuScene(menuRoot);
        Scene gameScene = game.GameScene(gameRoot);

        gameScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                setStatus(WindowConf.GAME_CONF.WINDOW_STATUS.MENU);
                stage.setScene(menuScene);
            }
        });
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),event->{
//            System.out.println("Refresh");
            switch (gameStatus){
                case GAME :
                    stage.setScene(gameScene);
                    break;
                case MENU:
                    stage.setScene(menuScene);
                    break;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        stage.show();
    }

    public void setStatus(WindowConf.GAME_CONF.WINDOW_STATUS newStatus) {
        gameStatus = newStatus;
    }


    public void startGame() {
        System.out.println("Start new game");
    }
}

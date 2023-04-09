package com.example.leviatan.Main;

import com.example.leviatan.States.Game;

import com.example.leviatan.States.Menu;
import com.example.leviatan.Utilz.WindowStates;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.leviatan.Utilz.WindowStates.*;

public class Window {
    private Game game = new Game();
    private Menu menu= new Menu();
    private boolean ATACK = false;

    public Window(Stage stage){
        Pane gameRoot = new Pane();
        Pane menuRoot = new Pane();
        Scene menuScene = menu.MenuScene(menuRoot);
        Scene gameScene = game.GameScene(gameRoot);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),event->{
            switch (status){
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
}

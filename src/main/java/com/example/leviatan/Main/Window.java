package com.example.leviatan.Main;

import com.example.leviatan.States.Game;

import com.example.leviatan.States.GameStates.Ship;
import com.example.leviatan.States.Menu;
import com.example.leviatan.Utilz.WindowStates;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.leviatan.Utilz.GameStates.gameStates;
import static com.example.leviatan.Utilz.WindowStates.*;

public class Window {
    private Game game = new Game();
    private Menu menu= new Menu();
    private Ship ship= new Ship();
    private boolean ATACK = false;

    public Window(Stage stage){

        Pane gameRoot = new Pane();
        Pane menuRoot = new Pane();
        Pane editShipRoot = new Pane();
        Scene menuScene = menu.MenuScene(menuRoot);
        Scene gameScene = game.GameScene(gameRoot);
        Scene editShip = ship.ShipScene(editShipRoot);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),event->{
            switch (status){
                case GAME :
                    switch(gameStates){
                        case PLAY_GAME:
                            stage.setScene(gameScene);
                            break;
                        case DOCK:
                            stage.setScene(editShip);
                            break;
                        case SHIP:
                            break;
                    }
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

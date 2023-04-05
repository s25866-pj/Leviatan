package com.example.leviatan.States;

import com.example.leviatan.GameConf.WindowConf;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Menu {
    public Scene MenuScene(Pane root) {
        Scene menu = new Scene(root, WindowConf.WINDOW_BASIC_WIDTH,WindowConf.WINDOW_BASIC_HEIGHT);
//        Rectangle newGameButton = new Rectangle(200,200,50,50);
        Button newGameButton = new Button("Nowa Gra");
        newGameButton.setMaxHeight(50);
        newGameButton.setMaxWidth(150);
        newGameButton.setLayoutX(200);
        newGameButton.setLayoutY(200);

      newGameButton.setOnAction(actionEvent -> {
          WindowConf.GAME_CONF.gameStatus = WindowConf.GAME_CONF.WINDOW_STATUS.GAME;
      });
        menu.setFill(Color.GREEN);


        root.getChildren().add(newGameButton);
        return menu;
    }
}

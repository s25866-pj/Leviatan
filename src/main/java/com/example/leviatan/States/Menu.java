package com.example.leviatan.States;

import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.Main.Window;
import com.example.leviatan.Utilz.WindowStates;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Menu {
    private Window window;
    public Scene MenuScene(Pane root) {
        Scene menu = new Scene(root, WindowConf.WINDOW_BASIC_WIDTH,WindowConf.WINDOW_BASIC_HEIGHT);
        Button newGameButton = new Button("Nowa Gra");
        newGameButton.setMaxHeight(50);
        newGameButton.setMaxWidth(150);
        newGameButton.setLayoutX(200);
        newGameButton.setLayoutY(200);

      newGameButton.setOnAction(actionEvent -> {
          System.out.println("start new game");
          WindowStates.status = WindowStates.GAME;

      });
        menu.setFill(Color.GREEN);
        root.getChildren().add(newGameButton);
        return menu;
    }
}

package com.example.leviatan.States;

import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.Main.Window;
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
//        Rectangle newGameButton = new Rectangle(200,200,50,50);
        Button newGameButton = new Button("Nowa Gra");
        newGameButton.setMaxHeight(50);
        newGameButton.setMaxWidth(150);
        newGameButton.setLayoutX(200);
        newGameButton.setLayoutY(200);

      newGameButton.setOnAction(actionEvent -> {
          window.startGame();
          System.out.println("start new game");
      });
        menu.setFill(Color.GREEN);
        root.getChildren().add(newGameButton);
        return menu;
    }
}

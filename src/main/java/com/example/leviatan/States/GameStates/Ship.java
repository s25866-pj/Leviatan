package com.example.leviatan.States.GameStates;

import com.example.leviatan.GameConf.WindowConf;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class Ship {
    public Scene ShipScene(Pane gameRoot) {
        Scene editShip = new Scene(gameRoot, WindowConf.WINDOW_BASIC_WIDTH,WindowConf.WINDOW_BASIC_HEIGHT);
        Rectangle EQ = new Rectangle();
        EQ.setX(500);
        EQ.setY(0);
        EQ.setWidth(WindowConf.WINDOW_BASIC_WIDTH-EQ.getX());
        EQ.setHeight(WindowConf.WINDOW_BASIC_HEIGHT);
        EQ.setFill(Color.YELLOW);
        File shipbasic = new File("");
                //kokpit, reaktor, napęd, magazyn, broń, rośliny,
        editShip.setOnMouseMoved(mouseEvent -> {
            if(mouseEvent.getX()>=EQ.getX()){
                System.out.println("EQ");
            }
            else {
                int x= 10*((int) mouseEvent.getX()/10);
                int y= 10*((int) mouseEvent.getY()/10);
                System.out.println("X : "+x+" | Y :"+y);
            }

        });


        gameRoot.getChildren().add(EQ);

        return editShip;
    }
}

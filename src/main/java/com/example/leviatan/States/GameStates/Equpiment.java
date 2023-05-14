package com.example.leviatan.States.GameStates;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;

public class Equpiment {


    public Rectangle createEquiment() {
        Rectangle EQ = new Rectangle();
        EQ.setVisible(true);
        EQ.prefHeight(100);
        EQ.prefWidth(100);
        EQ.setFill(Color.GREEN);
        return EQ;
    }
}

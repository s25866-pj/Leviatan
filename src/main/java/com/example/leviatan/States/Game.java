package com.example.leviatan.States;

import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.Mobs.KeyboardHelper;
import com.example.leviatan.Mobs.MouseHelper;
import com.example.leviatan.Mobs.Player;
import com.example.leviatan.Utilz.PlayerUtilz;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Game {
    private KeyboardHelper movingClass = new KeyboardHelper();
    private MouseHelper mouseHelper = new MouseHelper();
    private Player player;
    public NewGame newGame = new NewGame();
    private PlayerUtilz playerUtilz;
    private Text text= new Text(WindowConf.GUI.HP_WIDTH,WindowConf.GUI.HP_HEIGHT,"");;

    private String HP_Gui;

    public Scene GameScene(Pane root){
        Scene game=new Scene(root, WindowConf.WINDOW_WIDTH,WindowConf.WINDOW_HEIGHT);
        PlayerUtilz playerUtilz = new PlayerUtilz();
        player = newGame.createNewPlayer();
        updateHP_Gui();


        game.setOnKeyPressed(keyEvent -> {
            movingClass.movingPressed(keyEvent,player,playerUtilz);
        });
        game.setOnKeyReleased(keyEvent -> {
            movingClass.movingReleased(keyEvent,player);
        });
        game.setOnMousePressed(mouseEvent -> {
            mouseHelper.mouseButtonPress(mouseEvent,player,root);
        });
        game.setOnMouseReleased(mouseEvent -> {
            mouseHelper.mouseButtonRelease(mouseEvent,root);
        });
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), event->{
            updateHP_Gui();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        root.getChildren().add(player.getPlayerRect());
        root.getChildren().add(text);
        return game;
    }
    private void updateHP_Gui() {
        HP_Gui= player.getHp()+"|"+player.getHpMax();
        text.setText(HP_Gui);
    }
}

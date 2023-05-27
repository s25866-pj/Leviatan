package com.example.leviatan.States;

import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.Mobs.Enemy;
import com.example.leviatan.Mobs.KeyboardHelper;
import com.example.leviatan.Mobs.MouseHelper;
import com.example.leviatan.Mobs.Player;
import com.example.leviatan.States.GameStates.Equpiment;
import com.example.leviatan.Utilz.PlayerUtilz;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Game {
    private KeyboardHelper movingClass = new KeyboardHelper();
    private MouseHelper mouseHelper = new MouseHelper();
    private Player player;
    private Enemy enemy;
    private Equpiment equpiment;
    public NewGame newGame = new NewGame();
    private PlayerUtilz playerUtilz;
    private Text textHP = new Text(WindowConf.GUI.HP_WIDTH,WindowConf.GUI.HP_HEIGHT,"");;
    private Text chosenWeapon = new Text(10,20,"");
    private boolean showEquipment=false;
    private String HP_Gui;

    public Scene GameScene(Pane root){
        Scene game=new Scene(root, WindowConf.WINDOW_BASIC_WIDTH,WindowConf.WINDOW_BASIC_HEIGHT);
        PlayerUtilz playerUtilz = new PlayerUtilz();
        player = newGame.createNewPlayer();
        createEnemy(root);
        updateHP_Gui();

        game.setOnKeyPressed(keyEvent -> {
            movingClass.movingPressed(keyEvent,player,playerUtilz);
        });
        game.setOnKeyReleased(keyEvent -> {
            movingClass.movingReleased(keyEvent,player);
        });
        game.setOnMousePressed(mouseEvent -> {
            mouseHelper.mouseButtonPress(mouseEvent,player,root,enemy);
        });
        game.setOnMouseReleased(mouseEvent -> {
            mouseHelper.mouseButtonRelease(mouseEvent,root);
        });
        game.setOnScroll(scrollEvent -> {
            mouseHelper.onWheelRoll(scrollEvent,player);
        });

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), event->{
            updateHP_Gui();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        addToRoot(root,player.getPlayerRect());
        addToRoot(root,textHP);
        addToRoot(root,chosenWeapon);

        return game;
    }

    private void addToRoot(Pane root,Node node) {
        root.getChildren().add(node);

    }

    private void createEnemy(Pane root) {
        enemy= newGame.createNewEnemy();
        root.getChildren().add(enemy.getPlayerRect());
    }

    private void updateHP_Gui() {
        HP_Gui= player.getHp()+"|"+player.getHpMax();
        chosenWeapon.setText((player.getChosenWeapon()+1)+" : "+player.getEquipment().get(player.getChosenWeapon()).getName());
        textHP.setText(HP_Gui);
    }
}

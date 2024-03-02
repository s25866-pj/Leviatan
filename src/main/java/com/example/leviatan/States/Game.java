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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Game {
    private KeyboardHelper movingClass = new KeyboardHelper(this);
    private MouseHelper mouseHelper = new MouseHelper();
    private Player player;
    private Enemy enemy;
    private ArrayList<Enemy> enemyList=new ArrayList<>();
    private Equpiment equpiment;
    public NewGame newGame = new NewGame();
    private PlayerUtilz playerUtilz;
//    private Text textHP = new Text(WindowConf.GUI.HP_WIDTH,WindowConf.GUI.HP_HEIGHT,"");;
    private Text chosenWeapon = new Text(10,20,"");
    private boolean showEquipment=false;
    private HBox HP_Gui=new HBox();
    private StackPane hpBar =new StackPane();
//    WindowConf.GUI.HP_WIDTH,WindowConf.GUI.HP_HEIGHT,""

    public Scene GameScene(Pane root){
        Scene game=new Scene(root, WindowConf.WINDOW_BASIC_WIDTH,WindowConf.WINDOW_BASIC_HEIGHT);
        PlayerUtilz playerUtilz = new PlayerUtilz();
        player = newGame.createNewPlayer();
        createEnemy(root);
        hpBar.getChildren().add(HP_Gui);
        updateHP_Gui();
        Text tip = new Text(10,50,"x-add xp\ni-show player stat\nh-heal\ng-dmg\nv-add Shield");
        game.setOnKeyPressed(keyEvent -> {
            movingClass.movingPressed(keyEvent,player,playerUtilz,root);
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
        addToRoot(root,HP_Gui);
        addToRoot(root,chosenWeapon);
        addToRoot(root,tip);
        return game;
    }

    private void addToRoot(Pane root,Node node) {
        root.getChildren().add(node);
    }

    public void createEnemy(Pane root) {
        enemy= newGame.createNewEnemy(enemyList);
        if(enemy!=null){
            enemyList.add(enemy);
        }
        for(Enemy e : enemyList){
            root.getChildren().add(e.getPlayerRect());
        }

    }

    private void updateHP_Gui() {
        HP_Gui.getChildren().clear();
        Text shield = new Text();
        if(player.getShield()>0){
            shield.setText(player.getShield()+"|");
            shield.setFill(Color.BLUE);
        }
        Text HP = new Text(player.getHp()+"|"+player.getHpMax());
        HP.setFill(Color.RED);
        HP_Gui.getChildren().addAll(shield,HP);
        chosenWeapon.setText((player.getChosenWeapon()+1)+" : "+player.getEquipment().get(player.getChosenWeapon()).getName());
    }
}

package com.example.leviatan.Mobs;
import com.example.leviatan.GameConf.PlayerConf;
import com.example.leviatan.GameConf.WindowConf;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class MouseHelper {
    private Player player;
    Rectangle weapon;
    Rectangle bullet;
    private Enemy enemy;
    private List<Rectangle> bullets = new ArrayList<>();
    private Timeline bulletTimaline;
    public void mouseButtonPress(MouseEvent mouseEvent, Player player, Pane root,Enemy enemy) {
        this.player = player;
        weapon = new Rectangle(this.player.getX()+ PlayerConf.PLAYER_WIDTH,this.player.getY()+20,25,10);

        if(mouseEvent.getButton()== MouseButton.PRIMARY){
            weapon.setX(player.getPlayerRect().getX()+ PlayerConf.PLAYER_WIDTH);
            weapon.setY(player.getPlayerRect().getY()+20);
            enemy.detectHit(root,weapon,enemy,player);
            weapon.setFill(player.getEquipment().get(player.getChosenWeapon()).getColor());
            weapon.setVisible(true);
            if(player.getEquipment().get(player.getChosenWeapon()).getWeapontype() == Items.WeaponType.RANGED){
                System.out.println("pif paf");
                createBullet(weapon,root);
                enemy.detectHit(root, bullets,enemy,player);
            }
            root.getChildren().add(weapon);
        }
    }



    private void createBullet(Rectangle weapon, Pane root) {
        bullet = new Rectangle(weapon.getX(),weapon.getY()+weapon.getWidth(),10,5);
        bullet.setFill(Color.BLACK);
        root.getChildren().add(bullet);
        bullets.add(bullet);
        if(bulletTimaline!=null){
            bulletTimaline.stop();
        }
        bulletTimaline = new Timeline(
                new KeyFrame(Duration.millis(5),e->moveBullet(root))
        );
        bulletTimaline.setCycleCount(Timeline.INDEFINITE);
        bulletTimaline.play();
    }
    void moveBullet(Pane root){
        List<Rectangle> bulletsToRemove = new ArrayList<>();
        for(Rectangle bullet : bullets){

            if(bullet.getX()<WindowConf.WINDOW_BASIC_WIDTH){
                bullet.setX(bullet.getX()+1);
            }else{
                bulletsToRemove.add(bullet);
            }
        }
        bullets.removeAll(bulletsToRemove);
        root.getChildren().removeAll(bulletsToRemove);

    }
    public void mouseButtonRelease(MouseEvent mouseEvent, Pane root) {
        if(mouseEvent.getButton()== MouseButton.PRIMARY){
            weapon.setVisible(false);
            root.getChildren().remove(weapon);
        }
    }
    public void onWheelRoll(ScrollEvent scrollEvent, Player player) {
        if(scrollEvent.getDeltaY()>0){
            if(player.getChosenWeapon()==(player.getEquipment().size()-1)){
                player.setChosenWeapon(0);
            }else{
                player.setChosenWeapon(player.getChosenWeapon()+1);
            }
            System.out.println("up");
        }
        if (scrollEvent.getDeltaY() < 0) {
         if(player.getChosenWeapon()==0){
             player.setChosenWeapon(player.getEquipment().size()-1);
         }
         else{
             player.setChosenWeapon(player.getChosenWeapon()-1);
         }
            System.out.println("down");
        }

    }
}

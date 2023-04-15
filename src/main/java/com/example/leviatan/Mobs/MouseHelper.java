package com.example.leviatan.Mobs;
import com.example.leviatan.GameConf.PlayerConf;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class MouseHelper {
    private Player player;
    Rectangle weapon;
    Rectangle bullet;
    public void mouseButtonPress(MouseEvent mouseEvent, Player player, Pane root) {

        this.player = player;
        weapon = new Rectangle(this.player.getX()+ PlayerConf.PLAYER_WIDTH,this.player.getY()+20,25,10);

        if(mouseEvent.getButton()== MouseButton.PRIMARY){
            System.out.println("atak");
            weapon.setX(player.getPlayerRect().getX()+ PlayerConf.PLAYER_WIDTH);
            weapon.setY(player.getPlayerRect().getY()+20);
            weapon.setFill(player.getEquipment().get(player.getChosenWeapon()).getColor());
            weapon.setVisible(true);
            if(player.getEquipment().get(player.getChosenWeapon()).getWeapontype() == Items.WeaponType.RANGED){
                System.out.println("pif paf");
                createBullet(weapon,root);
            }
            root.getChildren().add(weapon);
        }
    }

    private void createBullet(Rectangle weapon, Pane root) {
        bullet = new Rectangle(weapon.getX(),weapon.getY()+weapon.getWidth(),10,5);
        bullet.setFill(Color.BLACK);
    }


    public void mouseButtonRelease(MouseEvent mouseEvent, Pane root) {
        if(mouseEvent.getButton()== MouseButton.PRIMARY){
            System.out.println("puszczono");
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

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
    Rectangle sword;
    public void mouseButtonPress(MouseEvent mouseEvent, Player player, Pane root) {

        this.player = player;
        sword = new Rectangle(this.player.getX()+ PlayerConf.PLAYER_WIDTH,this.player.getY()+20,25,10);

        if(mouseEvent.getButton()== MouseButton.PRIMARY){
            System.out.println("atak");
            sword.setX(player.getPlayerRect().getX()+ PlayerConf.PLAYER_WIDTH);
            sword.setY(player.getPlayerRect().getY()+20);
            sword.setFill(player.getEquipment().get(player.getChosenWeapon()).getColor());
            sword.setVisible(true);
            //                    System.out.println("X: "+sword.getX()+" | Y: "+sword.getY());
            //                    System.out.println("PX: "+ player.getPlayerRect().getX()+" | PY: "+player.getPlayerRect().getY());
            root.getChildren().add(sword);
        }
    }


    public void mouseButtonRelease(MouseEvent mouseEvent, Pane root) {
        if(mouseEvent.getButton()== MouseButton.PRIMARY){
            System.out.println("puszczono");
            sword.setVisible(false);
            root.getChildren().remove(sword);
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

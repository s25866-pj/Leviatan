package com.example.leviatan.Mobs;
import com.example.leviatan.GameConf.PlayerConf;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
            sword.setFill(Color.GREEN);
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
}

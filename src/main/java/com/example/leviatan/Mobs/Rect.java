package com.example.leviatan.Mobs;

import com.example.leviatan.GameConf.PlayerConf;
import com.example.leviatan.GameConf.WindowConf;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rect {
    private int x;
    private int y;
    private int width;
    private int height;
    private Rectangle playerRect;
    private boolean UP,LEFT,RIGHT,DOWN;

    public Rect(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = (int) (width*WindowConf.GAME_SCALE);
        this.height = (int) (height*WindowConf.GAME_SCALE);
        playerRect = new Rectangle(x,y,width,height);
        playerRect.setFill(Color.RED);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getPlayerRect(){
        return playerRect;
    }
    public void updatePosition(Player player){
        int speed = player.getMoveSpeed();
        if(UP){
            playerRect.setY(playerRect.getY() + (-1 *speed));
            if(playerRect.getY()<0){
                playerRect.setY(0);
            }
        }
        if(DOWN){
            playerRect.setY(playerRect.getY() + speed);
            if(playerRect.getY()>(WindowConf.WINDOW_BASIC_HEIGHT-PlayerConf.PLAYER_HEIGHT)){
                playerRect.setY(WindowConf.WINDOW_BASIC_HEIGHT-PlayerConf.PLAYER_HEIGHT);
            }
        }
        if(LEFT){
            playerRect.setX(playerRect.getX() + (-1 * speed));
            if(playerRect.getX()<0){
                playerRect.setX(0);
            }
        }
        if(RIGHT){
            playerRect.setX(playerRect.getX() + (1 * speed));
            if(playerRect.getX()>(WindowConf.WINDOW_BASIC_WIDTH - PlayerConf.PLAYER_WIDTH)){
                playerRect.setX(WindowConf.WINDOW_BASIC_WIDTH -PlayerConf.PLAYER_WIDTH);
            }
        }
    }
    public void moveUP(boolean b, Player player) {
        UP=b;
        updatePosition(player);
    }

    public void moveDOWN(boolean b, Player player) {
        DOWN = b;
        updatePosition(player);
    }

    public void moveLEFT(boolean b, Player player) {
        LEFT = b;
        updatePosition(player);
    }

    public void moveRIGHT(boolean b, Player player) {
        RIGHT = b;
        updatePosition(player);
    }

}

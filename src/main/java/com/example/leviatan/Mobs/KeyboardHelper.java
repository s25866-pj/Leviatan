package com.example.leviatan.Mobs;
import com.example.leviatan.Main.Window;
import com.example.leviatan.States.ContinueGame;
import com.example.leviatan.States.Game;
import com.example.leviatan.States.NewGame;
import com.example.leviatan.Utilz.PlayerUtilz;
import com.example.leviatan.Utilz.WindowStates;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class KeyboardHelper {
    private Game game;
    private Window window;
    private Player player;
    private NewGame newGame;
    private PlayerUtilz playerUtilz;
    private ContinueGame continueGame;
    public KeyboardHelper (Game game){
        this.game= game;
    }


    public void movingPressed(KeyEvent keyEvent, Player player, PlayerUtilz playerUtilz, Pane root){
        switch(keyEvent.getCode()) {
            case W:
                player.moveUP(true, player);
                break;
            case A:
                player.moveLEFT(true, player);
                break;
            case S:
                player.moveDOWN(true, player);
                break;
            case D:
                player.moveRIGHT(true, player);
                break;
            case Z:
                NewGame.savePlayer(player);
                break;
            case X:
                player.xpAndLvlManage(1);
                break;
            case I:
                playerUtilz.showPlayerStats(player);
                break;
            case DIGIT0, DIGIT1:
                player.setChosenWeapon(0);
                break;
            case DIGIT2:
                player.setChosenWeapon(1);
                break;
            case DIGIT3:
                player.setChosenWeapon(2);
                break;
            case DIGIT4:
                player.setChosenWeapon(3);
                break;
            case DIGIT5:
                player.setChosenWeapon(4);
                break;
            case DIGIT6, DIGIT7, DIGIT8, DIGIT9:
                player.setChosenWeapon(5);
                break;
            case H:
                player.heal(1);
                break;
            case G:
                player.gettingDamage(1);
                break;
            case ESCAPE:
                WindowStates.status = WindowStates.MENU;
                break;
            case E:
                game.createEnemy(root);
                break;
            case V:
                player.addShield(1);

        }
    }
    public void movingReleased(KeyEvent keyEvent, Player player) {
        switch(keyEvent.getCode()){
            case W:
                player.moveUP(false, player);
                break;
            case S:
                player.moveDOWN(false, player);
                break;
            case A:
                player.moveLEFT(false, player);
                break;
            case D:
                player.moveRIGHT(false, player);
                break;
        }
    }
}

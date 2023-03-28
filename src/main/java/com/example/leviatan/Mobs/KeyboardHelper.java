package com.example.leviatan.Mobs;
import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.States.ContinueGame;
import com.example.leviatan.States.NewGame;
import com.example.leviatan.Utilz.PlayerUtilz;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.util.ArrayList;

import static javafx.scene.input.KeyCode.*;

public class KeyboardHelper {
    private Player player;
    private NewGame newGame;
    private PlayerUtilz playerUtilz;
    private ContinueGame continueGame;
    public void movingPressed(KeyEvent keyEvent, Player player, PlayerUtilz playerUtilz){

        switch(keyEvent.getCode()){
            case W:
                player.moveUP(true,player);
                break;
            case A:
                player.moveLEFT(true,player);
                break;
            case S:
                player.moveDOWN(true,player);
                break;
            case D:
                player.moveRIGHT(true,player);
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
            case G:
                ArrayList<String> listOfFiles = new ArrayList<>();
                File folder = new File(WindowConf.GAME_CONF.SAVES_FILE_LINUX);
                if(!folder.exists()) {
                    folder = new File(WindowConf.GAME_CONF.SAVES_FILE_Win);
                }
                int numberOfFile=folder.listFiles().length;
                for(int i =0;i<numberOfFile;i++){
                    System.out.println("Dodano plik"+folder.getName());
                    listOfFiles.add(String.valueOf(folder.getName()));
                }
                System.out.println(listOfFiles);
                break;
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

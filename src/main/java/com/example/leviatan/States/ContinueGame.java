package com.example.leviatan.States;

import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.Mobs.Player;

import java.io.File;
import java.util.ArrayList;

public class ContinueGame {
    private Player player;
    public void chosePlayer(){
        ArrayList<String>listOfFiles = new ArrayList<>();
        File folder = new File(WindowConf.GAME_CONF.SAVES_FILE_LINUX);
        if(!folder.exists()) {
            folder = new File(WindowConf.GAME_CONF.SAVES_FILE_Win);
        }
        int numberOfFile=folder.listFiles().length;
        for(int i =0;i<numberOfFile;i++){
            listOfFiles.add(String.valueOf(folder.getName().indexOf(i)));
        }
        System.out.println(listOfFiles.get(0));


    }

    public Player loadPlayer(String PlayerName){
        File playerSave = new File(WindowConf.GAME_CONF.SAVES_FILE_LINUX+PlayerName+".txt");
        if(!playerSave.exists()) {
            playerSave = new File(WindowConf.GAME_CONF.SAVES_FILE_Win+PlayerName+".txt");
        }

        return player;
    }


}

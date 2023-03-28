package com.example.leviatan.States;

import com.example.leviatan.GameConf.PlayerConf;
import com.example.leviatan.GameConf.WindowConf;
import com.example.leviatan.Mobs.Items;
import com.example.leviatan.Mobs.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NewGame {
    private ArrayList<Items> Eq = new ArrayList<>();

    public Player createNewPlayer(){
        createWeapon();
        return new Player(
                PlayerConf.STARTING_X,PlayerConf.STARTING_Y,
                PlayerConf.PLAYER_WIDTH, PlayerConf.PLAYER_HEIGHT,
                "Maciek",
                1,
                0,
                10,
                10,
                0,
                1,
                PlayerConf.PLAYER_SPEED,
                3,
                5,
                Eq,
                0
        );
    }
    private void createWeapon() {
        Eq.add(new Items("sword", Items.WeaponType.MELEE, Items.DamageType.PHYSICAL,10,100,1,10,10));
        Eq.add(new Items("BFG", Items.WeaponType.RANGED, Items.DamageType.TOXIC,15,1000,10,0,10));
    }
    public static void savePlayer(Player player) {

        File saveFile = new File(WindowConf.GAME_CONF.SAVES_FILE_LINUX +player.getName()+".txt");
        if(!saveFile.exists()) {
            saveFile = new File(WindowConf.GAME_CONF.SAVES_FILE_Win +player.getName()+".txt");
        }
        try {
            saveFile.createNewFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter playerStatus = new FileWriter(saveFile);
            playerStatus.write("Name: "+ player.getName()
                    +"\nHP: "+player.getHp()+"|"+player.getHpMax()
                    +"\nLVL: "+ player.getLvl()
                    +"\nXP: "+ player.getXp()
                    +"\nDMG: "+ player.getDmg()
                    +"\nDEF: "+ player.getDef()
                    +"\nSHIELD: "+ player.getShield()
                    +"\nRELOAD SPEED:"+ player.getReloadSpeed()
                    +"\nMOVE SPEED: "+ player.getMoveSpeed()
                    +"\nEQ:"+generatePlayerEQ(player));
            playerStatus.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generatePlayerEQ(Player player) {
        ArrayList<Items> EQ = player.getEquipment();
        String eQToString = "Weapon:\n";
        for (int i = 0; i < EQ.size(); i++) {
            eQToString =eQToString +"Nr"+(i+1)+":\n \tName: "+EQ.get(i).getName()
                    +"\n\tWeapon type : "+EQ.get(i).getWeapontype()+"\n";
        }
        return eQToString;
    }
}

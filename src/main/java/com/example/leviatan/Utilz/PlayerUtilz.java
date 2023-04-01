package com.example.leviatan.Utilz;

import com.example.leviatan.GameConf.PlayerConf;
import com.example.leviatan.Mobs.Items;
import com.example.leviatan.Mobs.Player;

import java.util.ArrayList;

public class PlayerUtilz {
    public boolean checkLevel(double xp,int lvl){
        System.out.println(xp);
        switch (lvl){
            case 1:
                if(xp>= PlayerConf.LevelToXp.LEVEL_2){
                    return true;
                }
            case 2:
                if(xp>=PlayerConf.LevelToXp.LEVEL_3){
                    return true;
                }
            case 3:
                if(xp>=PlayerConf.LevelToXp.LEVEL_3){
                    return true;
                }
            case 4:
                if(xp>=PlayerConf.LevelToXp.LEVEL_4){
                    return true;
                }
            case 5:
                if(xp>=PlayerConf.LevelToXp.LEVEL_5){
                    return true;
                }
            default:return false;

        }
    }

    public void showPlayerStats(Player player) {
        System.out.println(
                "Name: "+ player.getName()
                        +"\nHP: "+player.getHp()+"|"+player.getHpMax()
                        +"\nLVL: "+ player.getLvl()
                        +"\nXP: "+ player.getXp()
                        +"\nDMG: "+ player.getDmg()
                        +"\nDEF: "+ player.getDef()
                        +"\nSHIELD: "+ player.getShield()
                        +"\nRELOAD SPEED:"+ player.getReloadSpeed()
                        +"\nMOVE SPEED: "+ player.getMoveSpeed()

        );

        ArrayList<Items> eq = player.getEquipment();
            System.out.println(
                    "Name: "+eq.get(player.getChosenWeapon()).getName()
                            +"\nCost: "+eq.get(player.getChosenWeapon()).getCost()
                            +"\nType: "+eq.get(player.getChosenWeapon()).getWeapontype()
                            +"\nDamageType: "+eq.get(player.getChosenWeapon()).getDamagetype()
                            +"\nDMG: "+eq.get(player.getChosenWeapon()).getDmg()
                            +"\nAS: "+eq.get(player.getChosenWeapon()).getUsingSpeed()
            );
    }
}


package com.example.leviatan.Mobs;

import com.example.leviatan.GameConf.PlayerConf;
import com.example.leviatan.Utilz.PlayerUtilz;
import java.util.ArrayList;

public class Player extends Rect {
    PlayerUtilz playerUtilz = new PlayerUtilz();
    private String name;
    private int lvl;
    private double xp;
    private int dmg;
    private int def;
    private int shield;
    private float reloadSpeed;
    private int moveSpeed;
    private int hp;
    private int hpMax;
    private int chosenWeapon;

    private ArrayList<Items> Equipment;
    public Player(int x, int y, int width, int height, String name, int lvl, double xp, int dmg, int def, int shield, float reloadSpeed, int moveSpeed, int hp, int hpMax, ArrayList<Items> Equipment, int chosenWeapon){
        super(x, y, width, height);
        this.name = name;
        this.lvl = lvl;
        this.xp = xp;
        this.dmg = dmg;
        this.def = def;
        this.shield = shield;
        this.reloadSpeed = reloadSpeed;
        this.moveSpeed = moveSpeed;
        this.hp = hp ;
        this.hpMax = hpMax;
        this.Equipment = Equipment;
        this.chosenWeapon= chosenWeapon;
    }

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    public void incrementLVL() {
        int dmg = getHpMax()-getHp();
        setXp(xp- PlayerConf.LevelToXp.LEVEL_2);
        setDef(getDef()+1);
        setHpMax((getLvl()+1)*5);
        setHp(getHpMax()-dmg);
        setMoveSpeed(getMoveSpeed()+1);
        lvl++;
    }

    public void xpAndLvlManage(int newXp) {
        incrementXp(newXp);
        double xp = getXp();
        int lvl = getLvl();

        boolean result = playerUtilz.checkLevel(xp,lvl);
        if(result){
            incrementLVL();
            System.out.println("lvl up, ur lvl:" +getLvl());
        }
    }



    public int getChosenWeapon() {
        return chosenWeapon;
    }

    public void setChosenWeapon(int chosenWeapon) {
        this.chosenWeapon = chosenWeapon;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public void incrementXp(double received) {
        xp = xp+received;
    }



    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public float getReloadSpeed() {
        return reloadSpeed;
    }

    public void setReloadSpeed(float reloadSpeed) {
        this.reloadSpeed = reloadSpeed;
    }

    public ArrayList<Items> getEquipment() {
        return Equipment;
    }

    public void setEquipment(ArrayList<Items> equipment) {
        Equipment = equipment;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }


}

package com.example.leviatan.Mobs;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Enemy extends Rect {
    private int enemyHpmax;
    private int currentEnemyHp;
    private int enemyShield;
    private int givenXp;
    private Color color;
    private boolean life=true;

    public Enemy(int x, int y, int width, int height, int enemyHpmax, int currentEnemyHp, int enemyShield, int givenXp, Color color) {
        super(x, y, width, height,Color.ORANGE);
        this.enemyHpmax = enemyHpmax;
        this.currentEnemyHp = currentEnemyHp;
        this.enemyShield = enemyShield;
        this.givenXp = givenXp;
    }

    public int getEnemyHpmax() {
        return enemyHpmax;
    }

    public void setEnemyHpmax(int enemyHpmax) {
        this.enemyHpmax = enemyHpmax;
    }

    public int getCurrentEnemyHp() {
        return currentEnemyHp;
    }

    public void setCurrentEnemyHp(int currentEnemyHp) {
        this.currentEnemyHp = currentEnemyHp;
    }

    public int getEnemyShield() {
        return enemyShield;
    }

    public void setEnemyShield(int enemyShield) {
        this.enemyShield = enemyShield;
    }

    public int getGivenXp() {
        return givenXp;
    }

    public void setGivenXp(int givenXp) {
        this.givenXp = givenXp;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public void detectHit(Pane root, Rectangle weapon, Enemy enemy, Player player) {
        if(enemyhited(weapon,enemy,weapon.getY(),weapon.getX())){
            if(getCurrentEnemyHp()<=0){
                if(life){
                    life=false;
                    enemy.getPlayerRect().setVisible(false);
                    root.getChildren().remove(enemy.getPlayerRect());
                    player.xpAndLvlManage(getGivenXp());
                }else{
                    System.out.println("enemy dead");
                }
            }else{
                setCurrentEnemyHp(getCurrentEnemyHp()-(player.getEquipment().get(player.getChosenWeapon()).getDmg()));
            }

            System.out.println("trafiony");
        }
    }

    private boolean enemyhited(Rectangle weapon, Enemy enemy, double y, double x) {
//        System.out.println("x : "+x+" | enemyX : "+enemy.getX());
//        System.out.println("y : "+y+" | enemyy : "+enemy.getY());

        if(x+ weapon.getWidth()>=enemy.getX() && x<= (enemy.getX()+enemy.getWidth())){
            if(y+weapon.getHeight()>=enemy.getY() && y<=(enemy.getY())+enemy.getHeight()){
                return true;
            }
        }
        return false;
    }
}

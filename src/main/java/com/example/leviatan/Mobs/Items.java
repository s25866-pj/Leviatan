package com.example.leviatan.Mobs;

public class Items {
    private String name;
    private  WeaponType Weapontype;
    private  DamageType Damagetype;
    private int cost;
    private int dmg;
    private int usingSpeed;
    private int critChance;
    private int DebufChance;

    public Items(String name, WeaponType weapontype, DamageType damagetype, int cost, int dmg, int usingSpeed, int critChance, int debufChance) {
        this.name = name;
        Weapontype = weapontype;
        Damagetype = damagetype;
        this.cost = cost;
        this.dmg = dmg;
        this.usingSpeed = usingSpeed;
        this.critChance = critChance;
        DebufChance = debufChance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getWeapontype() {
        return Weapontype;
    }

    public void setWeapontype(WeaponType weapontype) {
        Weapontype = weapontype;
    }

    public DamageType getDamagetype() {
        return Damagetype;
    }

    public void setDamagetype(DamageType damagetype) {
        Damagetype = damagetype;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getUsingSpeed() {
        return usingSpeed;
    }

    public void setUsingSpeed(int usingSpeed) {
        this.usingSpeed = usingSpeed;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getDebufChance() {
        return DebufChance;
    }

    public void setDebufChance(int debufChance) {
        DebufChance = debufChance;
    }

    public enum WeaponType {
        MELEE,
        RANGED
    }
    public enum DamageType{
        FIRE,
        ICE,
        PHYSICAL,
        TOXIC,
        ENERGY,

    }
}

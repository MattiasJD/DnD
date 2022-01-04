package com.company;

import java.util.ArrayList;

public abstract class Entity {
    private String name;
    private String race;
    private String role;
    private double hp;
    private  int lvl;
    private double dmg;
    private int money;
    private ArrayList<Items> inv = new ArrayList<>();

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private boolean dead = false;

    public Entity(String name, String race, String role, double hp, int lvl, double dmg, int money) {
        this.name = name;
        this.race = race;
        this.role = role;
        this.hp = hp;
        this.lvl = lvl;
        this.dmg = dmg;
        this.money = money;
    }

    protected Entity() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setLv(int lvl) {
        this.lvl = lvl;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }


    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getRole() {
        return role;
    }

    public double getHp() {
        return hp;
    }

    public int getLv() {
        return lvl;
    }

    public double getDmg() {
        return dmg;
    }

    @Override
    public String toString() {
        return name + ":\n" +
                "hp=" + hp + "\n" +
                "dmg=" + dmg + "\n"+
                "lvl=" + lvl +"\n";
    }
}


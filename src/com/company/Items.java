package com.company;

public enum Items {
    BASICSWORD("Basic sword",10,"Warrior", 0),
    BETTERSWORD("Better sword",20,"Warrior", 100),
    BESTSWORD("Best sword",30,"Warrior", 200),
    BASICBOW("Basic bow",8,"Archer", 0),
    BETTERBOW("Better bow",18,"Archer", 100),
    BESTBOW("Best bow",33,"Archer", 200),
    BASICWAND("Basic wand",7,"Wizard", 0),
    BETTERWAND("Better wand",22,"Wizard", 100),
    BESTWAND("Best wand",50,"Wizard", 200);


    private String name;
    private double dmg;
    private String chr;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getChr(){
        return chr;
    }

    public double getDmg() {
        return dmg;
    }


    Items(String name, int dmg, String chr, int price) {
        this.name = name;
        this.dmg = dmg;
        this.chr = chr;
    }

    Items(String name, double dmg) {
        this.name = name;
        this.dmg = dmg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }


    @Override
    public String toString() {
        return name + ":\n" +
                "dmg = " + dmg + "\n";
    }
}

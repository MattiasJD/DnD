package com.company;
import com.company.utils.IOUtils;
public class Arena {

    private String name;
    private boolean isRunning = true;

    public Arena(String name) {
        this.name = name;
    }

    public void fight(Entity player, Entity enemy) {
        System.out.println("You are in " + name);
        while(isRunning) {
            printEntities(player, enemy);
            round(player, enemy);
        }
    }

    private void printEntities(Entity player, Entity enemy) {
        IOUtils.printText(player.toString());
        IOUtils.printText(enemy.toString());
    }

    private void round(Entity player, Entity enemy) {
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Dodge");
        System.out.print("Type in number: ");
        int i;
        try {
            i = Integer.parseInt(IOUtils.getInput());
            switch (i) {
                case 1 -> {
                    IOUtils.printText(player.getName() + " attacked");
                    double d = Math.random();
                    if (d < 0.5) {
                        //Enemy utoci
                        IOUtils.printText(enemy.getName() + " attacked");
                        enemy.setHp(Math.floor(enemy.getHp() - player.getDmg()));
                        if (isEnemyDead(player, enemy)) {
                            return;
                        }
                        player.setHp(Math.floor(player.getHp() - enemy.getDmg()));
                        if(isPlayerDead(player)) {
                            return;
                        }
                        return;
                    }
                    //Enemy se brani
                    IOUtils.printText(enemy.getName() + " is defending");
                    enemy.setHp(Math.floor(enemy.getHp() - (player.getDmg() / 3)));
                    isEnemyDead(player, enemy);
                }
                case 2 -> {
                    IOUtils.printText(player.getName() + " is defending");
                    double d = Math.random();
                    if (d < 0.5) {
                        // Enemy utoci
                        IOUtils.printText(enemy.getName() + " attacked");
                        player.setHp(Math.floor(player.getHp() - (enemy.getDmg() / 3)));
                        if(isPlayerDead(player)) {
                            return;
                        }
                        return;
                    }
                    // Enemy se brani
                    IOUtils.printText(enemy.getName() + " is defending");
                    IOUtils.printText("Nothing happened BRUH");
                }
                case 3 -> {
                    IOUtils.printText(player.getName() + " Dodge");
                    double d = Math.random();
                    if (d < 0.33) {
                        IOUtils.printText(enemy.getName() + " is attacking");
                        player.setHp(Math.floor(player.getHp() - (enemy.getDmg()*0)));
                        if (isPlayerDead(player)) {
                            return;
                        }
                        return;
                    }
                    // Enemy se brani
                    IOUtils.printText(enemy.getName() + " is defending");
                    IOUtils.printText("Nothing happened HYPERBRUH štěpánUS");
                }

                default -> round(player, enemy);
            }
        } catch (Exception e) {
            round(player, enemy);
        }

    }

    private boolean isPlayerDead(Entity player) {
        if (player.getHp() <= 0) {
            isRunning = false;
            IOUtils.printText("You were defeated.");
            return true;
        }
        return false;
    }

    private boolean isEnemyDead(Entity player, Entity enemy) {
        if (enemy.getHp() <= 0) {
            isRunning = false;
            IOUtils.printText(player.getName() + " wins");
            IOUtils.printText("You have looted the enemy and found "+enemy.getMoney()+" money.");
            player.setMoney(player.getMoney()+ enemy.getMoney());
            player.setLv(player.getLv()+1);
            if (player.getLv() >= 2){
                player.setHp(player.getHp()*1.05);
                player.setDmg(player.getDmg()+3);
            }else if (player.getLv()>=5){
                player.setHp(player.getHp()*1.1);
                player.setDmg(player.getDmg()+5);
            }
            return true;
        }
        return false;
    }

}




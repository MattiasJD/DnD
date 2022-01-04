package com.company;

import com.company.utils.IOUtils;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);

    public Game(){
        System.out.println("$$\\      $$\\           $$\\                                             $$\\ \n" +
                "$$ | $\\  $$ |          $$ |                                            $$ |\n" +
                "$$ |$$$\\ $$ | $$$$$$\\  $$ | $$$$$$$\\  $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\  $$ |\n" +
                "$$ $$ $$\\$$ |$$  __$$\\ $$ |$$  _____|$$  __$$\\ $$  _$$  _$$\\ $$  __$$\\ $$ |\n" +
                "$$$$  _$$$$ |$$$$$$$$ |$$ |$$ /      $$ /  $$ |$$ / $$ / $$ |$$$$$$$$ |\\__|\n" +
                "$$$  / \\$$$ |$$   ____|$$ |$$ |      $$ |  $$ |$$ | $$ | $$ |$$   ____|    \n" +
                "$$  /   \\$$ |\\$$$$$$$\\ $$ |\\$$$$$$$\\ \\$$$$$$  |$$ | $$ | $$ |\\$$$$$$$\\ $$\\ \n" +
                "\\__/     \\__| \\_______|\\__| \\_______| \\______/ \\__| \\__| \\__| \\_______|\\__|\n" +
                "                                                                           \n" +
                "                                                                           ");
        System.out.println("--------------------------------------------------------------------------------------------");
        IOUtils.printText("Type in your character's name");
        String name = scan.nextLine();
        Entity Warrior = new Player(name, "Human", "Warrior", 100, 1, 5, 20);
        Entity Archer = new Player(name, "Elf", "Archer", 110, 1, 3, 20);
        Entity Wizard = new Player(name, "Gnome", "Wizard", 90, 1, 2, 20);
        /**Easter egg lol**/
        Entity Esch = new Player(name, "SuperHuman", "Badass", 1000, 10, 350, 8000);
        IOUtils.printText("Which character would you like to play?");
        IOUtils.printText("There are: ");
        System.out.println(" _   _   _   _+       |\n" +
                "/_`-'_`-'_`-'_|  \\+/  |\n" +
                "\\_`M'_`D'_`C'_| _<=>_ |\n" +
                "  `-' `-' `-' 0/ \\ / o=o\n" +
                "              \\/\\ ^ /`0\n" +
                "              | /_^_\\\n" +
                "              | || ||\n" +
                "            __|_d|_|b__");
        IOUtils.printText(Warrior.getRace()+" "+Warrior.getRole());
        IOUtils.printText(Warrior.toString());
        System.out.println("          \n" +
                "           /   :.    \n" +
                "          /     \\   \n" +
                "       ,;/,      ::  \n" +
                "   ___:c/.(      ||  \n" +
                " ,'  _|:)>>>--,-'B)> \n" +
                "(  '---'\\--'` _,'|| \n" +
                " `--.    \\ ,-'   ;; \n" +
                "     |    \\|    //  \n" +
                "     |     \\   ;'   \n" +
                "     |_____|\\,'     \n" +
                "     :  ,   :         \n" +
                "     | : \\ :        \n" +
                "     | | : :         \n" +
                "     | | |_`.        \n" +
                "     '--`   ");
        IOUtils.printText(Archer.getRace()+" "+Archer.getRole());
        IOUtils.printText(Archer.toString());
        System.out.println("         /^\\     .\n" +
                "    /\\   \"V\"\n" +
                "   /__\\   I      O  o\n" +
                "  //..\\\\  I     .\n" +
                "  \\].`[/  I\n" +
                "  /l\\/j\\  (]    .  O\n" +
                " /. ~~ ,\\/I          .\n" +
                " \\\\L__j^\\/I       o\n" +
                "  \\/--v}  I     o   .\n" +
                "  |    |  I   _________\n" +
                "  |    |  I c(`       ')o\n" +
                "  |    l  I   \\.     ,/\n" +
                "_/j  L l\\_!  _//^---^\\\\_    ");
        IOUtils.printText(Wizard.getRace()+" "+Wizard.getRole());
        IOUtils.printText(Wizard.toString());
        System.out.println("Type either wizard or warrior or archer");
        String selection = scan.nextLine();
        selection.toLowerCase(Locale.ROOT);
        selection.trim();
        switch (selection){
            case "wizard" ->{
                IOUtils.printText("So you chose a wizard and your name is "+Wizard.getName());
                new Room(Wizard);
            }
            case "warrior" ->{
                IOUtils.printText("So you chose a warrior and your name is "+Warrior.getName());
                new Room(Warrior);
            }
            case "archer" ->{
                IOUtils.printText("So you chose an archer and your name is "+Archer.getName());
                new Room(Archer);
            }
            case "esch" ->{
                IOUtils.printText("So you chose a Eschino and his cigarillos.");
                new Room(Esch);
            }
            default -> new Game();
        }
    }
}




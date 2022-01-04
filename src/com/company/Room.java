package com.company;
import com.company.utils.IOUtils;

import java.util.Random;
import java.util.Objects;
import java.util.Scanner;

public class Room {
    public static int ch;
    public int yes = 0;
    private static Scanner scan = new Scanner(System.in);
    private Random random = new Random();

    public Room(Entity player) {
        room(player);
    }

    public void room(Entity player) {
        IOUtils.printText("THE STORY BEGGINS");
        System.out.println("-----------------------------------------");
        IOUtils.printText("You're finally awake! Said the whore lying next to you. You don't remember much but it must have been brutal. \n" +
                "Now that you're catched up with your thoughts, you see the ugliness in that whore's face. And she seems to demand some \n"+
                "money for her service. What will you do?");
        IOUtils.printText("1. Check if you have enough money to pay her.");
        IOUtils.printText("2. Kill that bitch.");
        ch = scan.nextInt();
        switch (ch){
            case 1 -> {
                if(player.getMoney()>=10){
                    player.setMoney(player.getMoney()-10);
                    IOUtils.printText("You paid the whore, she leaves satisfied.");
                } else{
                    IOUtils.printText("Looks like you have "+player.getMoney()+" money lol. You cant pay her... there is only one thing to do.");
                    Arena arena = new Arena("Tavern");
                    Entity enemy = new Enemies("Whore", "Human, i guess", "her body is on sale lol", 5, 1, 5, 10);
                    arena.fight(player, enemy);
                    IOUtils.printText("You have searched the whore's body and found 10 money!");
                    player.setMoney(player.getMoney()+10);
                }
            }
            case 2 ->{Arena arena = new Arena("Tavern");
                Entity enemy = new Enemies("Whore", "Human, i guess", "her body is on sale lol", 5, 1, 5, 10);
                arena.fight(player, enemy);
            }
        }
        IOUtils.printText("You are getting a strong headache and strange memory flashes before your eyes.\n" +
                "You can see a huge castle with big ugly thing inside it. Right after you've snapped out of it \n" +
                "your mind tells you that you need to kill that beast and help the people.");
        if (Objects.equals(player.getRole(), Items.BASICSWORD.getChr())){
            IOUtils.printText("You picked up your sword.");
            player.setDmg(player.getDmg()+Items.BASICSWORD.getDmg());
        } else if(Objects.equals(player.getRole(), Items.BASICBOW.getChr())){
            IOUtils.printText("You picked up your bow.");
            player.setDmg(player.getDmg()+Items.BASICBOW.getDmg());
        } else if(Objects.equals(player.getRole(), Items.BASICWAND.getChr())){
            IOUtils.printText("You picked up your magic wand.");
            player.setDmg(player.getDmg()+Items.BASICWAND.getDmg());
        }
        IOUtils.printText("Then you packed your things and got on your journey, walking directly into the sun...");
        room1(player);
    }
    public void room1(Entity player){
        System.out.println("--------------------------");
        IOUtils.printText(" a few hours passed by...");
        System.out.println("--------------------------");
        IOUtils.printText("You have walked almost all day and it's getting dark. You hear a voice \n" +
                "behind some bushes. You can see a bandit and tied up nobleman. What will you do?\n" +
                "1. Mind your own bussines and try to find some other place to sleep\n" +
                "2. Go kill the bandits and free the man");
        ch = scan.nextInt();
        switch (ch){
            case 1 -> room2(player);
            case 2 -> {
                Arena arena = new Arena("Bandit camp near the woods");
                Entity enemy1 = new Enemies("BanditFührer", "Human", "Bandit", 50, 1, 15,20);
                arena.fight(player, enemy1);
                    IOUtils.printText("'Thank you thousand times' says the nobleman after you've untied him.\n" +
                            "It seems he is looking for something and then he says: 'Oh no, when he attacked me\n" +
                            "I lost my precious gemstone. Would you help me find it?\n" +
                            "1. Yes\n" +
                            "2. No");
                    ch = scan.nextInt();
                    switch (ch) {
                        case 1 -> room1a(player);
                        case 2 -> {
                            IOUtils.printText("Okay still thanks.");
                            room2(player);
                        }
                }
            }
        }
    }
    public void room1a(Entity player){
        IOUtils.printText("SIDEQUEST FIND HIS ROCK");
        IOUtils.printText("Ok, so they have attacked me near a cave. I think it was this way (points somewhere)");
        IOUtils.printText("you are walking...    ");
        IOUtils.printText("You came up to a cave which looks like the one he was mentioning. There aren't any gemstones outside so you\n" +
                "peek inside. And actually there is one.");
        IOUtils.printText("There is also some kind of a lever, would you like to pull it? There might be a big danger!");
        ch = scan.nextInt();
        switch(ch){
            case (1) -> {
                IOUtils.printText("The door opens up and there seems to be a small compartment. You walk inside and there is:\n");
                IOUtils.printText("   ");
                System.out.println(" \n" +
                        "/***\n" +
                        " *     /$$$$$$$                               /$$             /$$$$$$$$                     /$$                                                   /$$                 /$$      \n" +
                        " *    | $$__  $$                             | $$            | $$_____/                    | $$                                                  | $$                | $$      \n" +
                        " *    | $$  \\ $$ /$$$$$$  /$$    /$$ /$$$$$$ | $$            | $$        /$$$$$$$  /$$$$$$$| $$$$$$$                    /$$  /$$$$$$             | $$$$$$$  /$$   /$$| $$$$$$$ \n" +
                        " *    | $$$$$$$/|____  $$|  $$  /$$//$$__  $$| $$            | $$$$$    /$$_____/ /$$_____/| $$__  $$                  |__/ /$$__  $$            | $$__  $$| $$  | $$| $$__  $$\n" +
                        " *    | $$____/  /$$$$$$$ \\  $$/$$/| $$$$$$$$| $$            | $$__/   |  $$$$$$ | $$      | $$  \\ $$                   /$$| $$$$$$$$            | $$  \\ $$| $$  | $$| $$  \\ $$\n" +
                        " *    | $$      /$$__  $$  \\  $$$/ | $$_____/| $$            | $$       \\____  $$| $$      | $$  | $$                  | $$| $$_____/            | $$  | $$| $$  | $$| $$  | $$\n" +
                        " *    | $$     |  $$$$$$$   \\  $/  |  $$$$$$$| $$            | $$$$$$$$ /$$$$$$$/|  $$$$$$$| $$  | $$                  | $$|  $$$$$$$            | $$$$$$$/|  $$$$$$/| $$  | $$\n" +
                        " *    |__/      \\_______/    \\_/    \\_______/|__/            |________/|_______/  \\_______/|__/  |__/                  | $$ \\_______/            |_______/  \\______/ |__/  |__/\n" +
                        " *                                                                                                                /$$  | $$                                                    \n" +
                        " *                                                                                                               |  $$$$$$/                                                    \n" +
                        " *                                                                                                                \\______/                                                     \n" +
                        " */\n");
                IOUtils.printText("You are so amazed when you think of Pája Eschů, that you gain 30HP");
                player.setHp(player.getHp()+30);
                IOUtils.printText("You head back. After arriving at the camp you can see the nobleman very nervous. When he spots you and the gemstone\n" +
                        "in your hand he seems relived. He thanks you and gives you 50 money.");
                player.setMoney(player.getMoney()+50);
                room2(player);
            }
            case (2) -> {
                IOUtils.printText("You head back. After arriving at the camp you can see the nobleman very nervous. When he spots you and the gemstone\n" +
                        "in your hand he seems relived. He thanks you and gives you 50 money.");
                player.setMoney(player.getMoney()+50);
                room2(player);
            }
        }
    }
    public void room2(Entity player){
        IOUtils.printText("You have found a great spot under a tree where you can enjoy some medievil sleep");
        System.out.println("                                               |\n" +
                "                                              -x-\n" +
                "                                               |\n" +
                "              v .   ._, |_  .,\n" +
                "           `-._\\/  .  \\ /    |/_\n" +
                "               \\\\  _\\, y | \\//\n" +
                "         _\\_.___\\\\, \\\\/ -.\\||\n" +
                "           `7-,--.`._||  / / ,\n" +
                "           /'     `-. `./ / |/_.'\n" +
                "                     |    |//\n" +
                "                     |_    /\n" +
                "                     |-   |\n" +
                "                     |   =|\n" +
                "                     |    |\n" +
                "--------------------/ ,  . \\--------._\n");
        System.out.println("--------------------------");
        IOUtils.printText(" 8 hours later...");
        System.out.println("--------------------------");
        IOUtils.printText("You are waking up to a sunny day.");
        int num = random.nextInt(10+1);
        if(num>5){
            IOUtils.printText("There is a man in a costume with a flute walking...");
            IOUtils.printText("'Toss a coin to yo- oh sorry did I wake you?\n" +
                    "Hey you seem like a hero of some kind'");
            IOUtils.printText("'Here are some money, they may come in handy. Bye!'");
            System.out.println("                          ,     \n" +
                    "                      ,   |     \n" +
                    "   _,,._              |  0'     \n" +
                    " ,'     `.__,--.     0'         \n" +
                    "/   .--.        |           ,,, \n" +
                    "| [=========|==|==|=|==|=|==___]\n" +
                    "\\   \"--\"    _|   |        ''' \n" +
                    " `._   _,'  `--'                \n" +
                    "    \"\"'     ,   ,0     ,        \n" +
                    "            |)  |)   ,'|        \n" +
                    "  ____     0'   '   | 0'        \n" +
                    "  |  |             0'           \n" +
                    " 0' 0'");
            player.setMoney(player.getMoney()+40);
        } else{

        }
        IOUtils.printText("You got up, packed your things and went off.");
        room3(player);
    }
    public void room3(Entity player){
        System.out.println("--------------------------");
        IOUtils.printText(" about 2 hours of walking later...");
        System.out.println("--------------------------");
        IOUtils.printText("You came up to a inn, in the middle of nowhere.\n" +
                "And next to it stands a small shop.");
        IOUtils.printText("'Hi, you look like you need some better weapons, am I right?'");
        System.out.println("Your weapon: ");

        if (Objects.equals(player.getRole(), Items.BASICSWORD.getChr())){
            System.out.print(Items.BASICSWORD.toString());
            System.out.println("-------------");
            System.out.println("Weapon avaiable to buy: ");
            System.out.println(Items.BETTERSWORD.toString());
            System.out.println("Do you want to buy the sword?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            ch = scan.nextInt();
            switch (ch){
                case 1 ->{
                    if(player.getMoney()>=Items.BETTERSWORD.getPrice()){
                        player.setMoney(player.getMoney()-Items.BETTERSWORD.getPrice());
                        player.setDmg(player.getDmg()+Items.BETTERSWORD.getDmg());
                        IOUtils.printText("You bought it.");
                    } else{
                        System.out.println("Unfortunetaly, you don't have enough money. SUCKAH");
                    }
                }
                case 2 ->{
                    IOUtils.printText("'Nevermind then, goodbye.'");
                }
            }
        } else if(Objects.equals(player.getRole(), Items.BASICBOW.getChr())){
            System.out.println(Items.BASICBOW.toString());
            System.out.println("-------------");
            System.out.println("Weapon avaiable to buy: ");
            System.out.println(Items.BETTERBOW.toString());
            System.out.println("Do you want to buy the bow?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            ch = scan.nextInt();
            switch (ch){
                case 1 ->{
                    if(player.getMoney()>=Items.BETTERBOW.getPrice()){
                        player.setMoney(player.getMoney()-Items.BETTERBOW.getPrice());
                        player.setDmg(player.getDmg()+Items.BETTERBOW.getDmg());
                        IOUtils.printText("You bought it.");
                    } else{
                        System.out.println("Unfortunetaly, you don't have enough money. SUCKAH");
                    }
                }
                case 2 ->{
                    IOUtils.printText("'Nevermind then, goodbye.'");
                }
            }
        } else if(Objects.equals(player.getRole(), Items.BASICWAND.getChr())){
            System.out.println(Items.BASICWAND.toString());
            System.out.println("-------------");
            System.out.println("Weapon avaiable to buy: ");
            System.out.println(Items.BETTERWAND.toString());
            System.out.println("Do you want to buy the wand?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            ch = scan.nextInt();
            switch (ch){
                case 1 ->{
                    if(player.getMoney()>=Items.BETTERWAND.getPrice()){
                        player.setMoney(player.getMoney()-Items.BETTERWAND.getPrice());
                        player.setDmg(player.getDmg()+Items.BETTERWAND.getDmg());
                        IOUtils.printText("You bought it.");
                    } else{
                        System.out.println("Unfortunetaly, you don't have enough money. SUCKAH");
                    }
                }
                case 2 ->{
                    IOUtils.printText("'Nevermind then, goodbye.'");
                }
            }
        }
        IOUtils.printText("When you enter iside the Innkeeper welcomes you, but there are no guests.\n" +
                "'Hello there mighty traveler! I'm sure you are wondering where are all the\n" +
                "guests. Well, there is a Werewolf nearby, and it is ruining all of my bussines.'");
        IOUtils.printText("Would you help me get rid of it?");
        IOUtils.printText("1. Yes\n" +
                "2. No");
        ch = scan.nextInt();
        switch (ch){
            case 1 ->{
                IOUtils.printText("'Okaaayyy let's gooo. So it should be somewhere in the forest, but be careful.\n" +
                        "When you kill it, come back and I will give you some reward.");
                room3a(player);
            }
            case 2 ->{
                IOUtils.printText("'There is no way I'm gonna serve you. Get out!'");
                room4(player);
            }
        }
    }
    public void room3a(Entity player){
        IOUtils.printText("SIDEQUEST KILL THE WEREWOLF");
        Entity werewolf = new Enemies("Werewolf","Werewolf","Bad",130,2,40,0);
        Arena forest = new Arena("Dark forest");
        IOUtils.printText("You have stumbled into a dark forest. Shivering hairs on your back tell you, that someone or\n" +
                "something is behind you.");
        IOUtils.printText("You quickly turn around, and there is a big Werewolf preparing to attack!");
        forest.fight(player, werewolf);
        IOUtils.printText("You kicked that werewolf's ass!");
        System.out.println("--------------------------");
        IOUtils.printText("Back at the inn");
        IOUtils.printText("'Oh my, you actually did it!\n" +
                "Here is your 200 money.'");
        player.setMoney(player.getMoney()+200);
        IOUtils.printText("'Would you like a beer?'\n" +
                "Beer apparently costs 10 money, it gives you 80hp.\n" +
                "1. Yes\n" +
                "2. No");
        ch = scan.nextInt();
        switch (ch){
            case 1 ->{
                System.out.println(".~~~~.\n" +
                        "i====i_\n" +
                        "|cccc|_)\n" +
                        "|cccc|   \n" +
                        "`-==-'");
                IOUtils.printText("You drink the whole beer, but it tasted like svijany\n" +
                        "so that is the last time you were drinking that.");
                player.setHp(player.getHp()+80);
                IOUtils.printText("'Well then goodbye, and thank you!'\n" +
                        "You left the inn and went in the same direction you were heading.");
            }
            case 2 ->{
                IOUtils.printText("'Well then goodbye, and thank you!'\n" +
                        "You left the inn and went in the same direction you were heading.");

            }

        }
        room4(player);
    }
    public void room4(Entity player){
        Arena castle = new Arena("Big and dark Castle");
        IOUtils.printText("Finally, after all this time you arrive at the castle.");
        System.out.println("               T~~\n" +
                "               |\n" +
                "              /\"\\\n" +
                "      T~~     |'| T~~\n" +
                "  T~~ |    T~ WWWW|\n" +
                "  |  /\"\\   |  |  |/\\T~~\n" +
                " /\"\\ WWW  /\"\\ |' |WW|\n" +
                "WWWWW/\\| /   \\|'/\\|/\"\\\n" +
                "|   /__\\/]WWW[\\/__\\WWWW\n" +
                "|\"  WWWW'|I_I|'WWWW'  |\n" +
                "|   |' |/  -  \\|' |'  |\n" +
                "|'  |  |LI=H=LI|' |   |\n" +
                "|   |' | |[_]| |  |'  |\n" +
                "|   |  |_|###|_|  |   |\n" +
                "'---'--'-/___\\-'--'---'");
        IOUtils.printText("You walk inside the castle, and into the first room.");
        int num = random.nextInt(10+1);
        if(num>5){
            Entity skeleton = new Enemies("Skeleton","Bones","Archer", 50, 2, 20, 50);
            castle.fight(player, skeleton);
            IOUtils.printText("You have defeated the skeleton, now you can continue.");
        }
        else{
            Entity guard = new Enemies("Castle Guard","Human","Warrior",40,2,25,60);
            castle.fight(player, guard);
            IOUtils.printText("You have defeated the guard. Now you can continue.");
        }
        room5(player);
    }
    public void room5(Entity player){
        IOUtils.printText("You come across a hallway.");
        Arena castle2 = new Arena("Hallway in front of the coronation hall");
        IOUtils.printText("'Oh no please help!\n" +
                "There is a man being attacked by vampire!\n" +
                "You saved the man by shouting at him, but now\n" +
                "it's coming after you!\n" +
                "But he is unable to properly bite through your armor.");
        Entity vampire = new Enemies("Vampire","Dead Human","sucks blood",70,2,10,100);
        castle2.fight(player, vampire);
        IOUtils.printText("Thank you so much for saving me. You maybe be interested in some of my wares?");
        if (Objects.equals(player.getRole(), Items.BETTERSWORD.getChr())){
            System.out.println(Items.BESTSWORD.toString());
            System.out.println("Do you want to buy the BEST sword?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            ch = scan.nextInt();
            switch (ch){
                case 1 ->{
                    if(player.getMoney()>=Items.BESTSWORD.getPrice()){
                        player.setMoney(player.getMoney()-Items.BESTSWORD.getPrice());
                        player.setDmg(player.getDmg()+Items.BESTBOW.getDmg());
                        IOUtils.printText("You bought it.");
                    } else{
                        System.out.println("Unfortunetaly, you don't have enough money.");
                    }
                }
                case 2 ->{
                    IOUtils.printText("'Nevermind then, goodbye.'");
                }
            }
        } else if(Objects.equals(player.getRole(), Items.BETTERBOW.getChr())){
            System.out.println(Items.BESTBOW.toString());
            System.out.println("Do you want to buy the BEST bow?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            ch = scan.nextInt();
            switch (ch){
                case 1 ->{
                    if(player.getMoney()>=Items.BESTBOW.getPrice()){
                        player.setMoney(player.getMoney()-Items.BESTBOW.getPrice());
                        player.setDmg(player.getDmg()+Items.BESTBOW.getDmg());
                        IOUtils.printText("You bought it.");
                    } else{
                        System.out.println("Unfortunetaly, you don't have enough money.");
                    }
                }
                case 2 ->{
                    IOUtils.printText("'Nevermind then, goodbye.'");
                }
            }
        } else if(Objects.equals(player.getRole(), Items.BETTERWAND.getChr())){
            System.out.println(Items.BESTWAND.toString());
            System.out.println("Do you want to buy the BEST wand?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            ch = scan.nextInt();
            switch (ch){
                case 1 ->{
                    if(player.getMoney()>=Items.BESTWAND.getPrice()){
                        player.setMoney(player.getMoney()-Items.BESTWAND.getPrice());
                        player.setDmg(player.getDmg()+Items.BESTWAND.getDmg());
                        IOUtils.printText("You bought it.");
                    } else{
                        System.out.println("Unfortunetaly, you don't have enough money.");
                    }
                }
                case 2 ->{
                    IOUtils.printText("'Nevermind then, goodbye.'");
                }
            }
        }
        IOUtils.printText("'Now beware, behind these doors is the monster! Bye.\n" +
                "Yeah I also forgot, here is something to heal you, it won't be an easy fight.'");
        player.setHp(player.getHp()+80);
        room6(player);
    }
    public void room6 (Entity player){
        Arena coronationhall = new Arena("Coronation hall");
        Entity setepe = new Enemies("Stepa..va","monster","badbitch",210, 3, 45, 1000);
        IOUtils.printText("You slowly open the big wooden door to reveal a huge dragon with ugly face!");
        IOUtils.printText("This is it. This is what you saw in your vision. This is the monster that has been murdering all the people.\n" +
                "It's time to get revenge!");
        coronationhall.fight(player, setepe);
        System.out.println("------------------------------------");
        System.out.println(" $$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  $$$$$$$\\   $$$$$$\\ $$$$$$$$\\ $$\\   $$\\ $$\\        $$$$$$\\ $$$$$$$$\\ $$$$$$\\  $$$$$$\\  $$\\   $$\\  $$$$$$\\  \n" +
                "$$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ $$  __$$\\ $$  __$$\\\\__$$  __|$$ |  $$ |$$ |      $$  __$$\\\\__$$  __|\\_$$  _|$$  __$$\\ $$$\\  $$ |$$  __$$\\ \n" +
                "$$ /  \\__|$$ /  $$ |$$$$\\ $$ |$$ /  \\__|$$ |  $$ |$$ /  $$ |  $$ |   $$ |  $$ |$$ |      $$ /  $$ |  $$ |     $$ |  $$ /  $$ |$$$$\\ $$ |$$ /  \\__|\n" +
                "$$ |      $$ |  $$ |$$ $$\\$$ |$$ |$$$$\\ $$$$$$$  |$$$$$$$$ |  $$ |   $$ |  $$ |$$ |      $$$$$$$$ |  $$ |     $$ |  $$ |  $$ |$$ $$\\$$ |\\$$$$$$\\  \n" +
                "$$ |      $$ |  $$ |$$ \\$$$$ |$$ |\\_$$ |$$  __$$< $$  __$$ |  $$ |   $$ |  $$ |$$ |      $$  __$$ |  $$ |     $$ |  $$ |  $$ |$$ \\$$$$ | \\____$$\\ \n" +
                "$$ |  $$\\ $$ |  $$ |$$ |\\$$$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |  $$ |   $$ |  $$ |$$ |      $$ |  $$ |  $$ |     $$ |  $$ |  $$ |$$ |\\$$$ |$$\\   $$ |\n" +
                "\\$$$$$$  | $$$$$$  |$$ | \\$$ |\\$$$$$$  |$$ |  $$ |$$ |  $$ |  $$ |   \\$$$$$$  |$$$$$$$$\\ $$ |  $$ |  $$ |   $$$$$$\\  $$$$$$  |$$ | \\$$ |\\$$$$$$  |\n" +
                " \\______/  \\______/ \\__|  \\__| \\______/ \\__|  \\__|\\__|  \\__|  \\__|    \\______/ \\________|\\__|  \\__|  \\__|   \\______| \\______/ \\__|  \\__| \\______/ \n" +
                "                                                                                                                                                  \n" +
                "                                                                                                                                                  \n" +
                "                                                                                                                                                  ");
        System.out.println("You have finished the game. It took me a lot of time haha. GOODBYE.");
    }
}

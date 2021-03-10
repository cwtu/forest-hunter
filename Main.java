import java.util.Scanner;
public class Main{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        do{
            System.out.println("Type str to start the game");
        }while(!sc.nextLine().equals("str"));

        start();
    }

    public static void start(){
        Player p = new Player();
        Enemy e = new Enemy();
        Map m = new Map(p, e);

        System.out.println("What is your Name?");
        System.out.print("Name: ");
        String player = sc.nextLine();
        p.setPlayerName(player);
        System.out.println("Hi " + p.getName() + "! Welcome to my little game. You are randomly placed in a space of a 5X5 forest. The mighty monster is also randomly placed in the forest, but the meighty monster won't be in the same spot as yours. You will be able to view your location in the forest, but the location of the mighty monster and houses are hidden from you until you find the map. The map is locked in a box in the lighthouse, which you have to wonder around the forest to find. You will need a key to unlock the box and get the map, which is also somewhere in the forest. During the game, you will enter some houses and find some food. There are 5 places where you can find foods: School, Junkyard, Warehouse, Hut, and Lighthouse. The rest of the spaces are just forest. If you accidently bump into the mighty monster during the game, the battle starts automatically. There is no escaping from the enemy. You don't need the map to win this game. However, your initial health is not enough to defeat the mighty monster, so eat alot of food and gain enough of health before the battle begins! This game involves some luck and more lucks to play.\nGood Luck and have fun!\n");

        System.out.println("**Type help to get the commands**\n");

        //m.printMap();
        m.getPlayerLocationDescription(p);

        while(true){
            System.out.print(">");
            String command = sc.nextLine();

            try{
                if(command.equals("n")){
                    if(p.getPositionX() == 0){
                        throw new OutOfBoundException("You cannot go that way!");
                    }
                    m.getSpace(p.getPositionX(), p.getPositionY()).characterExit(p);
                    m.getSpace(p.getPositionX() - 1, p.getPositionY()).characterEnter(p);
                    p.moveUp();
                    
                    m.getPlayerLocationDescription(p);
                }
                else if(command.equals("s")){
                    if(p.getPositionX() == 4){
                        throw new OutOfBoundException("You cannot go that way!");
                    }
                    m.getSpace(p.getPositionX(), p.getPositionY()).characterExit(p);
                    m.getSpace(p.getPositionX() + 1, p.getPositionY()).characterEnter(p);
                    p.moveDown();

                    m.getPlayerLocationDescription(p);
                }
                else if(command.equals("e")){
                    if(p.getPositionY() == 4){
                        throw new OutOfBoundException("You cannot go that way!");
                    }
                    m.getSpace(p.getPositionX(), p.getPositionY()).characterExit(p);
                    m.getSpace(p.getPositionX(), p.getPositionY() + 1).characterEnter(p);
                    p.moveRight();
                    
                    m.getPlayerLocationDescription(p);
                }
                else if(command.equals("w")){
                    if(p.getPositionY() == 0){
                        throw new OutOfBoundException("You cannot go that way!");
                    }
                    m.getSpace(p.getPositionX(), p.getPositionY()).characterExit(p);
                    m.getSpace(p.getPositionX(), p.getPositionY() - 1).characterEnter(p);
                    p.moveLeft();

                    m.getPlayerLocationDescription(p);
                }

                else if(command.equals("m")){
                    m.printMap();
                }
                else if(command.equals("d")){
                    m.getPlayerLocationDescription(p);
                }

                else if(command.equals("look")){
                    m.getSpace(p.getPositionX(), p.getPositionY()).printStorage();
                }
                else if(command.equals("status")){
                    p.printPlayerStatus();
                }
                else if(command.equals("inventory")){
                    p.printPlayerInventory();
                }
                else if(command.equals("info")){
                    p.printPlayerInfo();
                }

                else if(command.equals("take.water")){
                    p.takeItem(m.getSpace(p.getPositionX(), p.getPositionY()).getItem(Food.WATER));
                }
                else if(command.equals("take.apple")){
                    p.takeItem(m.getSpace(p.getPositionX(), p.getPositionY()).getItem(Food.APPLE));
                }
                else if(command.equals("take.chocolate")){
                    p.takeItem(m.getSpace(p.getPositionX(), p.getPositionY()).getItem(Food.CHOCOLATE));
                }
                else if(command.equals("take.meat")){
                    p.takeItem(m.getSpace(p.getPositionX(), p.getPositionY()).getItem(Food.MEAT));
                }
                else if(command.equals("take.key")){
                    p.takeItem(m.getSpace(p.getPositionX(), p.getPositionY()).getItem(OtherItem.KEY));
                }
                else if(command.equals("take.map")){
                    p.takeItem(m.getSpace(p.getPositionX(), p.getPositionY()).getItem(OtherItem.MAP));
                }

                else if(command.equals("help")){
                    printHelp();
                    printItemDescription();
                }

                else{
                    System.out.println("I can't recognize this command.");
                    System.out.println("Type help for help.");
                }
            }
            catch(Exception exception){
                System.out.println(exception.getMessage());
            }
            finally{
                if(e.getPositionX() == p.getPositionX() && e.getPositionY() == p.getPositionY()){
                    if(battle(p,e)){
                        System.out.println("Congratulations! You have killed the monster and won the game");
                        break;
                    }
                    else{
                        System.out.println("GAME OVER");
                        while(true){
                            System.out.println("Restart the game? [yes/no]");
                            command = sc.nextLine();
                            if(command.equals("yes")){
                                start();
                                break;
                            }
                            if(command.equals("no")){
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    public static boolean battle(Player p, Enemy e){

        System.out.println("Arrr~ " + p.getName() + "! I am the king of the forest. I will eat you.");
        while(true){
            String command = sc.nextLine();

            if(command.equals("attack")){
                p.attack(e);
                e.attack(p);

                System.out.println(p.getName() + "'s Health: " + p.getHealthValue() + " / Monster's Health: " + e.getHealthValue());
            }

            else if(command.equals("status")){
                p.printPlayerStatus();
            }
            else if(command.equals("inventory")){
                p.printPlayerInventory();
            }
            else if(command.equals("info")){
                p.printPlayerInfo();
            }
            else if(command.equals("help")){
                printHelp();
                printItemDescription();
            }
            else{
                System.out.println("I can't recognize this command.");
                System.out.println("Type help for help.");
            }

            if(e.getHealthValue() <= 0){
                return true;
            }
            if(p.getHealthValue() <= 0){
                return false;
            }
        }
    }

    public static void printHelp(){
        System.out.println("Command         Action");
        System.out.println("---------       ---------");
        System.out.println("n               move north");
        System.out.println("s               move south");
        System.out.println("e               move east");
        System.out.println("w               move west");
        System.out.println("");
        System.out.println("m               print map");
        System.out.println("d               show description of your location");
        System.out.println("look            look what items are in your location");
        System.out.println("status          show your attack value and health value");
        System.out.println("inventory       show what is in your inventory");
        System.out.println("info            show both your status and your inventory");
        System.out.println("");
        System.out.println("take.water      take a water");
        System.out.println("take.apple      take an apple");
        System.out.println("take.chocolate  tale a chocolate");
        System.out.println("take.meat       take a meat");
        System.out.println("");
        System.out.println("attack          attack the enemy (only during battle)");
        System.out.println("help            show commands and descriptions");
        System.out.println("");
    }

    public static void printItemDescription(){
        System.out.println("Item            Description");
        System.out.println("---------       ---------");
        System.out.println("water           +4 health value");
        System.out.println("apple           +10 health value");
        System.out.println("chocolate       +30 health value");
        System.out.println("meat            +60 health value");
        System.out.println("");
        System.out.println("map             It shows a 5X5 map and also shows your currunt position and enemy's position");
        System.out.println("key             It opens a box in the Lighthouse");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

}

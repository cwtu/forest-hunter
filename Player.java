import java.util.Random;
import java.util.ArrayList;

public class Player extends Character{

    private String playerName;
    private ArrayList<Item> inventory = new ArrayList<>();

    Random ran = new Random();

    public Player(){
        super(100, 50);
        this.playerName = "";
    }

    public void moveUp(){
        if(positionX == 0){
            System.out.println("You cannot go that way!");
        }
        else{
            positionX --;

        }
    }
    public void moveDown(){
        if(positionX == 4){
            System.out.println("You cannot go that way!");
        }
        else{
            positionX ++;
        }
    }
    public void moveRight(){
        if(positionY == 4){
            System.out.println("You cannot go that way!");
        }
        else{
            positionY ++;
        }
    }
    public void moveLeft(){
        if(positionY == 0){
            System.out.println("You cannot go that way!");
        }
        else{
            positionY --;
        }
    }

    public void takeItem(Item i){
        if(i instanceof Food){
            healthValue += ((Food) i).getFoodHealthValue();
        }
        else{
            inventory.add(i);
        }
    }

    public String getName(){
        return this.playerName;
    }

    public void setPlayerName(String name){
        this.playerName = name;
    }

    public void randomizePoistion(){
        positionX = ran.nextInt(5);
        positionY = ran.nextInt(5);
    }

    public boolean haveItem(Item i){
        return inventory.contains(i);
    }

    public void printPlayerInventory(){
        System.out.println(getName() + "'s Inventory:");
        System.out.println("--------------------");
        for(Item i : inventory){
            System.out.println(i.getName());
        }
        System.out.println("--------------------");
    }

    public void printPlayerStatus(){
        System.out.println(getName() + "'s Status:");
        System.out.println("--------------------");
        System.out.println("Attack: " + getAttackValue());
        System.out.println("Health: " + getHealthValue());
        System.out.println("--------------------");
    }

    public void printPlayerInfo(){
        printPlayerStatus();
        System.out.println();
        printPlayerInventory();
    }
}
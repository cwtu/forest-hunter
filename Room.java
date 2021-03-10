import java.util.Random;
import java.util.ArrayList;

public class Room extends Space{
    private String description;
    private ArrayList<Item> storage = new ArrayList<>();

    Random ran = new Random();

    public Room(int x, int y, String description){
        super(x, y);
        this.description = description;

        for(Food f: Food.values()){
            int n = ran.nextInt(2);

            for(int i = 0 ; i < n ; i ++){
                storage.add(f);
            }
        }
    }

    public Item getItem(Item i) throws NoSuchItemException {
        if(i == OtherItem.MAP && !player.haveItem(OtherItem.KEY)){
            throw new NoSuchItemException("You need a key to get the Map.");
        }
        else if(!storage.remove(i)){
            throw new NoSuchItemException("No " + i.getName());
        }
        else{
            return i;
        }
    }

    public void printStorage(){
        System.out.println(getDescription() + " Storage:");
        System.out.println("--------------------");
        for(Item i : storage){
            System.out.println(i.getName());
        }
        System.out.println("--------------------");
    }

    public String getDescription(){
        return description;
    }

    public void addItem(Item i){
        storage.add(i);
    }

}

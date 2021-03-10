public class Space {
    private int positionX;
    private int positionY;

    protected Player player;
    protected Enemy enemy;

    public Space(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    public void characterEnter(Character c){
        if(c instanceof Player){
            this.player = (Player)c;
        }
        else{
            this.enemy = (Enemy)c;
        }
    }
    public void characterExit(Character c){
        if(c instanceof Player){
            this.player = null;
        }
        else{
            this.enemy = null;
        }
    }
    public Item getItem(Item i) throws NoSuchItemException{
        throw new NoSuchItemException("No " + i.getName());
    }

    public String getDescription(){
        return "You are surrounded by trees.";
    }

    public void addItem(Item i){
        System.out.println("Cannot add");
    }

    public void printStorage(){
        System.out.println("You are surrounded by trees.");
    }
}

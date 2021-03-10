public enum Food implements Item{
    WATER("Water", 4), APPLE("Apple", 10), CHOCOLATE("Chocolate", 30), MEAT("Meat", 60);

    private int foodHealthValue;
    private String name;

    private Food(String name, int value){
        this.name = name;
        foodHealthValue = value;
    }
    
    public String getName(){
        return name;
    }

    public int getFoodHealthValue(){
        return foodHealthValue;
    }
}
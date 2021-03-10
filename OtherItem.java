public enum OtherItem implements Item{
    KEY("Key"), MAP("Map");

    private String name;

    private OtherItem(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
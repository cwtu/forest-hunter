public class Map{

    private Space[][] mapSpace = new Space[5][5];
    private String[][] mapString = new String[5][5];

    private Player player;
    private Enemy enemy;

    public Map(Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;

        for(int i = 0 ; i < 5 ; i ++){
            for(int j = 0 ; j < 5 ; j ++){
                mapSpace[i][j] = new Space(i, j);
            }
        }

        mapSpace[3][1] = new Room(3, 1, "School");
        mapSpace[2][2] = new Room(2, 2, "Junkyard");
        mapSpace[2][2].addItem(OtherItem.KEY);
        mapSpace[1][2] = new Room(1, 2, "Warehouse");
        mapSpace[1][3] = new Room(1, 3, "Hut");
        mapSpace[3][4] = new Room(3, 4, "Lighthouse");
        mapSpace[3][4].addItem(OtherItem.MAP);

        player.randomizePoistion();
        enemy.randomizePosition(player);
    }

    public void printMap(){
        if(player.haveItem(OtherItem.MAP)){
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    mapString[i][j] = "  ";
                }
            }
            mapString[3][1] = "Sc";
            mapString[2][2] = "JY";
            mapString[1][2] = "WH";
            mapString[1][3] = "Ht";
            mapString[3][4] = "LH";

            mapString[enemy.getPositionX()][enemy.getPositionY()] = "👹";
        }
        else{
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    mapString[i][j] = "##";
                }
            }
        }

        mapString[player.getPositionX()][player.getPositionY()] = "😁";

        System.out.println("+====+====+====+====+====+");
        System.out.println("| "+mapString[0][0]+" | "+mapString[0][1]+" | "+mapString[0][2]+" | "+mapString[0][3]+" | "+mapString[0][4]+" |");
        System.out.println("+====+====+====+====+====+");
        System.out.println("| "+mapString[1][0]+" | "+mapString[1][1]+" | "+mapString[1][2]+" | "+mapString[1][3]+" | "+mapString[1][4]+" |");
        System.out.println("+====+====+====+====+====+");
        System.out.println("| "+mapString[2][0]+" | "+mapString[2][1]+" | "+mapString[2][2]+" | "+mapString[2][3]+" | "+mapString[2][4]+" |");
        System.out.println("+====+====+====+====+====+");
        System.out.println("| "+mapString[3][0]+" | "+mapString[3][1]+" | "+mapString[3][2]+" | "+mapString[3][3]+" | "+mapString[3][4]+" |");
        System.out.println("+====+====+====+====+====+");
        System.out.println("| "+mapString[4][0]+" | "+mapString[4][1]+" | "+mapString[4][2]+" | "+mapString[4][3]+" | "+mapString[4][4]+" |");
        System.out.println("+====+====+====+====+====+");

        System.out.println("Sc: School");
        System.out.println("JY: Junkyard");
        System.out.println("WH: Warehouse");
        System.out.println("Ht: Hut");
        System.out.println("LH: Lighthouse");
    }

    public Space getSpace(int x, int y){
        return mapSpace[x][y];
    }

    public void getPlayerLocationDescription(Player p){
        System.out.println(getSpace(p.getPositionX(), p.getPositionY()).getDescription());
    }
}

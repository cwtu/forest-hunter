import java.util.Random;
public class Enemy extends Character{

    Random ran = new Random();

    public Enemy(){
        super(500, 30);
    }

    public void randomizePosition(Player player){
        positionX = ran.nextInt(5);
        positionY = ran.nextInt(5);
        while(true){
            if(positionX == player.getPositionX() && positionY == player.getPositionY()){
                positionX = ran.nextInt(5);
                positionY = ran.nextInt(5);
            }
            else if(positionX == 3 && positionY == 1){
                positionX = ran.nextInt(5);
                positionY = ran.nextInt(5);
            }
            else if(positionX == 2 && positionY == 2){
                positionX = ran.nextInt(5);
                positionY = ran.nextInt(5);
            }
            else if(positionX == 1 && positionY == 2){
                positionX = ran.nextInt(5);
                positionY = ran.nextInt(5);
            }
            else if(positionX == 1 && positionY == 3){
                positionX = ran.nextInt(5);
                positionY = ran.nextInt(5);
            }
            else if(positionX == 3 && positionY == 4){
                positionX = ran.nextInt(5);
                positionY = ran.nextInt(5);
            }
            else{
                break;
            }
        }
    }
}

public abstract class Character {
    protected int healthValue;
    protected int attackValue;
    protected int positionX;
    protected int positionY;

    public Character(int healthValue, int attackValue){
        this.healthValue = healthValue;
        this.attackValue = attackValue;
    }

    public void attack(Character c){
        c.healthValue -= this.attackValue;
    }

    public int getPositionX(){
        return positionX;
    }
    public int getPositionY(){
        return positionY;
    }
    public int getHealthValue(){
        return healthValue;
    }
    public int getAttackValue(){
        return attackValue;
    }
}
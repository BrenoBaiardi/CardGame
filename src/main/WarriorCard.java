package main;

public class WarriorCard extends Card {

    private int power;
    private int life;


    public WarriorCard(String name, String color, int power, int life){
        this.life = life;
        this.power = power;
        this.name = name;
        this.color = color;
        this.type = "warrior";
    }

    public int getPower() {
        return power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    public int getLife() {
        return life;
    }

    private void setLife(int life) {
        this.life = life;
    }


}

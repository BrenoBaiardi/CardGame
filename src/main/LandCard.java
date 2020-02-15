package main;

public class LandCard extends Card{



    public LandCard(String name, String color, String owner){
        this.owner = owner;
        this.name = name;
        this.color = color;
        this.type = "land";
    }


}

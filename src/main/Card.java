package main;

public class Card{

    protected String name = null;
    protected String color = null;
    protected String type = null;
    protected String effect = null;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getEffect() {
        return effect;
    }


    @Override
    public String toString() {
        return "main.Card{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }
}

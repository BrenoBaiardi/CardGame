package main;

public abstract class Card{

    //TODO create Card TestClass
    // maybe not needed, no behavior to check
    // only getters and setter until now

    public String owner;
    protected String name = null;
    protected String color = null;
    protected String type = null;
    protected String effect = null;

    public String getName() {
        if (name == null){
            return "NONE";
        }
        else {
            return name;
        }
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
                ", owner='" + owner + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }
}

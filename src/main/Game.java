package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

    public Player p1;
    public Player p2;
    public int turnCounter=1;
    Map<String, ArrayList<Card>> field = new HashMap<String, ArrayList<Card>>();
    //TODO create field color weight

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        p1.drawCard(5);
        this.p2 = p2;
        p2.drawCard(5);

        //has to be pointed directly in order to be updated when player fields are
        field.put(p1.getName(),p1.field);
        field.put(p2.getName(),p2.field);

        p1.beginTurn();
    }

    public void nextTurn(){
        if (p1.isPlaying()){
            p1.endTurn();
            p2.beginTurn();
        }
        else if (p2.isPlaying()){
            p2.endTurn();
            p1.beginTurn();
        }
        else{
            //TODO Create Turn Exception and replace SysOutPrint
            System.out.println("Error while passing turn");
        }
        turnCounter+=1;
    }

    @Override
    public String toString() {
        return "\n#-#-main.Game Status-#-#\n" +
                "\nPlayer1=" + p1.getName() +
                "\nplaying=" + p1.isPlaying() +
                "\n\nPlayer2=" + p2.getName() +
                "\nplaying=" + p2.isPlaying() +
                "\n\nTurn Nº => " + turnCounter;
    }

    public void printField(){
        System.out.println("Field list In main.Game:\n");
        System.out.println(p1.getName()+" cards:");
        for (int i = 0; i < this.field.get(p1.getName()).size(); i++) {
            System.out.println(this.field.get(p1.getName()).get(i));
        }
        System.out.println(p2.getName()+" cards:");
        for (int i = 0; i < this.field.get(p2.getName()).size(); i++) {
            System.out.println(this.field.get(p2.getName()).get(i));
        }
    }
}

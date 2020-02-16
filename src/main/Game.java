package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

    //TODO crate Game TestClass

    public Arena arena;
    public Player p1;
    public Player p2;
    public int turnCounter=1;
    Map<String, ArrayList<Card>> field = new HashMap<String, ArrayList<Card>>();
    /*TODO create field color weight
       this will wait until later
       first i need to specify the data structure
     */

    public Game(Player p1, Player p2) {
        arena = new Arena();
        this.p1 = p1;
        p1.drawCard(5);
        this.p2 = p2;
        p2.drawCard(5);

        //has to be pointed directly in order to be updated when player fields are

        field.put(p1.getName(),p1.field);
        field.put(p2.getName(),p2.field);

        p1.beginTurn();
    }

    public void nextTurn() throws TurnException {
        if (p1.isPlaying()){
            p1.endTurn();
            p2.beginTurn();
        }
        else if (p2.isPlaying()){
            p2.endTurn();
            p1.beginTurn();
        }
        else{
            throw new TurnException("Error while Switching turn");
        }
        turnCounter+=1;
    }

    @Override
    public String toString() {
        return "\n\n#-#-main.Game Status-#-#\n" +
                "\nPlayer1=" + p1.getName() +
                "\nplaying=" + p1.isPlaying() +
                "\nPlayer2=" + p2.getName() +
                "\nplaying=" + p2.isPlaying() +
                "\nTurn Nº => " + turnCounter;
    }

    public void printField(){
        System.out.println("\n*******\nField list In main.Game:\n");
        System.out.println(p1.getName()+" cards:");
        for (int i = 0; i < this.field.get(p1.getName()).size(); i++) {
            System.out.println(this.field.get(p1.getName()).get(i));
        }
        System.out.println(p2.getName()+" cards:");
        for (int i = 0; i < this.field.get(p2.getName()).size(); i++) {
            System.out.println(this.field.get(p2.getName()).get(i));
        }
    }

    public void putUsedCardInArena(Card usedCard,int r,int c){
        arena.addCard(usedCard,r,c);
    }
}
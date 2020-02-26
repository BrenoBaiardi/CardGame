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
    /*TODO create Arena color weight
       this will wait until later
       first i need to specify the data structure
     */

    public Game(Player p1, Player p2) {
        arena = new Arena();
        this.p1 = p1;
        p1.drawCard(5);
        this.p2 = p2;
        p2.drawCard(5);

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

    public void printArena(){
        System.out.println("\n*******\nArena Status:\n");
        System.out.println(arena);
    }

    public void putUsedCardInArena(Card usedCard,int r,int c){
        arena.addCard(usedCard,r,c);
    }
}
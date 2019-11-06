package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Arena {

    //TODO think better about how to do this
    //ArrayList<Card> field = new ArrayList<Card>();
    ArenaCell[][] arena = new ArenaCell[4][4];

    public Arena(){
        for (int row = 0; row < arena.length; row++) {
            for (int column = 0; column < arena[0].length; column++) {
                arena[row][column] = new ArenaCell();
            }
        }
    }

    public void addCard(Card card,int x, int y) {
        this.arena[x][y].placeCard(card);
    }

    public String getCard(int x, int y){
        return arena[x][y].checkCard();
    }

    @Override
    public String toString() {
        String output="";
        for (int row = 0; row < arena.length; row++) {
            for (int column = 0; column < arena[0].length; column++) {
                output += arena[row][column].toString();
            }
            output += "\n";
        }

        return "Arena:\n" + output;
    }
}


package main;

import java.util.ArrayList;

public class Arena {

    //TODO think better about how to do this
    //ArrayList<Card> field = new ArrayList<Card>();
    ArenaCell[][] arena = new ArenaCell[4][4];

    public void Arena(){
        for (int row = 0; row < arena.length; row++) {
            for (int column = 0; column < arena[0].length; column++) {
                arena[row][column] = new ArenaCell();
            }
        }
    }

    public void addCard(Card card,int x, int y) {
        System.out.println(this.arena[0][0]);
        this.arena[x][y].placeCard(card);
    }

    public String getCard(int x, int y){
        return arena[x][y].checkCard();
    }
}


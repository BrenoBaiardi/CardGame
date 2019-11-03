package main;

import java.util.ArrayList;

public class Arena {

    //TODO think better about how to do this
    ArrayList<Card> field = new ArrayList<Card>();
    Card[][] arena = new Card[4][4];


    public void addCard(Card card,int x, int y){
        this.arena[x][y] = card;
    }

    public String getCard(int x, int y){
        return arena[x][y].name;
    }
}


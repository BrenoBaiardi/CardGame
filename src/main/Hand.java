package main;

import java.util.ArrayList;

public class Hand {

    //TODO crate Hand TestClass

    ArrayList<Card> cards = new ArrayList<Card>();

    public int getSize() {
        return cards.size();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card removeCard(String name){
        Card card = findCard(name);
        cards.remove(findCard(name)); //gets the index of the name and removes the item
        return card;
    }

    private Card findCard(String name){
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i).name.equals(name)){
                return this.cards.get(i);
            }
            else continue;
        }
        //TODO create proper CardNotFoundException
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        String output = "Cards in hand";
        for (int i = 0; i < cards.size(); i++) {
            output = output+"\n"+cards.get(i);
        }
        return output;
    }
}

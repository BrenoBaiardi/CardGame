package main;

import java.util.ArrayList;

public class Hand {

    //TODO create Hand TestClass
    // maybe not needed
    // validations throughout PlayerTest Class

    public ArrayList<Card> cards = new ArrayList<Card>();

    public int getSize() {
        return cards.size();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card removeCard(String name) throws CardNotFoundException {
        Card card = findCard(name);
        cards.remove(findCard(name)); //gets the index of the name and removes the item
        return card;
    }

    public Card removeCard(int index) throws CardNotFoundException {
        Card card = findCard(index);
        cards.remove(index); //removes Bys using the index position in hand
        return card;
    }

    private Card findCard(String name) throws CardNotFoundException {
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i).name.equals(name)){
                return this.cards.get(i);
            }
            else continue;
        }
        throw new CardNotFoundException("Card could not be found in Hand");
    }

    private Card findCard(int index) throws CardNotFoundException {
            if (0 <= index && index < this.cards.size()){
                return this.cards.get(index);
            }
            else throw new CardNotFoundException("Card could not be found in Hand");
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

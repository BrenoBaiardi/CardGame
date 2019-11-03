package main;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    String name;
    private ArrayList<Card> deck = new ArrayList<Card>();

    int size;

    public Deck(String name, ArrayList<Card> deck) {
        this.name = name; //maybe not needed
        this.deck = deck;
        this.size = deck.size();
        Collections.shuffle(this.deck);
    }

    @Override
    public String toString() {
        String output="";
        output += "Deck name = " + name +"\n";
        for (int i = 0; i < deck.size();i++) {
            output += deck.get(i);
        }
        return output;
    }

    public void shuffleCards(){
        Collections.shuffle(this.deck);
    }

    public int getSize() {
        return size;
    }

    public Card draw(){
        //the draw is made from the end to gain more performance
        //Drawing from the top is more frequent than the bottom
        if(deck.size()>=1){
            Card draw = deck.get(deck.size() - 1);
            deck.remove(deck.size() - 1);
            this.size = deck.size();
            return draw;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }
    public Card drawChosenCard(String name) throws CardNotFoundException {
        Card card = findCard(name);
        deck.remove(findCard(name)); //gets the index of the name and removes the item
        return card;
    }

    public void addCardOnTop(Card card){
        this.deck.add(card);
    }
    public void addCardOnBottom(Card card){
        this.deck.add(0,card);
    }

    private Card findCard(String name) throws CardNotFoundException {
        for (int i = 0; i < this.deck.size(); i++) {
            if (this.deck.get(i).name.equals(name)){
                return this.deck.get(i);
            }
            else continue;
        }
        throw new CardNotFoundException("Could not find card in deck");
    }
}

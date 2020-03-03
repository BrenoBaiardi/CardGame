package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck<Card> implements Iterable<Card>{

    String name;
    private ArrayList<Card> deck = new ArrayList<Card>();
    Deck<Card> head, tail;
    int size;
    Card data;
    Deck<Card> next;

    public Deck(String name, ArrayList<Card> deck) {
        this.name = name; //maybe not needed
        this.deck = deck;
        this.size = deck.size();
        Collections.shuffle(this.deck);
    }

    // return Head
    public Deck<Card> getHead()
    {
        return head;
    }

    // return Tail
    public Deck<Card> getTail()
    {
        return tail;
    }

    public Card getData()
    {
        return data;
    }

    public Deck<Card> getNext()
    {
        return next;
    }

    // return Iterator instance
    public Iterator<Card> iterator()
    {
        return new DeckIterator<Card>(this);
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
        for (Card card : this.deck){
            if card.
        }
        throw new CardNotFoundException("Could not find card in deck: " + name);
    }
}

class DeckIterator<Card> implements Iterator<Card> {
    Deck<Card> current;

    // initialize pointer to head of the list for iteration
    public DeckIterator(Deck<Card> list)
    {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current data and update pointer
    public Card next()
    {
        Card card = current.getData();
        current = current.getNext();
        return card;
    }

    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}


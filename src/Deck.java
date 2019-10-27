import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    String name;
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(String name, ArrayList<Card> deck) {
        this.name = name;
        this.deck = deck;
        Collections.shuffle(this.deck);
    }

    @Override
    public String toString() {
        return "Deck name=" + name;
    }

    public void shuffleCards(){
        Collections.shuffle(this.deck);
    }

    public Card draw(){
        Card draw = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return draw;
    }
    public void drawChosenCard(){
        //TODO draw chosen card: by String or Card
    }
    public void addCardOnTop(Card card){
        //TODO add on top
    }
    public void addCardOnBottom(Card card){
        //TODO add on bottom
    }
}

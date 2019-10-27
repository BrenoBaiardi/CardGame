import java.util.ArrayList;

public class Hand {

    ArrayList<Card> cards = new ArrayList<Card>();

    public int getSize() {
        return cards.size();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void removeCard(Card card){
        cards.remove(card);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < cards.size(); i++) {
            output = output+"\n"+cards.get(i);
        }
        return output;
    }
}

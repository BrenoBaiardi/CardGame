import main.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class DeckTest {

    ArrayList<Card> cards_list = new ArrayList<Card>();
    Deck deck;
    Card war_card = new WarriorCard("test Warrior", "red", 2, 2, "any");
    Card land_card = new LandCard("test Land", "green", "any");


    @Before
    public void setUp(){

        //creating sample card List
        for(int i = 0; i < 10; i++){
            if (i%2==0) {
                cards_list.add(new WarriorCard("War"+Integer.toString(i+1), "red", 2, 2, "any"));
            }
            else{
                cards_list.add(new LandCard("Land"+Integer.toString(i+1), "blue", "any"));
            }
        }
        deck = new Deck("test_deck",this.cards_list);
    }

    @Test
    public void testDeckCreation(){
        Assert.assertEquals("Deck name = test_deck", deck.toString().split("\n")[0]);
    }

    @Test
    public void testAddOnTop(){
        deck.addCardOnTop(war_card);
        Assert.assertEquals("test Warrior", deck.draw().getName());
    }

    @Test
    public void testDraw(){
        deck.addCardOnTop(war_card);
        Card drawn_card = deck.draw();
        Assert.assertEquals(drawn_card, war_card);
    }

    @Test
    public void testAddOnBottom(){
        deck.addCardOnBottom(land_card);
        Card last_drawn_card=null;
        while(deck.getSize()>0){
            last_drawn_card = deck.draw();
        }
        Assert.assertEquals("test Land", last_drawn_card.getName());
    }

    @Test
    public void testDrawChosenCard() {
        deck.addCardOnBottom(land_card);
        Card drawn_card = null;
        try {
            drawn_card = deck.drawChosenCard("test Land");
        } catch (CardNotFoundException e) {
            Assert.fail("e");
        }
        Assert.assertEquals(drawn_card, land_card);
    }

    @Test (expected = CardNotFoundException.class)
    public void testDrawCardNotInDeck() throws CardNotFoundException {
        Card drawn_card = deck.drawChosenCard("Card-not-in-deck");
    }
}

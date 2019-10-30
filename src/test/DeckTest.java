import jdk.nashorn.internal.ir.WhileNode;
import main.Card;
import main.Deck;
import main.LandCard;
import main.WarriorCard;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class DeckTest {

    ArrayList<Card> cards_list = new ArrayList<Card>();
    Deck deck;
    Card war_card = new WarriorCard("test Warrior", "red", 2, 2);
    Card land_card = new LandCard("test Land", "green");


    @Before
    public void setUp(){

        //creating sample card List
        for(int i = 0; i < 10; i++){
            if (i%2==0) {
                cards_list.add(new WarriorCard("War"+Integer.toString(i+1), "red", 2, 2));
            }
            else{
                cards_list.add(new LandCard("Land"+Integer.toString(i+1), "blue"));
            }
        }
        deck = new Deck("test_deck",this.cards_list);
    }

    @Test
    public void checkTestCreation(){
        Assert.assertEquals("Deck name = test_deck", deck.toString().split("\n")[0]);
    }

    @Test
    public void checkAddOnTop(){
        deck.addCardOnTop(war_card);
        Assert.assertEquals("test Warrior", deck.draw().getName());
    }

    @Test
    public void checkDraw(){
        deck.addCardOnTop(war_card);
        Card drawn_card = deck.draw();
        Assert.assertEquals(drawn_card, war_card);
    }

    @Test
    public void checkAddOnBottom(){
        deck.addCardOnBottom(land_card);
        Card last_drawn_card=null;
        while(deck.getSize()>0){
            last_drawn_card = deck.draw();
        }
        Assert.assertEquals("test Land", last_drawn_card.getName());
    }

    @Test
    public void checkDrawChosenCard(){
        deck.addCardOnBottom(land_card);
        Card drawn_card = deck.drawChosenCard("test Land");
        Assert.assertEquals(drawn_card, land_card);
    }
}

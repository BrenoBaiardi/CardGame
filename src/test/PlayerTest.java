import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {

    ArrayList<Card> cards_list = new ArrayList<Card>();
    Deck deck;
    Player play1;
    Card card;

    @Before
    public void setUp() throws Exception {

        //creating sample card List
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                cards_list.add(new WarriorCard("War" + Integer.toString(i + 1), "red", 2, 2));
            } else {
                cards_list.add(new LandCard("Land" + Integer.toString(i + 1), "blue"));
            }
        }

        deck = new Deck("player_deck", this.cards_list);
        this.play1 = new Player("P1", deck);
        card = null;
    }


    @Test
    public void testPlayerconstructor() {
        /*Hand must not be created when  new() used
        must only be instanciated when the Game begins
        because the player can have a infinite number of games
        the hand is created by game
        * */
        Assert.assertNull(this.play1.hand);
        Assert.assertEquals(0,play1.field.size());
        Assert.assertEquals(0,play1.dead_zone.size());
    }

    @Test
    public void testDrawIntoHand() {
        this.play1.drawCard(1);
        Assert.assertEquals(1,this.play1.hand.getSize());
    }

    @Test
    public void testUseCard() {
        try {
            this.play1.drawChosenCard("Land2");
            this.play1.drawChosenCard("War3");
            this.play1.drawChosenCard("Land4");
            this.play1.drawChosenCard("Land6");
        } catch (CardNotFoundException e) {
            Assert.fail("e");
        }

        Assert.assertEquals(4,play1.hand.getSize());
        try {
            this.play1.useCard("War3");
        } catch (CardNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(3,play1.hand.getSize());
        Assert.assertEquals(1,this.play1.field.size());
        
    }

    @Test
    public void testUseCardIntoField() {
        try {
            this.play1.drawChosenCard("Land2");
            this.play1.drawChosenCard("War3");
            this.play1.drawChosenCard("Land4");
            this.play1.drawChosenCard("War5");
            this.play1.drawChosenCard("Land6");
            this.play1.drawChosenCard("War7");
        } catch (CardNotFoundException e) {
            Assert.fail();
        }

        try {
            this.play1.useCard("War3");
        } catch (CardNotFoundException e) {
            Assert.fail("e");
        }
        Assert.assertEquals("War3",this.play1.field.get(0).getName());
    }

    @Test
    public void testDiscardIntoDeadZone() {

        try {
            this.play1.drawChosenCard("Land2");
            this.play1.drawChosenCard("War3");
        } catch (CardNotFoundException e) {
            Assert.fail("e");
        }

        try {
            this.play1.discardCard("War3");
        } catch (CardNotFoundException e) {
            Assert.fail("e");
        }
        Assert.assertEquals("War3",this.play1.dead_zone.get(0).getName());
    }

    @Test
    public void testBeginTurn() {
        this.play1.beginTurn();
        Assert.assertEquals(true,play1.isPlaying());
    }

    @Test
    public void testEndTurn() {
        this.play1.beginTurn();
        this.play1.endTurn();
        Assert.assertEquals(false,play1.isPlaying());
    }
}

import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArenaTest {

    Arena arena;
    Card war_card;
    Card land_card;

    @Before
    public void setUp(){
        this.arena = new Arena();
        this.war_card = new WarriorCard("Warrior0","red",2,2, "any");
        this.land_card = new LandCard("Land0","green", "any");
    }

    @Test
    public void testArenaRowSizeCreation(){
        Assert.assertEquals(5,this.arena.rows_size);
    }

    @Test
    public void testArenaColumnSizeCreation(){
        Assert.assertEquals(5,this.arena.columns_size);
    }

    @Test
    public void testCellInstanceInArena(){
        for (int i = 0; i < this.arena.rows_size; i++) {
            for (int j = 0; j < this.arena.columns_size; j++) {
                if (this.arena.arena[i][j][1] != null &&
                        this.arena.arena[i][j][1] != null) {
                    continue; // explicit better than implicit
                }
                else{
                    Assert.fail("Non ArenaCell Object found in index: "+ i +","+ j);
                }
            }
        }
        //if no fail is identified the test passes
        Assert.assertTrue(true);
    }

    @Test
    public void testAddCardIntoArena() {
        this.arena.addCard(this.war_card,0,0);
    }

    @Test(expected = CardNotFoundException.class)
    public void testCheckEmptyField() throws CardNotFoundException {
        arena.checkCardInField("Land0");
    }

    @Test
    public void checkLandInField() throws CardNotFoundException {
        this.arena.addCard(this.land_card,0,1);
        ArenaCell position = arena.checkCardInField("Land0");
        Assert.assertTrue(position.getRow() == 0 && position.getColumn() == 1);
    }

    @Test
    public void checkWarriorInField() throws CardNotFoundException {
        this.arena.addCard(this.war_card,1,0);
        ArenaCell position = arena.checkCardInField("Warrior0");
        Assert.assertTrue(position.getRow() == 1 && position.getColumn() == 0);
    }
}
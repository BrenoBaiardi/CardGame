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
                if (this.arena.arenaWarriors[i][j] != null &&
                        this.arena.arenaWarriors[i][j] != null) {
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

    @Test
    public void testCheckEmptyField() {
        Assert.assertEquals("R-0 C-0 Empty Land + No warrior",this.arena.checkField(0,0));
    }

    //TODO to be replaced with the test below
    @Test
    public void testCheckLand() {
        this.arena.addCard(this.land_card,0,1);
        Assert.assertEquals("R-0 C-1 Land0 + No warrior",this.arena.checkField(0,1));
    }

    @Test
    public void checkLandInField(){
        Assert.fail("Not implemented");
    }

    //TODO to be replaced with the test below
    @Test
    public void testCheckWarrior() {
        this.arena.addCard(this.war_card,1,0);
        Assert.assertEquals("R-1 C-0 Empty Land + Warrior0",this.arena.checkField(1,0));
    }

    @Test
    public void checkWarriorInField(){
        Assert.fail("Not implemented");
    }
}
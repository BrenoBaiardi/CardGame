import main.Arena;
import main.ArenaCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArenaTest {

    Arena arena;

    @Before
    public void setUp(){
        this.arena = new Arena();
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
    public void testCellAssociationInArena(){
        for (int i = 0; i < this.arena.rows_size; i++) {
            for (int j = 0; j < this.arena.columns_size; j++) {
                if (this.arena.arenaWarriors[i][j] instanceof ArenaCell &&
                        this.arena.arenaWarriors[i][j] instanceof ArenaCell) {
                    continue;
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
        //TODO implement Test
    }

    @Test
    public void testCheckField() {
        //TODO implement Test
    }

    @Test
    public void testCheckLand() {
        //TODO implement Test
    }


    @Test
    public void testCheckWarrior() {
        //TODO implement Test
    }

}
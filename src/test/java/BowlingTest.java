import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 10/9/2017.
 */
public class BowlingTest {


    private Bowling g;

    @Before
    public void setUp() throws Exception {
        g = new Bowling();
    }

    @Test
    public void gutterGame() throws Exception {
        for (int i=0; i<20; i++) {
            g.roll(0);
        }
        assertEquals(0, g.score());
    }

    @Test
    public void onePointGame() throws Exception {
        g.roll(1);
        for (int i=0; i<19; i++) {
            g.roll(0);
        }
        assertEquals(1, g.score());
    }
}

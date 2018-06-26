import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/27/2018.
 */
public class FrogRiverOneTest {

    @Test
    public void oneDistanceHasSolution() throws Exception {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        assertEquals(0, frogRiverOne.solution(1, new int[]{1}));
    }

    @Test
    public void oneDistanceNoSolution() throws Exception {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        assertEquals(-1, frogRiverOne.solution(1, new int[]{0}));
    }

    @Test
    public void twoDistanceTwoLeaps() throws Exception {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        assertEquals(3, frogRiverOne.solution(2, new int[]{1, 1, 1, 2}));
    }

    @Test
    public void twoDistanceNoSolution() throws Exception {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        assertEquals(-1, frogRiverOne.solution(2, new int[]{0, 0, 0, 2}));
    }

    @Test
    public void twoDistanceManyLeaps() throws Exception {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        assertEquals(2, frogRiverOne.solution(2, new int[]{0, 2, 1, 2}));
    }

    @Test
    public void threeDistanceManyLeaps() throws Exception {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        assertEquals(2, frogRiverOne.solution(2, new int[]{0, 2, 1, 2}));
    }
    @Test
    public void fiveDistanceManyLeaps() throws Exception {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        assertEquals(6, frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }


}

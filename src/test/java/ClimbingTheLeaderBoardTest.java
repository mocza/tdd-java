import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 5/13/2018.
 */
public class ClimbingTheLeaderBoardTest {

    @Test
    public void test1() throws Exception {
        assertArrayEquals(new int[] {6, 4, 2, 1}, ClimbingTheLeaderBoard.climbingLeaderboard2(new int[] {100, 100, 50, 40, 40, 20, 10}, new int[] {5, 25, 50, 120}));

    }
}

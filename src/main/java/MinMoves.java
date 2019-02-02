import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 10/21/2018.
 */
public class MinMoves {


    public static int minimumMoves(List<Integer> a, List<Integer> m) {
        int moveCount = 0;
        for(int i = 0; i < a.size(); i++) {
            String[] andrea = String.valueOf(a.get(i)).split("");
            String[] maria = String.valueOf(m.get(i)).split("");
            for(int j=0; j < andrea.length; j++) {
               moveCount += Math.abs(Integer.valueOf(andrea[j]) - Integer.valueOf(maria[j]));
            }
        }
        return moveCount;
    }


    @Test
    public void t1() {
        assertEquals(16, minimumMoves(Arrays.asList(123, 543), Arrays.asList(321, 279)));
    }

    @Test
    public void t2() {
        assertEquals(10, minimumMoves(Arrays.asList(1234, 4321), Arrays.asList(2345, 3214)));
    }

}

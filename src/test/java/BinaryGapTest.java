import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/23/2018.
 */
public class BinaryGapTest {


    @Test
    public void oneDigit() throws Exception {
        BinaryGap binaryGap = new BinaryGap();
        assertEquals(0, binaryGap.solution(0));
    }

    @Test
    public void twoDigit() throws Exception {
        BinaryGap binaryGap = new BinaryGap();
        assertEquals(0, binaryGap.solution(3));
    }

    @Test
    public void threeDigitOneGap() throws Exception {
        BinaryGap binaryGap = new BinaryGap();
        assertEquals(1, binaryGap.solution(5));
    }

    @Test
    public void trailingZero() throws Exception {
        BinaryGap binaryGap = new BinaryGap();
        assertEquals(0, binaryGap.solution(6));
    }


    @Test
    public void threeDigitZeroGap() throws Exception {
        BinaryGap binaryGap = new BinaryGap();
        assertEquals(0, binaryGap.solution(7));
    }

    @Test
    public void gap2() throws Exception {
        BinaryGap binaryGap = new BinaryGap();
        assertEquals(2, binaryGap.solution(9));
    }

    @Test
    public void negativeNumber() throws Exception {
        BinaryGap binaryGap = new BinaryGap();
        assertEquals(0, binaryGap.solution(-9));
    }


}

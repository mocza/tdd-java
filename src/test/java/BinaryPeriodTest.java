import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/28/2018.
 */
public class BinaryPeriodTest {

    @Test
    public void sample1() throws Exception {
        BinaryPeriod binaryPeriod = new BinaryPeriod();
        assertEquals(4, binaryPeriod.solution(955));
    }

    @Test
    public void periodLengthOne() throws Exception {
        BinaryPeriod binaryPeriod = new BinaryPeriod();
        assertEquals(1, binaryPeriod.solution(3));
    }

    @Test
    public void periodLengthTwo() throws Exception {
        BinaryPeriod binaryPeriod = new BinaryPeriod();
        assertEquals(2, binaryPeriod.solution(5));
    }

    @Test
    public void periodLengthThree() throws Exception {
        BinaryPeriod binaryPeriod = new BinaryPeriod();
        assertEquals(3, binaryPeriod.solution(27));
    }

    @Test
    public void periodLength() throws Exception {
        BinaryPeriod binaryPeriod = new BinaryPeriod();
        assertEquals(3, binaryPeriod.solution(59));
    }

    @Test
    public void noPeriodCase1() throws Exception {
        BinaryPeriod binaryPeriod = new BinaryPeriod();
        assertEquals(-1, binaryPeriod.solution(0));
    }

    @Test
    public void noPeriodCase2() throws Exception {
        BinaryPeriod binaryPeriod = new BinaryPeriod();
        assertEquals(-1, binaryPeriod.solution(1));
    }

}

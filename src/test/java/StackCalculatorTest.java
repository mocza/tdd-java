import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/28/2018.
 */
public class StackCalculatorTest {

    @Test
    public void example1() throws Exception {
        StackCalculator stackCalculator = new StackCalculator();
        assertEquals(7, stackCalculator.solution("13 DUP 4 POP 5 DUP + DUP + -"));
    }

    @Test
    public void example2() throws Exception {
        StackCalculator stackCalculator = new StackCalculator();
        assertEquals(-1, stackCalculator.solution("5 6 + -"));
    }
}

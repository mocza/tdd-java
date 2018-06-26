import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 5/13/2018.
 */
public class BalancedParensTest {

    @Test
    public void balancedOneParens() throws Exception {
        assertArrayEquals(Arrays.asList(true).toArray(), BalancedParens.isBalancedParens(Arrays.asList("{}")).toArray());
    }

    @Test
    public void unbalancedOneParens() throws Exception {
        assertArrayEquals(Arrays.asList(false).toArray(), BalancedParens.isBalancedParens(Arrays.asList("{")).toArray());
    }

    @Test
    public void unbalancedOneParensMismatch() throws Exception {
        assertArrayEquals(Arrays.asList(false).toArray(), BalancedParens.isBalancedParens(Arrays.asList("{]")).toArray());
    }

    @Test
    public void unbalancedOneParensClosedBeforeOpen() throws Exception {
        assertArrayEquals(Arrays.asList(false).toArray(), BalancedParens.isBalancedParens(Arrays.asList("][")).toArray());
    }

    @Test
    public void balancedTwoParens() throws Exception {
        assertArrayEquals(Arrays.asList(true).toArray(), BalancedParens.isBalancedParens(Arrays.asList("[{]}")).toArray());
    }


}

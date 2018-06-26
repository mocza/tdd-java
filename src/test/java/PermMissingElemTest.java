import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/24/2018.
 */
public class PermMissingElemTest {

    @Test
    public void zeroSizeArray() throws Exception {
        PermMissingElem permMissingElem = new PermMissingElem();
        assertEquals(1, permMissingElem.solution(new int[]{}));
    }

    @Test
    public void oneSizeArray() throws Exception {
        PermMissingElem permMissingElem = new PermMissingElem();
        assertEquals(2, permMissingElem.solution(new int[]{1}));
    }

    @Test
    public void twoSizeArray() throws Exception {
        PermMissingElem permMissingElem = new PermMissingElem();
        assertEquals(3, permMissingElem.solution(new int[]{1, 2}));
    }

    @Test
    public void threeSizeArray() throws Exception {
        PermMissingElem permMissingElem = new PermMissingElem();
        assertEquals(1, permMissingElem.solution(new int[]{2, 4, 3}));
    }

}

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/26/2018.
 */
public class TriangleTest {

    @Test
    public void arrayOfTwo() throws Exception {
        Triangle triangle = new Triangle();
        assertEquals(0, triangle.solution(new int[]{1, 8 }, 2));
    }

    @Test
    public void arrayOfThreeNoTriagnles() throws Exception {
        Triangle triangle = new Triangle();
        assertEquals(0, triangle.solution(new int[]{1, 8 , 10}, 3));
    }

    @Test
    public void arrayOfThreeHasTriangle() throws Exception {
        Triangle triangle = new Triangle();
        assertEquals(1, triangle.solution(new int[]{5, 8 , 10}, 3));
    }

    @Test
    public void arrayOfThreeNegative() throws Exception {
        Triangle triangle = new Triangle();
        assertEquals(0, triangle.solution(new int[]{-5, -8 , -10}, 3));
    }

    @Test
    public void name() throws Exception {
        System.out.println(Arrays.asList("hello".split("")));

    }
}

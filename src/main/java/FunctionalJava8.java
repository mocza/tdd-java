import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 11/1/2018.
 */
public class FunctionalJava8 {

    @Test
    public void test1() {
        List<String> cities = Arrays.asList("London", "Bristol");
        cities.add("Debrecen");
        assertEquals(true, cities.contains("Bristol"));

    }


}

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 10/21/2018.
 */
public class FreqencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new LinkedList<>();
        Map<Integer, Integer> frequencies = new HashMap<>();
        Multimap<Integer, Integer> transposed = ArrayListMultimap.create();
        for (List<Integer> query : queries) {
            if (!query.isEmpty()) {
                Integer operation = query.get(0);
                Integer value = query.get(1);
                Integer freq = frequencies.get(value);
                switch (operation) {
                    case 1:
                        transposed.remove(freq, value);
                        transposed.put(freq == null ? 1 : freq + 1, value);
                        frequencies.compute(value, (k, v) ->(v == null) ? 1 : v + 1);
                        break;
                    case 2:
                        transposed.remove(freq, value);
                        if (freq != null && freq.compareTo(1) == 1) {
                            transposed.put(freq - 1, value);
                        }
                        frequencies.compute(value, (k, v) -> (v == null || v == 1) ? null : v - 1);
                        break;
                    case 3:
//                        output.add(frequencies.entrySet().stream().filter(e -> e.getValue() == value).findAny().isPresent() ? 1 : 0);
                        output.add(transposed.get(value).isEmpty() ? 0 : 1);
                        break;
                }
            }
        }
        return output;
    }

    @Test
    public void noOperation() {
        assertEquals(Arrays.asList(), freqQuery(Arrays.asList(Arrays.asList())));
    }

    @Test
    public void noneAddedNoneFound() {
        assertEquals(Arrays.asList(0), freqQuery(Arrays.asList(Arrays.asList(3,1))));
    }

    @Test
    public void oneAddedOneFound() {
        assertEquals(Arrays.asList(1), freqQuery(Arrays.asList(Arrays.asList(1,1), Arrays.asList(3,1))));
    }

    @Test
    public void oneAddedOneDeletedNoneFound() {
        assertEquals(Arrays.asList(0), freqQuery(Arrays.asList(Arrays.asList(1,1), Arrays.asList(2,1), Arrays.asList(3,1))));
    }

    @Test
    public void twoAddedTwoFound() {
        assertEquals(Arrays.asList(1), freqQuery(Arrays.asList(Arrays.asList(1,1), Arrays.asList(1,1), Arrays.asList(3,2))));
    }

    @Test
    public void twoAddedOneNotFound() {
        assertEquals(Arrays.asList(0), freqQuery(Arrays.asList(Arrays.asList(1,1), Arrays.asList(1,1), Arrays.asList(3,1))));
    }

}

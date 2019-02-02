import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 10/29/2018.
 */
public class SpecialPalindromeAgain {

    static long substrCount(int n, String s) {
        long count = 0;

        count += isPalSub(s) ? 1 : 0;

        while (n > 0) {
            n--;
            count = countSubStr(count, n, s);
        }

        return count;
    }

    static boolean isPalSub(String s) {
        if (s.isEmpty()) {
            return false;
        }
        String [] a = s.split("");
        long distinct = Arrays.stream(a).distinct().count();
        if (distinct == 1) {
            return true;
        } else if (distinct == 2 && a.length % 2 != 0) {
            int middle = (a.length + 1) / 2;
            Map<String, Integer> counts = new HashMap<>();
            for (String c : s.split("")) {
                counts.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }
            Integer min = counts.values().stream().sorted().findFirst().get();
            Optional<String> outstanding = counts.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst();
            if (outstanding.isPresent() && a[middle - 1].equals(outstanding.get())) {
                return true;
            }
        }
            return false;
    }

    static long countSubStr(long count, int n, String s) {
        String [] a = s.split("");
        for (int start = 0; start <= a.length - n; start++) {
            StringBuffer sb = new StringBuffer();
            for (int next = 0; next < n; next++) {
                sb.append(a[start + next]);
            }
            count += isPalSub(sb.toString()) ? 1 : 0;
        }
        return count;
    }

    @Test
    public void none() {
        assertEquals(0, substrCount(0, ""));
    }

    @Test
    public void one() {
        assertEquals(1, substrCount(1, "a"));
    }

    @Test
    public void twoOneAndTwoLength() {
        assertEquals(3, substrCount(2, "aa"));
    }

    @Test
    public void twoOneLength() {
        assertEquals(2, substrCount(2, "ab"));
    }

    @Test
    public void fourThreeOneLengthOneThreeLength() {
        assertEquals(4, substrCount(3, "aba"));
    }

    @Test
    public void sample1() {
        assertEquals(7, substrCount(5, "asasd"));
    }

    @Test
    public void sample2() {
        assertEquals(10, substrCount(7, "abcbaba"));
    }

}

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 10/21/2018.
 */
public class CommonChild {

    static String getShortString(String s, Set<String> chars) {
        return Arrays.stream(s.split("")).filter(c -> chars.contains(c)).collect(Collectors.joining());
    }

    static int findShorter(String findIn, String toFind, int removeFromToFindCount) {
        int foundAt = -1;
        if (removeFromToFindCount == 0) {
            return findIn.indexOf(toFind);
        } else if (removeFromToFindCount == 1) {
            for (int i = 0; i < toFind.length(); i++) {
                if (i == 0) {
                    foundAt = findIn.indexOf(toFind.substring(1));
                } else if (i == toFind.length() - 1) {
                    foundAt = findIn.indexOf(toFind.substring(0, toFind.length() - 2));
                } else {
                    foundAt = findIn.indexOf(toFind.substring(0, i) + toFind.substring(i + 1));
                }
                if (foundAt != -1) {
                    return foundAt;
                }
            }
        } else if (removeFromToFindCount == 2) {

        }
        return -1;
    }

    static int commonChild(String s1, String s2) {
        Set<String> firstUniqueChars = new HashSet<>(Arrays.asList(s1.split("")));
        Set<String> secondUniqueChars = new HashSet<>(Arrays.asList(s2.split("")));
        Set<String> bothUniqueChars = new HashSet<>(firstUniqueChars);
        bothUniqueChars.retainAll(secondUniqueChars);

        String short1 = getShortString(s1, bothUniqueChars);
        String short2 = getShortString(s2, bothUniqueChars);

        if (short2.length() > short1.length()) {
            for (int i = 0; i < short1.length(); i++) {
                int foundAt = findShorter(short2, short1, i);
                if (foundAt != -1) {
                    return short1.length() - i;
                }
            }
        } else {
            for (int i = 0; i < short2.length(); i++) {
                int foundAt = findShorter(short1, short2, i);
                if (foundAt != -1) {
                    return short2.length() - i;
                }
            }
        }

        return 0;
    }

    @Test
    public void noChild() {
        assertEquals(0, commonChild("A", "B"));
    }

    @Test
    public void oneLengthChildNoneRemoved() {
        assertEquals(1, commonChild("A", "A"));
    }

    @Test
    public void oneLengthChildOneRemovedFromOneSide() {
        assertEquals(1, commonChild("A", "AB"));
    }

    @Test
    public void oneLengthChildOneRemovedFromBothSides() {
        assertEquals(1, commonChild("AC", "AB"));
    }

    @Test
    public void oneLengthChildTwoRemovedFromOneSide() {
        assertEquals(1, commonChild("AA", "BCA"));
    }

    @Test
    public void oneLengthChildTwoRemovedFromBothSides() {
        assertEquals(1, commonChild("DAE", "BCA"));
    }

    @Test
    public void oneLengthChildTwoCommonChar() {
        assertEquals(1, commonChild("DBEA", "ABC"));
    }

    @Test
    public void twoLengthChildTwoCommonChar() {
        assertEquals(2, commonChild("DBEA", "ABCA"));
    }

    @Test
    public void threeLengthChild() {
        assertEquals(3, commonChild("SHINCHAN", "NOHARAAA"));
    }

}

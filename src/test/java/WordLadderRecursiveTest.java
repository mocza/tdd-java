import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/12/2018.
 */
public class WordLadderRecursiveTest {

    @Test
    public void emptyLadder() throws Exception {
        WordLadderRecursive ladder = new WordLadderRecursive();
        assertEquals(0,  ladder.ladderLength("hit", "dot", Arrays.asList("hot")));
    }

    @Test
    public void emptyLadder2() throws Exception {
        WordLadderRecursive ladder = new WordLadderRecursive();
        assertEquals(0,  ladder.ladderLength("hit", "dot", Arrays.asList()));
    }

    @Test
    public void oneStepLadder() throws Exception {
        WordLadderRecursive ladder = new WordLadderRecursive();
        assertEquals(1,  ladder.ladderLength("hit", "hot", Arrays.asList("hot")));
    }

    @Test
    public void twoStepLadder() throws Exception {
        WordLadderRecursive ladder = new WordLadderRecursive();
        assertEquals(2,  ladder.ladderLength("hit", "dot", Arrays.asList("hot", "dot")));
    }

    @Test
    public void twoStepLadder2Solutions() throws Exception {
        WordLadderRecursive ladder = new WordLadderRecursive();
        assertEquals(2,  ladder.ladderLength("hit", "dot", Arrays.asList("bit", "bot", "hot", "dot")));
    }

    @Test
    public void threeStepLadder() throws Exception {
        WordLadderRecursive ladder = new WordLadderRecursive();
        assertEquals(3,  ladder.ladderLength("hit", "dog", Arrays.asList("hot", "dot", "dog")));
    }

}

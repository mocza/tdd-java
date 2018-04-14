import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/12/2018.
 */
public class WorldLadderTreeTest {

    @Test
    public void emptyLadder() throws Exception {
        WordLadderRecursive ladder = new WordLadderRecursive();
        assertEquals(0,  ladder.ladderLength("hit", "dot", Arrays.asList("hot")));
    }

    @Test
    public void emptyLadder2() throws Exception {
        WordLadderTree ladder = new WordLadderTree();
        assertEquals(0,  ladder.ladderLength("hit", "dot", Arrays.asList()));
    }

    @Test
    public void oneStepLadder() throws Exception {
        WordLadderTree ladder = new WordLadderTree();
        assertEquals(1,  ladder.ladderLength("hit", "hot", Arrays.asList("hot")));
    }

    @Test
    public void oneStepLadderWithoutDictionary() throws Exception {
        WordLadderTree ladder = new WordLadderTree();
        assertEquals(0,  ladder.ladderLength("hit", "hot", Arrays.asList()));
    }

    @Test
    public void twoStepLadder() throws Exception {
        WordLadderTree ladder = new WordLadderTree();
        assertEquals(2,  ladder.ladderLength("hit", "dot", Arrays.asList("hot", "dot")));
    }

    @Test
    public void twoStepLadderTwoSolutions() throws Exception {
        WordLadderTree ladder = new WordLadderTree();
        assertEquals(2,  ladder.ladderLength("hit", "dot", Arrays.asList("bit", "bot", "hot", "dot")));
    }

    @Test
    public void threeStepLadder() throws Exception {
        WordLadderTree ladder = new WordLadderTree();
        assertEquals(3,  ladder.ladderLength("hit", "dog", Arrays.asList("hot", "dot", "dog")));
    }






}

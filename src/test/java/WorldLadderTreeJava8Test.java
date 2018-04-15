import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/12/2018.
 */
public class WorldLadderTreeJava8Test {

    @Test
    public void emptyLadder() throws Exception {
        WordLadderTreeJava8 ladder = new WordLadderTreeJava8();
        assertEquals(0,  ladder.ladderLength("hit", "dot", Arrays.asList("hot")));
    }

    @Test
    public void emptyLadder2() throws Exception {
        WordLadderTreeJava8 ladder = new WordLadderTreeJava8();
        assertEquals(0,  ladder.ladderLength("hit", "dot", Arrays.asList()));
    }

    @Test
    public void oneStepLadder() throws Exception {
        WordLadderTreeJava8 ladder = new WordLadderTreeJava8();
        assertEquals(1,  ladder.ladderLength("hit", "hot", Arrays.asList("hot")));
    }

    @Test
    public void oneStepLadderWithoutDictionary() throws Exception {
        WordLadderTreeJava8 ladder = new WordLadderTreeJava8();
        assertEquals(0,  ladder.ladderLength("hit", "hot", Arrays.asList()));
    }

    @Test
    public void twoStepLadder() throws Exception {
        WordLadderTreeJava8 ladder = new WordLadderTreeJava8();
        assertEquals(2,  ladder.ladderLength("hit", "dot", Arrays.asList("hot", "dot")));
    }

    @Test
    public void twoStepLadderTwoSolutions() throws Exception {
        WordLadderTreeJava8 ladder = new WordLadderTreeJava8();
        assertEquals(2,  ladder.ladderLength("hit", "dot", Arrays.asList("bit", "bot", "hot", "dot")));
    }

    @Test
    public void threeStepLadder() throws Exception {
        WordLadderTreeJava8 ladder = new WordLadderTreeJava8();
        assertEquals(3,  ladder.ladderLength("hit", "dog", Arrays.asList("hot", "dot", "dog")));
    }






}

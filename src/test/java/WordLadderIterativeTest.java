import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 4/15/2018.
 */
public class WordLadderIterativeTest {

    @Test
    public void emptyLadder() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(0,  ladder.ladderLength("hit", "dot", Arrays.asList("hot")));
    }

    @Test
    public void emptyLadder2() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(0,  ladder.ladderLength("hit", "dot", Arrays.asList()));
    }

    @Test
    public void oneStepLadder() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(2,  ladder.ladderLength("hit", "hot", Arrays.asList("hot")));
    }

    @Test
    public void oneStepLadderWithoutDictionary() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(0,  ladder.ladderLength("hit", "hot", Arrays.asList()));
    }

    @Test
    public void twoStepLadder() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(3,  ladder.ladderLength("hit", "dot", Arrays.asList("hot", "dot")));
    }

    @Test
    public void twoStepLadderTwoSolutions() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(3,  ladder.ladderLength("hit", "dot", Arrays.asList("bit", "bot", "hot", "dot")));
    }

    @Test
    public void twoStepLadderNoSolution() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(0,  ladder.ladderLength("hit", "dog", Arrays.asList("hot", "hat")));
    }

    @Test
    public void twoStepLadderNoSolution2() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(0,  ladder.ladderLength("qa", "sq", Arrays.asList("ca", "ba", "qa", "sq", "cm", "bm")));
    }

    @Test
    public void threeStepLadder() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(4,  ladder.ladderLength("hit", "dog", Arrays.asList("hot", "dot", "dog")));
    }

    @Test
    public void fourStepLadder() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(5,  ladder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }


    @Test
    public void longStepLadder() throws Exception {
        WordLadderIterative ladder = new WordLadderIterative();
        assertEquals(5,  ladder.ladderLength("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
    }

}

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Salty on 5/13/2018.
 */
public class ClimbingTheLeaderBoard {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] aliceRanks = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            Set<Integer> allScores = new HashSet<>();
            allScores.addAll(Arrays.stream(scores).boxed().collect(Collectors.toSet()));
            allScores.add(alice[i]);
            List<Integer> allScoresOrdered = new ArrayList<>(allScores);
            Collections.sort(allScoresOrdered, (a, b) -> b.compareTo(a));
            aliceRanks[i] = allScoresOrdered.indexOf(alice[i]) + 1;
        }
        return aliceRanks;
    }


    private static int[] scoresNoDup(int[] scores) {
//        Set<Integer> allScores = new HashSet<>();
//        allScores.addAll(Arrays.stream(scores).boxed().collect(Collectors.toSet()));
//        return allScores.stream().mapToInt(Number::intValue).toArray();
        int[] scoresNoDups = new int[scores.length];
        int prev = 0;
        int j = 0;
        for (int i = 0; i < scores.length; i++) {
            if (prev == scores[i]) {
                continue;
            } else {
                scoresNoDups[j] = scores[i];
                j += 1;
            }

            prev = scores[i];
        }
        return scoresNoDups;
    }

    static int[] climbingLeaderboard2(int[] scores, int[] alice) {
        int[] aliceRanks = new int[alice.length];
        int[] scoresNoDups = scoresNoDup(scores);

        for (int i = 0; i < alice.length; i++) {
            int aliceScore = alice[i];
            int rank = 0;
            boolean rankFound = false;
            for (int j = 0; j < scoresNoDups.length; j++) {
                if (scoresNoDups[j] < aliceScore) {
                    rank += 1;
                    rankFound = true;
                    break;
                } else if (scoresNoDups[j] == aliceScore) {
                    rankFound = true;
                    break;
                }
            }
            if (rankFound) {
                aliceRanks[i] = rank;
            } else {
                aliceRanks[i] = 1;
            }
        }
        return aliceRanks;
    }

}

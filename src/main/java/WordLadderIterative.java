import java.util.*;

/**
 * Created by Salty on 4/15/2018.
 */
public class WordLadderIterative {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);
        Queue<String> oneDistanceWordsOnThisLevel = new LinkedList<>();
        oneDistanceWordsOnThisLevel.add(beginWord);
        int level = 1;
        while(!oneDistanceWordsOnThisLevel.isEmpty()) {
            int itemsOnThisLevel = oneDistanceWordsOnThisLevel.size();
            for (int i = 0; i < itemsOnThisLevel; i++) {
                String word = oneDistanceWordsOnThisLevel.remove();
                List<String> oneLetterDistanceWordsOnNextLevel = getOneLetterDistanceWords(word, wordListSet);
                for (String oneLetterDistanceWord: oneLetterDistanceWordsOnNextLevel) {
                    if (oneLetterDistanceWord.equals(endWord)) return level+1;
                    oneDistanceWordsOnThisLevel.add(oneLetterDistanceWord);
                    wordListSet.remove(word);
                }
            }
            level++;
        }

        return 0;
    }

    private static List<String> getOneLetterDistanceWords(String beginWord, Set<String> wordList) {
        List<String> oneLetterDistanceWords = new ArrayList<>();
        for(String word: wordList) {
            if(isOneLetterDistance(beginWord, word)) oneLetterDistanceWords.add(word);
        }
        return oneLetterDistanceWords;
    }

    private static boolean isOneLetterDistance(String first, String second) {
        int distance = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)){
                distance++;
            }
        }
        return distance == 1;
    }

}

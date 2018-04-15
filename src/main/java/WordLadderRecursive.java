import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salty on 4/12/2018.
 */
public class WordLadderRecursive {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        } else if (!getOneLetterDistanceWords(beginWord, wordList).isEmpty()) {
            List<String> oneLetterDistanceWords = getOneLetterDistanceWords(beginWord, wordList);
            for (String nextBeginWord : oneLetterDistanceWords) {
//                String nextBeginWord = getOneLetterDistanceWords(beginWord, wordList).get(0);
                List<String> nextWordList = new ArrayList<>(wordList);
                nextWordList.remove(nextBeginWord);
                return ladderLength(nextBeginWord, endWord, nextWordList) + 1;
            }
            return 0;
        } else {
            return -1;
        }

    }

    public static List<String> getOneLetterDistanceWords(String beginWord, List<String> wordList) {
        List<String> oneLetterDistanceWords = new ArrayList<>();
        for(String word: wordList) {
            if(isOneLetterDistance(beginWord, word)) oneLetterDistanceWords.add(word);
        }
        return oneLetterDistanceWords;
    }

    public static boolean isOneLetterDistance(String first, String second) {
        int distance = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)){
                distance++;
            }
        }
        return distance == 1;
    }
}

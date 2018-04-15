import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Salty on 4/12/2018.
 */
public class WordLadderTreeJava8 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Optional<Node<String>> root = getNodeWithOneDistanceChildrenRecursive(Optional.empty(), beginWord, wordList, endWord);
        return getHeight(root);
    }

    /**
     * Creates a node with the value of word, parent set to parent and the children nodes of words from wordList having one letter distanace from word.
     */
    private Optional<Node<String>> getNodeWithOneDistanceChildrenRecursive(Optional<Node<String>> parent, String word, List<String> wordList, String endWord) {
        Node<String> newNode = new Node<>(word, parent);
        List<String> oneLetterDistanceWords = getOneLetterDistanceWords(word, wordList);
        if (!oneLetterDistanceWords.isEmpty()) {
            for (String oneLetterDistnaceWord : oneLetterDistanceWords) {
                List<String> nextWordList = new ArrayList<>(wordList);
                nextWordList.remove(oneLetterDistnaceWord);
                newNode.addChild(getNodeWithOneDistanceChildrenRecursive(Optional.of(newNode), oneLetterDistnaceWord, nextWordList, endWord));
            }
        }

        return leafNodeMustBeEndWord(newNode, endWord);
    }

    private static Optional<Node<String>> leafNodeMustBeEndWord(Node<String> newNode, String endWord){
        return newNode.children.isPresent() ? Optional.of(newNode) : newNode.value.equals(endWord) ? Optional.of(newNode) : Optional.empty();
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

    private static int getHeight(Optional<Node<String>> root) {
        if (root.isPresent()) {
            if (root.get().children.isPresent()) {
                ArrayList<Integer> heights = new ArrayList<>();
                for (Node<String> child : root.get().children.get()) {
                    heights.add(1 + getHeight(Optional.of(child)));
                }
                return min(heights);
            }
        }
        return 0;

    }

    private static int min(List<Integer> heights) {
        int min = Integer.MAX_VALUE;
        for (int i : heights) {
            if (i < min) min = i;
        }
        return min;
    }


    static class Node<String> {
        String value;
        Optional<Node<String>> parent;
        Optional<List<Node<String>>> children;

        public Node(String value, Optional<Node<String>> parent, Optional<List<Node<String>>> children) {
            this.value = value;
            this.parent = parent;
            this.children = children;
        }

        public Node(String value, Optional<Node<String>> parent) {
            this.value = value;
            this.parent = parent;
            this.children = Optional.empty();
        }

        public void addChild(Optional<Node<String>> child) {
            if (children.isPresent()) {
                if (child.isPresent()) {
                    children.get().add(child.get());
                }
            } else if (child.isPresent()) {
                children = Optional.of(new ArrayList<Node<String>>());
                children.get().add(child.get());
            }
        }
    }

}

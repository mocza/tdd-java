import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salty on 4/14/2018.
 */
public class WordLadderTreeJava7 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> myWordList = new ArrayList<>(wordList);
        myWordList.remove(beginWord);
        Node<String> root = getNodeWithOneDistanceChildrenRecursive(null, beginWord, myWordList, endWord);
        return getWordLadderLenghtFromHeight(getHeight(root));
    }

    private List<String> removeWord(String word, List<String> wordList) {
        wordList.remove(word);
        return wordList;
    }

    private int getWordLadderLenghtFromHeight(int height) {
        return height == 0 ? 0 : height + 1;
    }

    /**
     * Creates a node with the value of word, parent set to parent and the children nodes of words from wordList having one letter distanace from word.
     */
    private Node<String> getNodeWithOneDistanceChildrenRecursive(Node<String> parent, String word, List<String> wordList, String endWord) {
        Node<String> newNode = new Node<>(word, parent);
        List<String> oneLetterDistanceWords = getOneLetterDistanceWords(word, wordList);
        if (!oneLetterDistanceWords.isEmpty()) {
            for (String oneLetterDistnaceWord : oneLetterDistanceWords) {
                List<String> nextWordList = new ArrayList<>(wordList);
                nextWordList.remove(oneLetterDistnaceWord);
                newNode.addChild(getNodeWithOneDistanceChildrenRecursive(newNode, oneLetterDistnaceWord, nextWordList, endWord));
//                wordList.remove(oneLetterDistnaceWord);
//                newNode.addChild(getNodeWithOneDistanceChildrenRecursive(newNode, oneLetterDistnaceWord, wordList, endWord));
            }
        }
//        if (newNode != null && newNode.value != null) {
//            System.out.println("Node: " + newNode.value + " Parent: " + (newNode.parent != null ? newNode.parent.value : "NA"));
//        }

        return isLeafNode(newNode) ? getValidLeafNode(newNode, endWord) : newNode;
    }

    private static boolean isLeafNode(Node<String> node) {
        return node.children == null;
    }

    private static Node<String> getValidLeafNode(Node<String> node, String endWord) {
        return node.value.equals(endWord) ? node : null;
    }

    private static List<String> getOneLetterDistanceWords(String beginWord, List<String> wordList) {
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

    private static int getHeight(Node<String> root) {
        if (root != null) {
            if (root.children != null) {
                ArrayList<Integer> heights = new ArrayList<>();
                for (Node<String> child : root.children) {
                    heights.add(1 + getHeight(child));
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


    private static class Node<String> {
        String value;
        Node<String> parent;
        List<Node<String>> children;

        public Node(String value, Node<String> parent, List<Node<String>> children) {
            this.value = value;
            this.parent = parent;
            this.children = children;
        }

        public Node(String value, Node<String> parent) {
            this.value = value;
            this.parent = parent;
            this.children = null;
        }

        public void addChild(Node<String> child) {
            if (children != null && child != null) {
                children.add(child);
            } else if (child != null) {
                children = new ArrayList<>();
                children.add(child);
            }
        }

        @Override
        public java.lang.String toString() {
            return "Node{" +
                    "value=" + value +
                    ", parent=" + parent +
                    ", children=" + children +
                    '}';
        }
    }

}

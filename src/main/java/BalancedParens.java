import java.util.*;

/**
 * Created by Salty on 5/13/2018.
 */
public class BalancedParens {

        public static List<Boolean> isBalancedParens(List<String> lines) {
            List<Boolean> isBalancedParens = new ArrayList<>();

            for (String line : lines) {
                isBalancedParens.add(isBalancedParens(line));
            }


            return isBalancedParens;
        }

    private static boolean isBalancedParens(String line) {
        Stack<String> openCurlyBracket = new Stack<>();
        Stack<String> openBracket = new Stack<>();
        Stack<String> openSquareBracket = new Stack<>();
        for (char c : line.toCharArray()) {
            switch (c) {
                case '{' : openCurlyBracket.push(String.valueOf(c)); break;
                case '(' : openBracket.push(String.valueOf(c)); break;
                case '[' : openSquareBracket.push(String.valueOf(c)); break;
                case '}' :
                    if (openCurlyBracket.isEmpty()) {
                        return false;
                    } else {
                        openCurlyBracket.pop();
                        break;
                    }
                case ')' :
                    if (openBracket.isEmpty()) {
                        return false;
                    } else {
                        openBracket.pop();
                        break;
                    }
                case ']' :
                    if (openSquareBracket.isEmpty()) {
                        return false;
                    } else {
                        openSquareBracket.pop();
                        break;
                    }
            }
        }
        return openBracket.isEmpty() && openCurlyBracket.isEmpty() && openSquareBracket.isEmpty();
    }

}

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Salty on 4/28/2018.
 */
public class StackCalculator {

    public int solution(String S) {
        Stack<Integer> stack = new Stack<>();
        StringTokenizer stringTokenizer = new StringTokenizer(S, " ");

        try {
            while (stringTokenizer.hasMoreTokens()) {
                String op = stringTokenizer.nextToken();
                switch (op) {
                    case "DUP":
                        int val = popIfPresent(stack);
                        stack.push(val);
                        stack.push(val);
                        break;
                    case "POP":
                        popIfPresent(stack);
                        break;
                    case "+":
                        stack.push(popIfPresent(stack) + popIfPresent(stack));
                        break;
                    case "-": {
                        int valOne = popIfPresent(stack);
                        int valTwo = popIfPresent(stack);
                        if (valOne < valTwo) {
                            return -1;
                        }
                        stack.push(valOne - valTwo);
                        break;
                    }
                    default:
                        stack.push(Integer.valueOf(op));
                        break;
                }
            }
            return popIfPresent(stack);
        } catch (IllegalStateException e) {
            return -1;
        }
    }

    private int popIfPresent(Stack<Integer> stack) {
        if (stack.empty()) {
            throw new IllegalStateException("Stack empty");
        } else {
            return stack.pop();
        }
    }
}


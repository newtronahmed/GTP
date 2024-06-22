import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String expression1 = "{[()()]}";
        String expression2 = "{[(])}";

        System.out.println("Expression: " + expression1 + " is balanced: " + isBalanced(expression1));
        System.out.println("Expression: " + expression2 + " is balanced: " + isBalanced(expression2));
    }

    /**
     * Checks if the given expression has balanced parentheses.
     *
     * @param expression the input string containing the expression
     * @return true if the expression is balanced, false otherwise
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char character : expression.toCharArray()) {
            // If character is an opening parenthesis, push it onto the stack
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            }
            // If character is a closing parenthesis
            else if (character == ')' || character == '}' || character == ']') {
                // Check if the stack is empty or if the top of the stack is not the matching opening parenthesis
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), character)) {
                    return false;
                }
            }
        }

        // The expression is balanced if the stack is empty
        return stack.isEmpty();
    }

    /**
     * Checks if the given pair of characters is a matching pair of parentheses.
     *
     * @param opening the opening parenthesis
     * @param closing the closing parenthesis
     * @return true if the pair is matching, false otherwise
     */
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }
}


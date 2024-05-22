package CH11;

import java.util.Stack;

public class ValidParentheses {

    static Stack<Character> stack = new Stack<>();
    private static boolean checkParentheses(char c) {
        switch (c) {
            case '{' -> stack.push(c);
            case '}' -> {
                if (stack.empty()) return false;
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "{}}{";

        boolean result = false;

        for (char c : s.toCharArray()) {
            result = checkParentheses(c);
            if (!result) {
                break;
            }

        }

        System.out.println(result);

    }
}

package CH11;

import java.util.Stack;

public class RotateParentheses {

    static Stack<Character> stack = new Stack<>();
    private static boolean isCollect(String s, int i) {

        char[] charArray = s.toCharArray();

        for (int j = 0; j <charArray.length ; j++) {
            char c = charArray[(j+i) % charArray.length] ;

            switch (c) {
                case '{' -> stack.push('}');
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '}', ')', ']' -> {
                    if (stack.empty()) return false;
                    if (stack.pop() != c) return false;
                }
            }
        }
       return true;
    }

    public static void main(String[] args) {
        String s = "{}[]{}";
        int cnt = 0;

        if(s.length() % 2 != 0) {
            System.out.println("난 무조건 0개" +cnt);
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (isCollect(s, i)) cnt++;
            }
        }

        System.out.println("cnt = " + cnt);
    }
}

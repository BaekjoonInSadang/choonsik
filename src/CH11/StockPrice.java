package CH11;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        int[] prices = {5,5,3,2,3};
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            int index = stack.pop();
            answer[index] = prices.length - index -1;
        }

        System.out.println("answer = " + Arrays.toString(answer));

    }
}

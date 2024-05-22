package CH6;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Decimal {

    public static void main(String[] args) {

        String numbers = "17";

        Stack<Integer> stack = new Stack<>();
        String[] numberList = numbers.split("");
        Set<Integer> primeNumbers = new HashSet<>();


//        for (String s : numberList) {
//            System.out.println("s = " + s);
//        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberList.length; i++) {
                    stack.push(Integer.parseInt(numberList[i]));


                    StringBuilder sb = new StringBuilder();
                    for (int s : stack) {
                        sb.append(s);

                    }
                    int n = Integer.parseInt(sb.toString());

                    // stack 에 쌓여있는거 다 합쳐서 n에 다 합쳐서 담고싶어
                    if (isPrime(n)) primeNumbers.add(n);

                    System.out.println("sb = " + sb);
                    if (stack.size() - 1 < numberList.length - 1) run();


                    stack.pop();
                }

            }
        };
        runnable.run();
        System.out.println(primeNumbers.size());
        for (Integer primeNumber : primeNumbers) {
            System.out.println("primeNumber = " + primeNumber);
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        // 2부터 n의 제곱근까지의 수로 나누어 떨어지는지 확인
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // 나누어 떨어지면 소수가 아님
            }
        }

        return true; // 나누어 떨어지지 않으면 소수임
    }
}

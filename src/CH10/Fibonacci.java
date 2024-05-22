package CH10;

import java.util.Arrays;

public class Fibonacci {
    private static final int[] mem = new int[100001];

    private static int fibonacci(int n) {
        if (mem[n] != -1) return mem[n];
        if (n== 0 || n == 1) return n;

        return mem[n] = (fibonacci(n-1) + fibonacci(n-2)) % 1234567;
    }

    public static void main(String[] args) {

        int n = 50;

        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) {
            fibonacci(n);
        }

        int fibonacci = fibonacci(n);
        System.out.println("fibonacci = " + fibonacci);
    }

}

package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1739 문제
 * 문제 : 판화
 *
 */
public class print {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int tmp = 0;

        while (n > 0) {
            tmp = n % b;
            if(n%b >= 10) sb.append((char) ((n % b) + 55));
            else sb.append(n%b);
            n /= b;
        }

        System.out.println(sb.reverse().toString());
    }
}

package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 백준 10250 문제
 * 문제 : ACM 호텔
 * ----------------------------------------
 * 입력값 :
 * 첫째 줄 : 데이터 줄 갯수
 * 둘째 줄 : 층수 / 각방수 / 몇번째 손님
 * ----------------------------------------
 * 출력값 : 배정될 방 호수
 */
public class hotel {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int inputLength = Integer.parseInt(br.readLine());

        for (int i=0; i<inputLength; i++) {

            String s = br.readLine();
            String[] input = s.split(" ");
            int H = Integer.parseInt(input[0]); // 층수
            int W = Integer.parseInt(input[1]); // 각 층의 방 수
            int N = Integer.parseInt(input[2]); // 몇 번째 손님


            int floor = N % H; // 층수로 나눈 나머지가 층을 결정
            int room = (N / H) + 1; // 층수로 나눈 몫에 1을 더해 호수 결정
            if (floor == 0) { // 층수로 나눈 나머지가 0인 경우, 맨 꼭대기 층에 배정됨
                floor = H;
                room -= 1; // 호수는 변경되지 않음
            }
            sb.append(floor * 100 + room).append("\n"); // 결과 출력
        }
        System.out.println(sb);
    }
}

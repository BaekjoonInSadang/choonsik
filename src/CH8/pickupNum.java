package CH8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class pickupNum {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        String[] split = bf.readLine().split(" ");
        int listLength = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        // 수열 입력 및 배열 생성
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            numList.add(Integer.parseInt(bf.readLine()));
        }

        // 수열 정렬
        Collections.sort(numList);

        int start = 0;
        int end = 0;
        int minDiff = Integer.MAX_VALUE;  // 차이의 최소값 초기화

        while (start < listLength && end < listLength) {
            // 인덱스가 범위를 벗어나지 않도록 조심합니다.
            if (end < listLength) {
                int diff = numList.get(end) - numList.get(start);

                // 차이가 M 이상인 경우
                if (diff >= M) {
                    // 최소 차이 갱신
                    minDiff = Math.min(minDiff, diff);
                    // start 포인터 이동
                    start++;
                } else {
                    // end 포인터 이동
                    end++;
                }
            } else {
                end = listLength;
            }
        }

        // 결과 출력
        System.out.println(minDiff);
    }
}
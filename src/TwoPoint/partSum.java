package TwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class partSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력을 가져옵니다.
        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int result = Integer.parseInt(split[1]);

        // 두 번째 입력을 가져와서 List<Integer>로 변환합니다.
        List<Integer> inputList = Arrays.stream(bf.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 두 포인터 알고리즘을 사용하여 부분합을 찾습니다.
        int start = 0, end = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (end < n) {
            // 현재 부분합을 증가시킵니다.
            sum += inputList.get(end);
            end++;

            // 현재 부분합이 원하는 결과 이상이면, start를 조정하여 부분합을 줄입니다.
            while (sum >= result) {
                // minLength 업데이트
                minLength = Math.min(minLength, end - start);

                // 부분합을 줄이기 위해 start를 증가
                sum -= inputList.get(start);
                start++;
            }
        }

        // 최소 길이를 출력합니다. 찾지 못했을 경우, 0을 출력합니다.
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
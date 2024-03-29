package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class frequency {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] token = bf.readLine().split(" ");

        List<Integer> inputList = Arrays.stream(bf.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 각 숫자의 등장 횟수를 세어서 맵으로 저장
        Map<Integer, Long> countingMap = inputList.stream()
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()));

        // 등장 횟수가 같은 경우 먼저 등장한 순서대로, 등장 횟수가 다른 경우 등장 횟수가 많은 순서대로 정렬
        List<Integer> sortedList = inputList.stream()
                .sorted((a, b) -> {
                    int counting = Long.compare(countingMap.get(b), countingMap.get(a));
                    int indexing = Integer.compare(inputList.indexOf(a), inputList.indexOf(b));
                    return counting == 0 ?  indexing: counting;
                })
                .collect(Collectors.toList());


        // 결과 출력
        // 리스트를 문자열로 변환하여 각 요소 사이에 공백을 추가
        String result = String.join(" ", sortedList.stream().map(Object::toString).toArray(String[]::new));


        System.out.println(result);
    }
}

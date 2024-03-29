package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 백준 7785 문제
 */
public class company {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int ListCnt = Integer.parseInt(bf.readLine());

        methods1(bf, ListCnt);
//        methods2(ListCnt, bf);



    }

    private static void methods1(BufferedReader bf, int ListCnt) {
        List<String> uniqueNames = bf.lines().limit(ListCnt)
                .map(line -> line.split(" "))
                .collect(Collectors.toMap(
                        arr -> arr[0], // 이름으로 그룹화
                        arr -> arr[1], // 출입 상태를 값으로 설정
                        (prev, next) -> next))
                .entrySet().stream()
                .filter(entry -> entry.getValue().equals("enter")) // 퇴장하지 않은 직원 필터링
                .map(Map.Entry::getKey) // 이름만 추출합니다.
                .sorted(Comparator.reverseOrder()) // 사전 반대순으로 정렬합니다.
                .collect(Collectors.toList());

        for (String uniqueName : uniqueNames) {
            System.out.println(uniqueName);
        }
    }

    private static void methods2(int ListCnt, BufferedReader bf) throws IOException {
        Map<String, String> finalStatus = new HashMap<>();

        for (int i = 0; i < ListCnt; i++) {
            String[] log = bf.readLine().split(" ");
            String name = log[0];
            String status = log[1];

            // 각 직원의 최종 상태를 마지막으로 나온 값으로 저장
            finalStatus.put(name, status);
        }

        for (String s : finalStatus.entrySet().stream()
                .filter(entry -> entry.getValue().equals("enter")) // 퇴장하지 않은 직원 필터링
                .map(Map.Entry::getKey) // 이름만 추출합니다.
                .sorted(Comparator.reverseOrder()) // 사전 반대순으로 정렬합니다.
                .collect(Collectors.toList())) {
            System.out.println(s);
        }
    }
}


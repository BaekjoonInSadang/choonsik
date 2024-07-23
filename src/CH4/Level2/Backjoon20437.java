package CH4.Level2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ==========================================================
 * [제목] 문자열 게임 2
 * ==========================================================
 * [문제]
 * 알파벳 소문자로 이루어진 문자열 W가 주어진다.
 * 양의 정수 K가 주어진다.
 * 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다.
 * <p>
 * ==========================================================
 * [제한 사항]
 * ==========================================================
 * [풀이]
 * 1. 주어진 문자열에서 중복되지 않게 하나씩 뽑아! 그리고 그 한개씩 FOR문을 돌려
 * 2. 시작 포지션, 마지막 포지션 각각 두고
 * 3. 주어진 K정수가 나올 떄까지 마지막 포지션을 +1씩 늘려
 * 4. 그리고 K정수가 나오는 순간 시작부터 마지막지점까지의 String값을 저장
 * 5.
 */
public class Backjoon20437 {

    public static void main(String[] args) throws IOException {

        // 하드코딩된 입력 값을 설정
        String input = "2\n" +  // 테스트 케이스 수
                "superaquatornado\n" +  // 첫 번째 테스트 케이스 문자열
                "2\n" +  // 첫 번째 테스트 케이스 k 값
                "abcdefghijklmnopqrstuvwxyz\n" +  // 두 번째 테스트 케이스 문자열
                "5\n";   // 두 번째 테스트 케이스 k 값

        // 하드코딩된 입력을 InputStream으로 변환
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        // InputStream을 BufferedReader로 감싸서 입력을 읽기
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));


//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수 읽기
        int t = Integer.parseInt(bf.readLine());

        // 각 테스트 케이스에 대해 반복
        for (int i = 0; i < t; i++) {
            String solution = solution(bf.readLine(), Integer.parseInt(bf.readLine()));
            System.out.println(solution);
        }
    }

    // 문자열과 정수 k를 받아 가장 짧고 긴 문자열의 길이를 계산하는 메서드
    public static String solution(String s, int k) {

        // k개 이상의 빈도를 가진 문자들을 리스트로 가져옴
        List<Character> characters = calcCharacters(s, k);
        int maxLength = Integer.MIN_VALUE; // 최댓값 초기화
        int minLength = Integer.MAX_VALUE; // 최솟값 초기화

        for (char ch : characters) {
            List<Integer> positions = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    positions.add(i);
                }
            }

            for (int i = 0; i <= positions.size() - k; i++) {
                int lastIndex = i + k - 1;
                int length = positions.get(i + k - 1) - positions.get(i) + 1;
                maxLength = Math.max(maxLength, length);
                minLength = Math.min(minLength, length);
            }
        }

        // 유효한 값이 없는 경우
        if (minLength == Integer.MAX_VALUE || maxLength == Integer.MIN_VALUE) {
            return "-1";
        }
        // 결과 문자열 반환
        return minLength + " " + maxLength;
    }

    private static List<Character> calcCharacters(String s, int k) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        List<Character> result = new ArrayList<>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() >= k) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}

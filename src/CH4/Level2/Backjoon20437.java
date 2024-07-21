package CH4.Level2;

import java.util.*;

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

    public static void main(String[] args) {
        Backjoon20437 instance = new Backjoon20437();
        int[] solution = instance.solution("aabadcafsassaaaafsfsa", 5);

        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(String s, int k) {

        int[] answer = {0, 0};


        List<String> strings = calcString(s, k);
        System.out.println("strings = " + strings);
        int maxLength = 0;

        for (String key : strings) {
            System.out.println(" ================== 현재 key 값 = ['" + key + "'] ==================");
//            int minLength3 = s.length();
//            int maxLength4 = 0;
//
//            // 여기에서 조건 만족하는지 체크 (3번)
//            while (startPoint < s.length() - 2) {
//                String substring = s.substring(startPoint, endPoint);
//                boolean pass = checkCondition3(substring, key);
//                if (pass) {
//                    startPoint += 1;
//                    endPoint = startPoint + 2;
//                    minLength3 = Math.min(minLength3, substring.length());
//                } else {
//                    endPoint += 1;
//                }
//            }
//            answer[0] = minLength3;


            // 여기에서 조건 만족하는지 체크 (4번)
            char[] charArray = s.toCharArray();
            ArrayList<Integer> tempRe = new ArrayList<>();

            for (int i = 0; i < charArray.length; i++) {
                if (String.valueOf(charArray[i]).equals(key)) {
                    tempRe.add(i);
                }
            }
            System.out.println("[key 값으로 사용되는 리스트] = " + tempRe);


            for (int i = 0; i < tempRe.size() - k + 1; i++) {
                int lastIndex = i + k - 1;
                System.out.println("index[" + i + "] = " + tempRe.get(i));
                System.out.println("index[" + lastIndex + "] = " + tempRe.get(lastIndex));
                System.out.println(tempRe.get(lastIndex) - tempRe.get(i));
                maxLength = Math.max(maxLength, tempRe.get(lastIndex) - tempRe.get(i));
                if (lastIndex - 1 > tempRe.size()) break;
            }

            System.out.println("maxLength = " + maxLength);
        }
        answer[1] = Math.max(answer[1], maxLength);

        return answer;
    }

    private List<String> calcString(String s, int k) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        // 각 문자 빈도 계산
        for (char c : s.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        // 빈도가 2 이상인 문자 출력
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() >= k) {
                result.add(entry.getKey().toString());
            }
        }

        return result;
    }

    private boolean checkCondition3(String input, String key) {

        return true;
    }
}

package CH4.Level2;

import java.util.Arrays;

/**
 * ==========================================================
 * 이진 변환 반복하기
 * ==========================================================
 * [문제]
 * 0과 1로 이루어진 어떤 문자열 x에 대해 이진변환을 아래처럼 정의한다.
 * 1. x의 모든 0을 제거
 * 2. x의 길이를 c라고 하면, x를 (2진법으로 표현한 문자열)로 바꾼다.
 * 예를 들어 x = "0111010" 이라고 할 때, x에 이진 변환을 가하면,
 * 1. 0을 제거 -> 1111
 * 2. 갯수가 4이므로, 4를 2진법으로 표현한 값이 x가 됨! 따라서 100
 * ==========================================================
 * [제한 사항]
 * s에는 '1'이 최소 하나이상 포함되어 있음
 * s의 길이는 1이상 150,000 이하
 * ==========================================================
 * [풀이]
 * s값을 받아서
 */
public class Q70129 {

    public static void main(String[] args) {
        Q70129 instance = new Q70129();
        int[] solution = instance.solution("110010101001");
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(String s) {

        int zeroCnt = 0;
        int cnt = 0;

        while (!s.equals("1")) {
            String deletedZeroString = deleteZero(s);
            zeroCnt += s.length() - deletedZeroString.length();
            s = (Integer.toBinaryString(deletedZeroString.length()));
            cnt++;
        }

        int[] answer = {cnt, zeroCnt};
        return answer;
    }

    private static String deleteZero(String s) {
        return s.replaceAll("0", "");
    }
}

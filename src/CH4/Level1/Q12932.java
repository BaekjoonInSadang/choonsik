package CH4.Level1;


import java.util.Arrays;

/**
 * ==========================================================
 * [제목] 자연수 뒤집어 배열로 만들기
 * ==========================================================
 * [문제]
 * 주어진 숫자를 뒤집고 배열에 담아 출력
 * ==========================================================
 * [풀이]
 * StringBuilder 를 통해 주어진 값을 문자열로 바꾸고 뒤집는다.
 * 바꾼 문자열의 길이만큼 for 돌면서 숫자 타입으로 변환하여 배열에 담아준다.
 */
public class Q12932 {

    public static void main(String[] args) {
        Q12932 q12932 = new Q12932();
        int[] solution = q12932.solution(52232);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(long n) {

        String reverseValue = new StringBuilder(String.valueOf(n)).reverse().toString();
        int[] result = new int[reverseValue.length()];

        String[] split = reverseValue.split("");

        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }

        return result;
    }
}

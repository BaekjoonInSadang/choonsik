package CH4.Level1;


import java.util.Arrays;

/**
 * ==========================================================
 * [제목] 자연수 뒤집어 배열로 만들기
 * ==========================================================
 * [문제]
 * 주어진 숫자를 뒤집고 배열에 담아 출력
 * ==========================================================
 * [제한 조건]
 * n은 10,000,000,000 이하인 자연수
 * ==========================================================
 * [풀이]
 * StringBuilder 를 통해 주어진 값을 문자열로 바꾸고 뒤집는다.
 * 바꾼 문자열의 길이만큼 for 돌면서 숫자 타입으로 변환하여 배열에 담아준다.
 */
public class Q12932 {

    public static void main(String[] args) {
        Q12932 instance = new Q12932();

        int[] result1 = instance.solution(52232);
        int[] result2 = instance.solution(910227);

        System.out.println("result = " + Arrays.toString(result1));
        System.out.println("result = " + Arrays.toString(result2));
    }

    public int[] solution(long n) {

        String reverseVal = new StringBuilder(String.valueOf(n)).reverse().toString();
        int[] result = new int[reverseVal.length()];
        String[] split = reverseVal.split("");
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }
}

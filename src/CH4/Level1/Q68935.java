package CH4.Level1;

/**
 * ==========================================================
 * [제목] 3진법 뒤집기
 * ==========================================================
 * [문제]
 * 자연수 n이 매개변수로 주어집니다.
 * n을 3진법 상에서 앞뒤로 뒤집은 후
 * 다시 10진법으로 표현한 수를 return 제출
 * ==========================================================
 * [제한 사항]
 * 1 <= n <= 100,000,000 자연수
 * ==========================================================
 * [풀이]
 * 3진법 변환 메서드 생성
 * 주어진 값을 3진법으로 바꾸고 뒤집고 10진법으로 변환 끝
 */
public class Q68935 {

    public static void main(String[] args) {
        Q68935 instance = new Q68935();

        int result1 = instance.solution(125);
        int result2 = instance.solution(53423);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    public int solution(int n) {
        String ternary = toTernary(n);
        return Integer.parseInt(ternary, 3);
    }

    // 10진수를 3진수로 변환
    public static String toTernary(int number) {
        if (number == 0) return "0";

        StringBuilder ternary = new StringBuilder();
        while (number > 0) {
            int remainder = number % 3;
            ternary.insert(0, remainder);
            number /= 3;
        }
        
        return ternary.reverse().toString();
    }
}

package CH4.Level1;

/**
 * ==========================================================
 * [제목] 문자열 다루기 기본
 * ==========================================================
 * [문제]
 * 주어진 문자열이 4자리 또는 6자리일 것
 * 주어진 문자열이 모두 숫자이면 TRUE 그렇지 않으면 FALSE
 * ==========================================================
 * [풀이]
 * 정규식으로 품!
 * \\D{4} <= 4자리 숫자
 * \\D{6} <= 6자리 숫자
 */
public class Q12918 {

    public static void main(String[] args) {
        Q12918 q12918 = new Q12918();
        boolean solution = q12918.solution("13abc5");

        System.out.println("solution = " + solution);

        boolean solution1 = q12918.solution("12ab34");
        System.out.println("solution1 = " + solution1);
    }

    public boolean solution(String s) {

        return s.matches("\\d{4}|\\d{6}");
    }

}

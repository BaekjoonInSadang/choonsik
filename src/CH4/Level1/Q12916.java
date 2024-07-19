package CH4.Level1;

/**
 * ==========================================================
 * [제목] 문자열 내 p와 y의 개수
 * ==========================================================
 * [문제]
 * 대문자와 소문자가 섞여있는 문자열 s가 주어진다.
 * 주어진 문자열에 p의 개수와 y의 개수를 비교하고 같으면 true 다르면 false
 * 'p' 와 'y' 가 하나도 없는 경우는 항상 true 리턴
 * ==========================================================
 * [제한 사항]
 * 단, 대문자 소문자 구분 x
 * s의 길이는 50이하의 자연수
 * s는 알파벳으로만 이루어져 있음
 * ==========================================================
 * [풀이]
 * 주어진 값을 모두 chatAt로 나누고 모두 소문자로 변경
 * 그리고 변수 y와 x 각각 만들어 두고
 * for문 돌면서 x와 y값을 counting 한다.
 * 마지막에 갯수를 비교하여 true or false 둘 다 0이라면 true
 */
public class Q12916 {

    public static void main(String[] args) {
        Q12916 instance = new Q12916();
        boolean result1 = instance.solution("ypPpy");
        boolean result2 = instance.solution("yppY");

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    boolean solution(String s) {

        int pCnt = 0;
        int yCnt = 0;

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            char lowerCase = Character.toLowerCase(c);
            if (lowerCase == 'y') {
                yCnt++;
            }
            if (lowerCase == 'p') {
                pCnt++;
            }
        }
        return yCnt == pCnt;
    }
}

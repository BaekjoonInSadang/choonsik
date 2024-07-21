package CH4.Level2;


/**
 * ==========================================================
 * n진수 게임
 * ==========================================================
 * [문제]
 * 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임
 * 1. 숫자를 0부터 시작해서 차례대로 말한다.
 * 첫번쨰 사람은 0 ..... 열 번째 사람은 9
 * 2. 10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 즉, 열한 번째 사람은 10의 첫 자리인 1, 열두번째 사람은 둘 째 자리인 0을 말한다.
 * <p>
 * ==========================================================
 * [제한 사항]
 * 진법 : 2 ≦ n ≦ 16
 * 미리 구할 튜브의 숫자의 갯수 : 0 ＜ t ≦ 1000
 * 게임에 참가하는 인원 : 2 ≦ m ≦ 100
 * 튜브의 순서 : 1 ≦ p ≦ m
 * ==========================================================
 * [풀이]
 * 0. 주어진 진법으로 숫자를 t개만큼 세팅
 * 1. 구한 숫자를 모두 StringBuilder에 추가
 * 2. 위 sb값을 Char 값으로 리스트로 변경
 * 3. 그리고 char[] 배열의 인덱스가 튜브의 순서에 맞게 나머지 구하는값을 통해 0인경우에만 정답리스트에 추가
 */
public class Q17687 {

    public static void main(String[] args) {
        Q17687 instance = new Q17687();
        String solution = instance.solution(2, 4, 2, 1);
        String solution2 = instance.solution(16, 16, 2, 1);
        System.out.println("solution = " + solution);
        System.out.println("solution2 = " + solution2);
    }

    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t * m; i++) {
            sb.append(Integer.toString(i, n));
        }

        char[] charArray = sb.toString().toCharArray();

        for (int i = p - 1; i <= charArray.length; i += m) {
            answer.append(charArray[i]);
            if (answer.length() == t) break;
        }
        return answer.toString().toUpperCase();
    }
}

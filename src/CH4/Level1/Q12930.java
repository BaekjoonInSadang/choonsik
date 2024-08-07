package CH4.Level1;

/**
 * ==========================================================
 * [제목] 이상한 문자 만들기
 * ==========================================================
 * [문제]
 * 문자열 s는 한개이상의 단어로 구성
 * 각 단어는 하나이상의 공백문자로 구분
 * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째는 소문자로 변경
 * ==========================================================
 * [제한 사항]
 * 문자열 전체의 짝/홀수가 아니라 공백별로 취급
 * 첫번째 글자는 0인덱스이므로 짝수로 취급
 * !!!!!!!!!!!!!!! 공백이 여러개 있을 수 있음 주의 !!!!!!!!!!!!!!!
 * ==========================================================
 * [풀이]
 * 주어진 문자열을 우선 공백으로 split 해서 분리
 * 분리된 리스트를 for 문 돌면서 홀수인지 짝수인지에 따라 대문자 소문자로 변경해줌
 * 그리고 StringBuilder 를 통해 문자열을 추가해줌
 */
public class Q12930 {

    public static void main(String[] args) {
        Q12930 instance = new Q12930();

        String result1 = instance.solution("try hello world");
        String result2 = instance.solution("Gram java CodingTest");

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                toUpper = true;
            } else {
                if (toUpper) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                // 반전
                toUpper = !toUpper;
            }
        }
        return sb.toString();
    }
}

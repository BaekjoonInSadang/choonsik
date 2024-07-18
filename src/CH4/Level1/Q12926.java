package CH4.Level1;


/**
 * ==========================================================
 * [문제 명] 시저 암호
 * ==========================================================
 * [문제] 원래 문자열을 char타입으로 바꾼 후 n만큼 이동후 원래대로 출력
 * ex) =>
 * s = "ab cd e"
 * n = 2
 * result = "cd ef g" <-- 이렇게 2칸씩이동 후 출력
 * ==========================================================
 * [풀이]
 * 문자열을 char 타입으로 변환
 * char 값을 int 값으로변환 후 n을 더해준 후 다시 char값으로 변환
 * 단, 이때 공백인것은 그대로 StringBuilder에 넣어주고 그렇지 않은것은 로직을 거친다.
 * 로직은 아스키 코드에 따라 조건을 나누어 주고 90 또는 122를 넘어서면 - 26을 함으로써 순환할 수 있게 해줌
 * [아스키 코드]
 * 대문자 알파벳은 65 ~ 90 (26개)
 * 소문자 알파벳은 97 ~ 122 (26개)
 */
public class Q12926 {

    public static void main(String[] args) {
        Q12926 q12926 = new Q12926();
        String abCd = q12926.solution("ab cd", 2);
        System.out.println("abCd = " + abCd);
    }

    public String solution(String s, int n) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                int newAsciiValue = (int) c + n;

                if ((int) c > 96 && newAsciiValue > 122) {
                    newAsciiValue -= 26;
                }
                if ((int) c < 91 && newAsciiValue > 90) {
                    newAsciiValue -= 26;
                }

                result.append((char) newAsciiValue);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
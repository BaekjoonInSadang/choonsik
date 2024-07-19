package CH4.Level1;

import java.util.HashMap;
import java.util.Map;

/**
 * ==========================================================
 * [제목] 숫자 문자열과 영단어
 * ==========================================================
 * [문제]
 * 네오와 프로도가 숫자놀이를 하고 있다.
 * 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면
 * 프로도는 원래 숫자를 찾아내는 게임
 * ==========================================================
 * [제한 사항]
 * 1 <= s <= 50
 * s가 "zero" 또는 "0"으로 시작하지 않습니다.
 * return 값은 1이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 주어짐
 * ==========================================================
 * [풀이]
 * 우선은 해시맵에 key 값으로 (zero, one ...) value (0, 1) 등록
 * 문자열에서 init last 각각 변수 지정
 * 첫번쨰로 현재 첫번째 자리수가 숫자인지 영어인지 판별
 * 숫자일경우 그대로 sb에 추가 그렇지 않다면, hash맵에서 찾음
 */
public class Q81301 {

    public static void main(String[] args) {
        Q81301 instance = new Q81301();

        int result1 = instance.solution("one4seveneight");
        int result2 = instance.solution("three5eightone4seven9");

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    public int solution(String s) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            s = s.replace(entry.getKey(), entry.getValue());
        }

        return Integer.parseInt(s);
    }
}

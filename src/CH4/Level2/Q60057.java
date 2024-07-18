package CH4.Level2;

import java.util.ArrayList;


/**
 * ==========================================================
 * [제목] 문자열 압축
 * ==========================================================
 * [문제]
 * 문자열 압축을 위해 같은 값이 연속되게 나타나면 반복되는 숫자와 반복되는 값으로 나타내어
 * 표현해서 압축할 수 있다.
 * ex) ababab, aabbacc
 * 1개 반복 : ababab, 2a2ba2c
 * 2개 반복 : 3ab, aabbacc
 * 압축했을 때 가장 짧은 갯수를 결과값으로 return
 * ==========================================================
 * [제한 사항]
 * 단 한번만 반복되면 1은 생략한다.
 * s의 길이는 1이상 1,000 이하
 * s는 알파벳 소문자로만 이루어져 있다.
 * ==========================================================
 * [풀이]
 * 주어진 s 문자열의 길이를 절반으로 for 돌린다.
 * 이떄 시작값 preCnt, 현재 값 nowCnt 각각 설정
 * while (index 길이만큼 subString 으로 떼서 비교할 예정)
 * preVal = index 만큼의 길이를 가진 초기값
 * preVal 이 값이 반복된다면 cnt 를 +1 후 반복
 * 다르다면, preVal 새 값으로 변경하고,
 * 이전에 입력된 cnt + preVal 값을 String 값으로 sb에 추가
 * cnt 값은 1로 초기화 / preCnt + index / nowCnt + index
 * preCnt 값이 문자열 길이를 초과하거나, nowCnt 값이 문자열 길이를 초과하면
 * 남은 문자열을 sb에 모두 추가하고 break;
 * 현재 length 값과 이전 length 값을 비교하고 작은 값 저장
 * for 종료되면 저장된 가장 작은값을 리턴
 */
public class Q60057 {

    public int solution(String s) {

        ArrayList<String> List = new ArrayList<>();
        int minLength = s.length();

        for (int index = 1; index <= s.length() / 2; index++) {

            StringBuilder sb = new StringBuilder();

            int prevCnt = index;
            int nowCnt = index + index;
            int count = 1;
            String preVal = s.substring(0, index);

            while (true) {
                String nowVal = s.substring(prevCnt, nowCnt);

                if (preVal.equals(nowVal)) {
                    count++;
                } else {
                    if (count == 1) {
                        sb.append(preVal);
                    } else {
                        sb.append(String.valueOf(count)).append(preVal);
                    }
                    preVal = nowVal;
                    count = 1;
                }

                prevCnt = nowCnt;
                nowCnt = prevCnt + index;

                if (prevCnt >= s.length() || nowCnt > s.length()) {
                    if (count == 1) {
                        sb.append(preVal);
                    } else {
                        sb.append(String.valueOf(count)).append(preVal);
                    }

                    if (prevCnt < s.length()) {
                        sb.append(s.substring(prevCnt));
                    }
                    break;
                }
            }

            minLength = Math.min(sb.length(), minLength);
        }

        return minLength;
    }
}




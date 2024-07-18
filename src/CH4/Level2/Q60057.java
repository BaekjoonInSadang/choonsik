package CH4.Level2;

import java.util.ArrayList;


/**
 * 문자열 압축
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




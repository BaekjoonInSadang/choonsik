package CH4;

import java.util.ArrayList;

public class Q60057 {

    public int solution(String s) {

        ArrayList<String> List = new ArrayList<>();
        int minLength = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {

            StringBuilder sb = new StringBuilder();

            int prevCnt = i;
            int nowCnt = i + i;
            int count = 1;
            String preVal = s.substring(0, i);

            while (true) {

                String nowVal;
                if (nowCnt <= s.length()) {
                    nowVal = s.substring(prevCnt, nowCnt);
                } else {
                    nowVal = "";
                }

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
                nowCnt = prevCnt + i;

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
            List.add(String.valueOf(sb));
            minLength = Math.min(sb.length(), minLength);
        }

        int i = 1;
        for (String string : List) {
            System.out.println(i + "번째 : " + string + " (" + string.length() + ")");
            i++;
        }
        return minLength;
    }
}




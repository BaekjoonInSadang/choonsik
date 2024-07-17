package CH4;

import java.util.ArrayList;

public class Q60057 {


    public Integer solution(String message) {

        int MinLength = message.length();

        ArrayList<String> List = new ArrayList<>();
        for (int i = 1; i <= message.length() / 2; i++) {


            StringBuilder sb = new StringBuilder();

            int prevCnt = i;
            int nowCnt = i + i;
            int count = 1;
            String preVal = message.substring(0, i); // a

            while (true) {

                String nowVal = message.substring(prevCnt, nowCnt);

                // 일치
                if (preVal.equals(nowVal)) {
                    count++;

                    // 불일치
                } else {
                    // 불일치 하면 이전거 sb에 추가
                    if (count == 1) {
                        sb.append(preVal);
                    } else {
                        sb.append(String.valueOf(count) + preVal);
                    }

                    // 키값 리셋 (새로운 값으로)
                    preVal = nowVal;
                    count = 1;
                }

                prevCnt = nowCnt;
                nowCnt = prevCnt + i;

                // 8자리인데 3 3 9/ 2

                if (nowCnt > message.length()) {
                    if (count == 1) {
                        sb.append(preVal);
                    } else {
                        sb.append(String.valueOf(count) + preVal);
                    }

                    sb.append(message.substring(prevCnt, message.length()));
                    break;
                }


            }

            List.add(String.valueOf(sb));
            MinLength = Math.min(sb.length(), MinLength);

        }

        System.out.println("List = " + List);

        return MinLength;
    }
}

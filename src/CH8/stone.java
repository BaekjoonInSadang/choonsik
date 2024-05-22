package CH8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stone {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] inputList = bf.readLine().split(" ");
        int Length = Integer.parseInt(inputList[0]);
        int maxB = Integer.parseInt(inputList[1]);
        int minW = Integer.parseInt(inputList[2]);

        String[] q = bf.readLine().split("");


        int s = 0;
        int e = 0;
        int maxLength = 0;


        // while 문 돌면서 최대값 찾기
        while (isCheck(e, s, Length)) {

            System.out.println("s = " + s + " ||  e = " + e);

            int nowB = 0;
            int nowW = 0;
            int nowLength = 0;

            for (int i = s; i <e; i++) {
                // DEEPL
                if(q[i].equals("B")) nowB++;
                if(q[i].equals("W")) nowW++;
            }


            if (nowB <= maxB) {
                e++;
            } else {
                s++;
            }

            if(nowW >= minW && nowB <= maxB) {
                nowLength = e - s;
                maxLength = Math.max(maxLength, nowLength);
                System.out.println("nowLength = " + nowLength + " || maxLength = " + maxLength);


            }
        }
        System.out.println(maxLength);
    }

    private static boolean isCheck(int e, int s, int length) {
        if (e < length) {
            return e - s + 1 > 0;
        }
        return false;
    }
}

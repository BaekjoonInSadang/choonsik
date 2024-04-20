package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class conference {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int timeCnt = Integer.parseInt(bf.readLine());

        int[][] timeList = new int[timeCnt][2];
        for (int i = 0; i < timeCnt; i++) {

            String meetingT = bf.readLine();
            String[] time = meetingT.split(" ");

            int startTime = Integer.parseInt(time[0]);
            int endTime = Integer.parseInt(time[1]);

            timeList[i][0] = startTime;
            timeList[i][1] = endTime;
        }



        System.out.println(Arrays.stream(timeList).toList());
    }
}

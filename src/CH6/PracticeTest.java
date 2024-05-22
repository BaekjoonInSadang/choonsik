package CH6;

import java.util.ArrayList;

public class PracticeTest {
    public static void main(String[] args) {

        int[] answer = {1,1,1};

        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == first[(i%5)]) score[0] ++;
            if (answer[i] == second[(i%8)]) score[1] ++;
            if (answer[i] == third[(i%10)]) score[2] ++;
        }

        int maxScore = Math.max(score[0],Math.max(score[1],score[2]));

//        System.out.println("maxScore = " + maxScore);

        for (int i = 0; i < score.length; i++) {
            if(maxScore == score[i]) result.add(i+1);
//            System.out.println("score[i] = " + score[i]);
        }

//        System.out.println("result = " + result);
    }
}

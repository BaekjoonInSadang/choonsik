package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 백준 문제 : 11068
 */
public class palindrome {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testLength = Integer.parseInt(br.readLine());
        ArrayList<Integer> inputList = new ArrayList<>();

        for (int i=0; i<testLength; i++) {

            int inputNum = Integer.parseInt(br.readLine());
            int result = 0;

            for (int j=2; j<65; j++) {
                inputList.clear();
                int tempNum = inputNum;

                while(true) {

                    int restNum = getRestNum(tempNum, j); // 나머지
                    int dividedNum = getDividedNum(tempNum, j); // 몫



                    if(dividedNum == 0) {
                        inputList.add(restNum);
                        break;
                    } else {
                        inputList.add(restNum);
                    }
                    tempNum = dividedNum;
                }

                int listSize = inputList.size();
                int halfSize = Math.floorDiv(listSize,2);

                for(int k=0; k<halfSize; k++) {
                    if (inputList.get(k).equals(inputList.get(listSize-k-1))) {
                        result = 1;
                    } else {
                        result = 0;
                        break;
                    }
                }
                if(result == 1) {
                    break;
                }

            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }



    private static int getRestNum(int inputNum, int j) {
        return Math.floorMod(inputNum,j);
    }

    private static int getDividedNum(int inputNum, int j) {
        return Math.floorDiv(inputNum,j);
    }
}


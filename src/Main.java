import CH3.PositionT;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");


        PositionT positionTest = new PositionT();
        String[][] inputData = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] solution = positionTest.solution(inputData);
        String string = Arrays.toString(solution);
        System.out.println("string = " + string);

    }
}
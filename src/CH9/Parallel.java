package CH9;

public class Parallel {


    public static void main(String[] args) {

        int answer;

//        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        int[][] dots = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};



        // 첫 번째와 두 번째 좌표 사이의 기울기 계산
        double slope1 = getSlope(dots[0][0], dots[0][1], dots[1][0], dots[1][1]);
        double slope2 = getSlope(dots[2][0], dots[2][1], dots[3][0], dots[3][1]);
        double slope3 = getSlope( dots[0][0], dots[0][1], dots[3][0], dots[3][1]);
        double slope4 = getSlope(dots[1][0], dots[1][1], dots[2][0], dots[2][1]);
        double slope5 = getSlope( dots[0][0], dots[0][1],  dots[3][0], dots[3][1]);
        double slope6 = getSlope( dots[1][0], dots[1][1], dots[2][0], dots[2][1]);


        if (slope1 == slope2 || slope3 == slope4 || slope5 == slope6 ) {
            answer = 1;
        } else {
            answer = 0;
        }

        System.out.println(answer);
    }



    private static double getSlope(int x1, int y1, int x2, int y2) {
        return (double)(x1 - x2) / (y1 - y2);
    }
}

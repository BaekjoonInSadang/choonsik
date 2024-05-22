package CH10;

import java.util.Arrays;

public class IntegerTriangle {
    private static final int[][] mem = new int[501][501];

    private static int max(int x, int y, int[][] triangle) {
        if (y == triangle.length) return 0;
        if (mem[x][y] != -1 ) return mem[x][y];

        return mem[x][y] = triangle[y][x] + Math.max(max(x,y+1,triangle), max(x+1, y+1, triangle));
    }

    public static void main(String[] args) {

        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };


        for (int[] row: mem) {
            Arrays.fill(row, -1);
        }

        System.out.println(max(0,0,triangle));
    }
}

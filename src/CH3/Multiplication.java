package CH3;

import java.util.Arrays;

public class Multiplication {

    private static final int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
    private static final int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

    public static void main(String[] args) {

        int[][] arr = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("[" + j + "," + i + "]");

                System.out.println("arr[i][j] = " + arr[i][j]);

                for (int k = 0; k < arr1[i].length; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                    System.out.println("arr[i][j] = " + arr[i][j]);
                }
            }
        }

        for (int[] ints : arr) {
            System.out.println("ints = " + Arrays.toString(ints));

        }

    }
}

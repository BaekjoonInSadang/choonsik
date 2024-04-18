package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 */
public class numSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] u = new int[n];
        for (int i = 0; i <n ; i++) {
            u[i] = Integer.parseInt(bf.readLine());
        }

        // 두개의 합 배열 만들기
        int[] sum = new int[n * (n+1) / 2];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                sum[index++] = u[i] + u[j];
            }
        }

        Arrays.sort(sum);
        
        int max = -1;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                int target = u[i] - u[j];
                if(Arrays.binarySearch(sum, target) > -1) {
                    max = Math.max(max, u[i]);
                }
            }
        }

        System.out.println(max);

    }
}

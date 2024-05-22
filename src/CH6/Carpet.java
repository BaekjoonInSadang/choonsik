package CH6;

import java.util.ArrayList;

public class Carpet {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        int x = 0;
        int y = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i*i <= yellow; i++) {

            if (yellow % i == 0) {
                x = i;
                y = yellow / i;

                int value =  ((x+2) * (y+2)) - yellow;

                if (value == brown) {
                    result.add(Math.max(y+2, x+2));
                    result.add(Math.min(y+2, x+2));
                    break;
                }
            }
        }


        System.out.println("result = " + result);
    }
}

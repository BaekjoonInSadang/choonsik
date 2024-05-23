package CH11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionProgress {

    public static void main(String[] args) {

        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};


        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < progresses.length; i++) {
            queue.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        int days = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int isExpiration = (int) Math.ceil((double) (100-progresses[index]) / speeds[index]);

            if(days < isExpiration) {
                if(days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = isExpiration;
            }
            count++;
        }


        result.add(count);
        System.out.println("result = " + result.toString());
    }
}
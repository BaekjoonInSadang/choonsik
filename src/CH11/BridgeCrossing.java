package CH11;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeCrossing {

    public static void main(String[] args) {
        int bridgeLength = 100;
        int maxWeight = 100;
        int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> ready = new LinkedList<>();

        // 초기 값 설정
        for (int truckWeight : truckWeights) {
            ready.add(truckWeight);
        }

        int onBridgeWeight = 0;
        int resultCnt = 0;
        int timeCnt = 0;

        while (resultCnt != truckWeights.length) {

            //========================== 다리에서 나가기 =================================
            if (queue.size() == bridgeLength) {
                Integer finishedTruck = queue.poll();
                if (finishedTruck != 0) {
                    onBridgeWeight -= finishedTruck;
                    resultCnt++;
                }
            }

            //========================== 다리에 들어오기 =================================
            int newWeight = !ready.isEmpty() ? ready.peek() : 0;

            // 새로 다리 들어오기
            if (onBridgeWeight + newWeight <= maxWeight && !ready.isEmpty()) {
                queue.add(ready.poll());
                onBridgeWeight += newWeight;
            } else {
                queue.add(0);
            }


            //========================== 다리에서 이동 =================================
            timeCnt++;
        }

        System.out.println("timeCnt = " + timeCnt);
    }
}

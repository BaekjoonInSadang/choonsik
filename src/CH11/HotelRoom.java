package CH11;

import java.util.ArrayList;
import java.util.TreeMap;

public class HotelRoom {
    public static void main(String[] args) {
        long[] room_number = {1,10,4,1,9,8,4,3,4,3,4,4,17,15,7,8,7,6,5,4};
        long k = 30;

        // 1번부터 10번까지 있어
        // TreeSet 으로 1부터 10까지 넣어줘 (자동으로 오름차순)
        TreeMap<Long, Boolean> store = new TreeMap<>();
        for (long i = 1; i < k+1; i++) {
            store.put(i, false);
        }

        // 이제 room_number 에 따라서 result에 넣어줘
        ArrayList<Long> result = new ArrayList<>();
        for (long roomNum : room_number) {
            // store 에 있으면!! 아직 방이 미배정이므로 즉시 배정
            if(store.containsKey(roomNum)) {
                store.remove(roomNum);
                result.add(roomNum);
            } else {
                // 이미 배정된 방이라면
                Long nextRoomNum = store.ceilingKey(roomNum);
                store.remove(nextRoomNum);
                result.add(nextRoomNum);
            }
        }
        System.out.println("result = " + result);

//        return result.stream().mapToLong(Long::longValue).toArray();
    }
}

//
//import java.util.ArrayList;
//import java.util.TreeMap;
//
//class Solution {
//    public long[] solution(long k, long[] room_number) {
//        TreeMap<Long, Boolean> store = new TreeMap<>();
//        for (long i = 1; i < k+1; i++) {
//            store.put(i, false);
//        }
//
//        // 이제 room_number 에 따라서 result에 넣어줘
//        ArrayList<Long> result = new ArrayList<>();
//        for (long roomNum : room_number) {
//            // store 에 있으면!! 아직 방이 미배정이므로 즉시 배정
//            if(store.containsKey(roomNum)) {
//                store.remove(roomNum);
//                result.add(roomNum);
//            } else {
//                // 이미 배정된 방이라면
//                Long nextRoomNum = store.ceilingKey(roomNum);
//                store.remove(nextRoomNum);
//                result.add(nextRoomNum);
//            }
//        }
//        // System.out.println("result = " + result);
//
//        return result.stream().mapToLong(Long::longValue).toArray();
//    }
//
//}

package KAKAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class FeeCalc {

    public static void main(String[] args) {

        String[] records = {
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        };

        int[] table = {180, 5000, 10, 600};

        HashMap<String, Integer> CalcMap = new HashMap<>();
        TreeMap<String, Integer> ResultMap = new TreeMap<>();
        ArrayList<Integer> results = new ArrayList<>();


        // 1단계 : 입/출차 내역이 둘 다 있는 경우 (입차 == 출차)
        for (String record : records) {

            String[] split = record.split(" ");
            String time = split[0];
            String carNum = split[1];
            int timeMin = calcTimeMinute(time);

            // 차 번호가 있을 때
            if (CalcMap.containsKey(carNum)) {
                // 들어온 시간
                int InTime = CalcMap.get(carNum);
                // 주차된 시간
                int ParkingTime = timeMin - InTime;
                // 주차시간 결과 해시맵에 누적
                ResultMap.put(carNum,ResultMap.getOrDefault(carNum, 0) + ParkingTime);
                // carNum 제거
                CalcMap.remove(carNum);
            } else {
                CalcMap.put(carNum,timeMin);
            }
        }

        // 2단계 : 입차내역만 남아있는 내역 계산 (입차만)
        for (String carNum : CalcMap.keySet()) {
            int maxOutTime = 1439;
            int ParkingTime = maxOutTime - CalcMap.get(carNum);
            ResultMap.put(carNum,ResultMap.getOrDefault(carNum, 0) + ParkingTime);
        }

        // 3단계 : ResultMap 에 있는 내역 비용 계산해서  (차번호)
        for (Integer time : ResultMap.values()) {
            // 계산
            int TotalFee = calcParkingFee(time, table);

            // result 에 담기
            results.add(TotalFee);
        }

        System.out.println("ResultMap = " + results.toString());


    }

    // 시간 & 분 -> 분
    private static int calcTimeMinute(String time) {
        String[] timeSplit = time.split(":");
        int hour = Integer.parseInt(timeSplit[0]);
        int minute = Integer.parseInt(timeSplit[1]);
        return hour * 60 + minute;
    }

    // 전체 주차시간으로 비용 계산
    private static int calcParkingFee(int totalTime, int[] table) {
        int freeTime = table[0];
        int basicFee = table[1];
        int perMin = table[2];
        int perFee = table[3];

        // 주차시간이 무료범위 내
        if (totalTime <= freeTime) {
            return basicFee;

        // 주차시간이 무료범위 외
        } else {
            int extraTime = totalTime - freeTime;
            int extraFee = (int) Math.ceil((double) extraTime / perMin) * perFee;
            return basicFee + extraFee;
        }
    }
}

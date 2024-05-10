//package CH7;
//
//import java.util.*;
//
//public class kakao {
//
//    public static int[] main(String[] args) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo", "muzi frodo", "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//        int k = 2;
//
//        Map<String, List<String>> history = new HashMap<>();
//        Map<String, Integer> idMap = new HashMap<>();
//
//        initializeMaps(id_list, history);
//        processReports(report, k, idMap, history);
//        int[] resultArray = new int[id_list.length];
////
//        return getResultArray(id_list, idMap);
//    }
//
//    private static void initializeMaps(String[] id_list, Map<String, List<String>> history) {
//        for (String id : id_list) {
//            history.put(id, new ArrayList<>());
//        }
//    }
//
//    private static void processReports(String[] report, int k, Map<String, Integer> idMap, Map<String, List<String>> history) {
//        for (String s : report) {
//            String[] split = s.split(" ");
//
//            List<String> strings = history.get(split[1]);
//            boolean contains = strings.contains(split[0]);
//
//            if (!contains) {
//                history.get(split[1]).add(split[0]);
//                idMap.put(split[1], idMap.getOrDefault(split[1], 0) + 1);
//            }
//        }
//    }
//
//    private static void getResultArray(String[] id_list, Map<String, Integer> idMap) {
//
//        for (int i = 0; i < id_list.length; i++) {
//            int count = idMap.getOrDefault(id_list[i], 0);
//            resultArray[i] = count;
//        }
//    }
//}

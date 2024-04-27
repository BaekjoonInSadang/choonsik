package TwoPoint;

import java.util.*;

public class test {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        Map<String, List<String>> history = new HashMap<>();
        Map<String, Integer> idMap = new HashMap<>();

        initializeMaps(id_list, history);
        processReports(report, k, idMap, history);

        List<Integer> resultList = new ArrayList<>();
        for (String id : id_list) {
            resultList.add(idMap.getOrDefault(id, 0));
        }

        System.out.println(resultList);
    }

    private static void initializeMaps(String[] id_list, Map<String, List<String>> history) {
        for (String id : id_list) {
            history.put(id, new ArrayList<>());
        }
    }

    private static void processReports(String[] report, int k, Map<String, Integer> idMap, Map<String, List<String>> history) {
        for (String s : report) {
            String[] split = s.split(" ");
            history.get(split[1]).add(split[0]);
            idMap.put(split[1], idMap.getOrDefault(split[1], 0) + 1);
        }
    }
}
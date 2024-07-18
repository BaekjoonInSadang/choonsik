package CH11;

import java.util.*;

public class ToPointerGems {

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"};

        Set<String> set = new HashSet<>(List.of(gems));

        int start = 0;
        int end = gems.length - 1;


        int s = 0;
        int e = s;

        HashMap<String, Integer> includes = new HashMap<>();
        includes.put(gems[s],1);

        // 투포인터 시작
        while (s< gems.length) {
            if(includes.keySet().size() == set.size()) {
                // 모든 보석이 다 들어있는 경우
                if( e - s < end - start) {
                    start = s;
                    end = e;
                }

                includes.put(gems[s], includes.get(gems[s]) - 1);
                if(includes.get(gems[s]) == 0) {
                    includes.remove(gems[s]);
                }
                s++;

            } else if ( e < gems.length -1) {
                e++;
                includes.put(gems[e], includes.getOrDefault(gems[e],0) + 1);

            } else {
                break;
            }
        }
    }
}

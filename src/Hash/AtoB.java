package Hash;

import java.util.HashMap;

public class AtoB {
    public static void main(String[] args) {
        String A = "olleh";
        String B = "hello";
        int answer = 1;

        HashMap<String, Integer> check = new HashMap<>();

        if(A.length() != B.length()) {
            answer = 0;

            System.out.println("일치하지 않음 미리");
        } else {
            String[] splitA = A.split("");
            String[] splitB = B.split("");

            for (String s : splitA) {
                check.put(s, check.getOrDefault(s,0)+1);
            }

            for (String s : splitB) {

                if (check.containsKey(s)) {
                    check.put(s, check.getOrDefault(s,0) -1);

                } else {
                    answer = 0;
                    System.out.println("일치하지 않음 후후");
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}

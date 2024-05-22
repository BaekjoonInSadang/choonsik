package CH9;

import java.util.HashSet;

public class duplicateString {
    public static void main(String[] args) {

        String A = "b a n ana";
        StringBuilder answer = new StringBuilder();

        HashSet<Character> setValue = new HashSet<>();

        // 문자열을 char 배열로 변환하여 각 문자를 처리
        char[] charArray = A.toCharArray();
        for (char c : charArray) {
            // HashSet에 해당 문자가 이미 존재하면 넘어감
            if (setValue.contains(c)) {
                continue;
            }
            // HashSet에 추가하고 정답 문자열에 추가
            setValue.add(c);
            answer.append(c);
        }

        System.out.println(answer);

    }
}

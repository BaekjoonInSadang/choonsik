package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 1181
 */
public class word {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<String> messageList = new ArrayList<>();

        int ListCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i<ListCnt; i++) {
            String word = br.readLine();
            messageList.add(word);
        }

        messageList.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder())) // 길이순 정렬 후 사전순 정렬
                .forEach(System.out::println); // 각 요소 출력
    }
}

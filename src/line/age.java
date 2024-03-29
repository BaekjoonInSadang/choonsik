package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 백준 10814
 */
public class age {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<String> messageList = new ArrayList<>();

        int ListCnt = Integer.parseInt(br.readLine());


        List<String> collect = br.lines()
                .limit(ListCnt)
                .map(line -> line.split(" "))
                .sorted(Comparator.comparingInt(age -> Integer.parseInt(age[0])))
                .map(name -> name[0] + " " +name[1])
                .collect(Collectors.toList());

        for (String s : collect) {
            System.out.println(s);
        }
    }
}

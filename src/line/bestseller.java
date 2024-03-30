package line;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1302 문제
 */
public class bestseller {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int bookCnt = Integer.parseInt(bf.readLine());

        // 입력받은 책의 개수만큼 책의 제목을 읽고 리스트에 저장
        String mostFrequentBook = bf.lines()
                .limit(bookCnt) // 책의 개수만큼만 처리
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream() // 키 밸류 형태 stream 만들기
                .sorted(Map.Entry.comparingByKey()) // 키(책의 이름)를 기준으로 사전순으로 정렬
                .max(Map.Entry.comparingByValue()) // 값(책의 등장 횟수)을 기준으로 최대 값을 가진 엔트리를 찾음
                .map(Map.Entry::getKey) // 해당 엔트리의 키(책의 이름)를 추출
                .orElse(null); // 만약 최대 값이 없다면 null 반환

        System.out.println(mostFrequentBook);
    }
}

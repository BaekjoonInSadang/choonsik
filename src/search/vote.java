package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 백준 2817 문제
 * 문제 : ALPS식 투표
 *
 * 1) 우선 참가자들수들이 스탭에게 각각 투표한다
 *  1-1) 스탭마다 리스트에 추가 (스탭 인원수만큼 for문)
 *
 * 2) 각각 스탭에 따라서 참가자수의 5% 미만이면 탈락 (참가자의 5% 미만의 투표를 받은 스태프는 제외)
 *
 * 3) 살아남은 스태프들은 자기가 받은 투표수를 1~14 로 나눈 값을 가짐
 *
 * 10개 []
 *  ex) 1번 스태프 500 (7쿠폰)
 *  1 - 50    (1)
 *  2 - 25    (3)
 *  3 - 16    (5)
 *  4 - 12    (7)
 *  5 - 10    (9)
 *  6 - 8
 *  7 - 7
 *  8 - 6
 *  9 - 5
 *  10 - 5
 *  11 - 4
 *  12 - 4
 *  13 - 4
 *  14 - 3
 *
 *  ex) 2번 스태프 40 (7)
 * 1 - 40 (2)
 * 2 - 20 (4)
 * 3 - 13 (6)
 * 4 - 10 (8)
 * 5 - 8
 * 6 - 6
 * 7 - 5
 * 8 - 5
 * 9 - 4
 * 10 - 4
 * 11 - 3
 * 12 - 3
 * 13 - 3
 * 14 - 2
 *
 *
 * 3-1) 스태프별로 자기가 가진 가장 큰수를 max값으로 지정 ()
 *
 * 4) 스태프별로 가장 큰 값을 비교해서 가장 큰 값을 가진사람에게 +1 (총 14회 반복)
 *
 */
public class vote {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        ArrayList<Integer> inputList = new ArrayList<>();

    }
}

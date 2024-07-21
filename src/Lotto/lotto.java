package Lotto;


import java.util.*;

/**
 * 로또 번호 만들기
 * <p>
 * 1부터 45 숫자까지 나열해두고 여기서 랜덤으로  6자리를 선택
 */
public class lotto {

    public static void main(String[] args) {

        /**
         * 한번에 로또 5개 받기
         */
//        List<List<Integer>> integers = lottoCalcV1();
//        System.out.println(" ===== [1등 당첨 번호 리스트] ===== ");
//        for (List<Integer> integer : integers) {
//            System.out.println(" 당첨 번호 " + integer);
//        }

        /**
         * 하나씩 받기
         */
//        LottoGenerator lottoGenerator = new LottoGenerator();
//
//
//        for (int i = 0; i < 5; i++) {
//            int[] generate = lottoGenerator.generate();
//            System.out.println(" 당첨 번호 " + Arrays.toString(generate));
//        }

        /**
         * 연금 복권
         */
        SixNumGenerator sixNum = new SixNumGenerator();
        Random random = new Random();
        int[] generate = sixNum.generate();
        int number = random.nextInt(5) + 1;
        System.out.println(" 럭키 연금 복권 번호 " + "[" + number + "조]" + Arrays.toString(generate));
    }

    /**
     * 45개 숫자를 한번에 5셋트 뽑아주는 방법
     */
    public static List<List<Integer>> lottoCalcV1() {

        int initNum = 0;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        ArrayList<List<Integer>> luckyLottoList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<Integer> integers = numbers.subList(initNum, initNum + 6);
            luckyLottoList.add(integers);
            initNum += 6;
        }

        return luckyLottoList;
    }

    public static class LottoGenerator {
        private final Random random = new Random();
        private int[] lottoNumbers;
        private int count;

        public int[] generate() {
            lottoNumbers = new int[6];
            count = 0;

            while (count < 6) {
                int number = random.nextInt(45) + 1;

                if (isUnique(number)) {
                    lottoNumbers[count] = number;
                    count++;
                }
            }

            return lottoNumbers;
        }

        private boolean isUnique(int number) {
            for (int i = 0; i < count; i++) {
                if (lottoNumbers[i] == number) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class SixNumGenerator {
        private final Random random = new Random();
        private int[] lottoNumbers;
        private int count;

        public int[] generate() {
            lottoNumbers = new int[6];
            count = 0;

            while (count < 6) {
                int number = random.nextInt(10);

                if (isUnique(number)) {
                    lottoNumbers[count] = number;
                    count++;
                }
            }

            return lottoNumbers;
        }

        private boolean isUnique(int number) {
            for (int i = 0; i < count; i++) {
                if (lottoNumbers[i] == number) {
                    return false;
                }
            }
            return true;
        }
    }
}

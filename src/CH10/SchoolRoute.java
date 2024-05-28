package CH10;

public class SchoolRoute {

    public static void main(String[] args) {

        int m = 5;
        int n = 6;
        int[][] puddles = {{2,2},{3,3}};

        int[][] ints = new int[n][m];

        for (int i = 0; i <ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {


                boolean checkPuddles = false;

                for (int[] puddle : puddles) {
                    int x = puddle[0]-1; // 배열은 0부터 시작하므로 1을 빼줌
                    int y = puddle[1]-1;

                    if(i == x && j == y) {
                        checkPuddles = true;
                    }
                }

                if(checkPuddles) {
                    ints[i][j] = 0;
                    continue;
                }



                if (i == 0 && j == 0) {
                    ints[0][0] = 1;
                    continue;
                }

                int topValue = 0;
                int leftValue = 0;

                if (j >= 1) {
                    leftValue = ints[i][j-1];
                }
                if (i >= 1) {
                    topValue = ints[i-1][j];
                }

                ints[i][j] = topValue + leftValue;

            }
        }

        for (int[] anInt : ints) {
            System.out.println("["+ anInt[0] + "," + anInt[1]+ "," + anInt[2]+ "," + anInt[3]+"]");
        }
    }
}

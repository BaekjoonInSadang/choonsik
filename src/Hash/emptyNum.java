package Hash;

public class emptyNum {

    public static void main(String[] args) {

        int answer = 45;

        int[] req = {1,2,3,5,6,8,9};

        for (int i : req) {
            answer -= i;
        }

        System.out.println(answer);
    }
}

package CH9;

import java.util.HashSet;

public class runner {
    public static void main(String[] args) {

        String[] participant = {"deny", "claw", "joe"};
        String[] complete = {"deny", "claw"};

        HashSet<String> set = new HashSet<>();

        for (String s : participant) {
            set.add(s);
        }

        for (String s : complete) {
            set.remove(s);
        }

        System.out.println(set.toString());

        String string = set.toString();
        System.out.println(string);

    }
}

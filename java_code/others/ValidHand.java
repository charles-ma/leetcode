import java.util.*;

public class ValidHand {
    public static void main(String... args) {
        String[] tests = new String[]{"11122", "1122", "33333355666"};
        ValidHand vh = new ValidHand();
        for (String t : tests) {
            System.out.print(vh.solve(t) + ", ");
        }
    }

    private boolean solve(String s) {
        int i = 0;
        boolean pairSeen = false;

        while (i < s.length()) {
            int start = i;
            while (i < s.length() && s.charAt(i) == s.charAt(start)) i++;
            int n = (i - start) % 3;
            if (n == 1) return false;
            if (n == 2) {
                if (pairSeen) return false;
                pairSeen = true;
            }
        }

        return true;
    }
}

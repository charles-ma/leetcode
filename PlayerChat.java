import java.util.*;

public class PlayerChat {
    public static void main(String... args) {
        String[] tests = new String[]{"chatchat", "chcathat", "chatchht"};
        for (String t : tests) {
            System.out.println(new PlayerChat().solve(t));
        }
    }

    private int solve(String input) {
        List<String> l = new ArrayList<String>();
        String chat = "chat";
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'c') {
                l.add(Character.toString(c));
            } else {
                boolean match = false;
                for (int j = 0; j < l.size(); j++) {
                    String sub = l.get(j);
                    if (chat.equals(sub + c)) {
                        l.remove(j);
                        match = true;
                        break;
                    } else if (chat.indexOf(sub + c) == 0) {
                        l.set(j, sub + c);
                        match = true;
                        break;
                    }
                }
                if (!match) return -1;
            }
            min = Math.max(min, l.size());
        }

        return min;
    }
}

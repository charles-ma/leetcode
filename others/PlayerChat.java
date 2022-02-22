import java.util.*;

// The string chatOfPlayers represents a combination of the string "chat" from
// different players. Any player can say "chat", and if multiple players say
// "chat" at the same time, the letters of "chat" can overlap. Return the minimum
// number of different players to finish all the "chat"s in the given string.
// A valid "chat" means a player is printing 4 letters ‘c’, ’h’, ’a’, ’t’
// sequentially. The players have to print all four letters to finish a
// chat. If the given string is not a combination of valid "chat" return -1.

// Example 1:
// Input: chatOfPlayers = "chatchat"
// Output: 1
// Explanation: One player yelling "chat" twice.

// Example 2:
// Input: chatOfPlayers = "chcathat"
// Output: 2
// Explanation: The minimum number of players is two.
// The first player could yell "CHcAThat".
// The second player could yell later "chCatHAT".

// Example 3:
// Input: chatOfPlayers = "chatchht"
// Output: -1
// Explanation: The given string is an invalid combination of "chat" from different players.


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

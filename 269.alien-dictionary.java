/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */

// @lc code=start
class Solution {
    Map<Character, Set<Character>> in = new HashMap<Character, Set<Character>>();
    Map<Character, Set<Character>> out = new HashMap<Character, Set<Character>>();
    Set<Character> dic = new HashSet<Character>();
    
    public String alienOrder(String[] words) {

        // words only contains 1 string
        if (words.length == 1) {
            for (int k = 0; k < words[0].length(); k++) {
                // collect alien letters
                dic.add(words[0].charAt(k));
            }
        }

        // words contains more than 1 string
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int j = 0;
            while (j < w1.length() && j < w2.length()) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                dic.add(c1); dic.add(c2);
                if (c1 != c2) {
                    Set<Character> s = in.getOrDefault(c2, new HashSet<Character>());
                    s.add(c1);
                    in.put(c2, s);
                    Set<Character> s1 = out.getOrDefault(c1, new HashSet<Character>());
                    s1.add(c2);
                    out.put(c1, s1);
                    break;
                }
                j++;
            }

            // input is invalid, "abc" -> "ab"
            if (j == w2.length() && j < w1.length()) return "";

            // collect alien letters
            int p1 = j, p2 = j;
            while (p1 < w1.length()) {
                dic.add(w1.charAt(p1++));
            }
            
            while (p2 < w2.length()) {
                dic.add(w2.charAt(p2++));
            }
        }

        char[] result = new char[dic.size()];
        int p = 0;
        Queue<Character> q = new LinkedList<Character>();
        for (Character c : dic) {
            // in-degree is 0
            if (!in.containsKey(c) || in.get(c).size() == 0) {
                q.offer(c);
            }
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            Set<Character> sub = new HashSet<Character>();
            for (int i = 0; i < size; i++) {
                Character c = q.poll();
                result[p++] = c.charValue();

                if (out.containsKey(c)) {
                    for (Character c1 : out.get(c)) {
                        if (in.containsKey(c1)) {
                            in.get(c1).remove(c);
                        }
                        sub.add(c1);
                    }
                }
            }

            for (Character n : sub) {
                // in-degree is 0
                if (!in.containsKey(n) || in.get(n).size() == 0) q.offer(n);
            }
        }

        // if result doesn't contains all letters in dic, return empty string;
        // if not, return one valid ordering
        return p == dic.size() ? new String(result) : "";
    }
}
// @lc code=end

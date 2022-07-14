/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> m = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            int c = m.getOrDefault(t.charAt(i), 0);
            m.put(t.charAt(i), ++c);
        }

        String result = s + t;
        int p1 = 0, p2 = 0;
        while (p2 < s.length()) {
            char c = s.charAt(p2++);
            if (m.containsKey(c)) {
                m.put(c, m.get(c) - 1);
            }

            while (p1 < p2 && containsAll(m)) {
                if (p2 - p1 < result.length()) {
                    result = s.substring(p1, p2);
                }
                char c1 = s.charAt(p1++);
                if (m.containsKey(c1)) {
                    m.put(c1, m.get(c1) + 1);
                }
            }
        }

        return result.equals(s + t) ? "" : result;
    }

    private boolean containsAll(Map<Character, Integer> m) {
        for (Character c : m.keySet()) {
            if (m.get(c) > 0)
                return false;
        }
        return true;
    }
}
// @lc code=end

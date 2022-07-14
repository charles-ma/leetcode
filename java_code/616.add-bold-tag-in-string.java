/*
 * @lc app=leetcode id=616 lang=java
 *
 * [616] Add Bold Tag in String
 */

// @lc code=start
class Solution {
    public String addBoldTag(String s, String[] words) {
        int size = s.length();
        boolean[] dp = new boolean[size];

        int p = 0;
        for (int i = 0; i < size; i++) {
            for (String w : words) {
                if (s.startsWith(w, i)) p = Math.max(p, i + w.length());
            }
            if (i < p) dp[i] = true;
        }

        int k = 0;
        StringBuilder sb = new StringBuilder();
        while (k < size) {
            int r = k;
            while (r < size && dp[r]) r++;

            if (r != k) {
                sb.append("<b>" + s.substring(k, r) + "</b>");
                k = r;
            } else {
                sb.append(s.charAt(r));
                k++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

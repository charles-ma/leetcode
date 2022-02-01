/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, h = i;
            while (l >= 0 && h < s.length()) {
                if (s.charAt(l--) == s.charAt(h++)) sum++;
                else break;
            }

            l = i;
            h = i + 1;
            while (l >= 0 && h < s.length()) {
                if (s.charAt(l--) == s.charAt(h++)) sum++;
                else break;
            }
        }

        return sum;
    }
}
// @lc code=end

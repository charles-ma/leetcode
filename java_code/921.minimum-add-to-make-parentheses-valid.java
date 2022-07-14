/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        return count(s, ')') + count(new StringBuilder(s).reverse().toString(), '(');
    }

    private int count(String s, char p) {
        int c = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != p) c++;
            else c--;
            if (c < 0) {
                result++;
                c = 0;
            }
        }

        return result;
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        String tmp = helper(s, ')');
        return new StringBuilder(helper(new StringBuilder(tmp).reverse().toString(), '(')).reverse().toString();
    }

    private String helper(String s, char c) {
        int i = 0, count = 0;
        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '(') {
                if (ch != c) count++;
                else count--;
                if (count < 0) {
                    count = 0;
                    i++; continue;
                }
            }

            sb.append(ch);
            i++;
        }

        return sb.toString();
    }
}
// @lc code=end

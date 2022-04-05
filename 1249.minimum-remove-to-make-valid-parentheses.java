/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        return removeParen(removeParen(s, '('), ')');
    }

    private String removeParen(String s, char p) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (c == p) {
                    count++;
                } else {
                    count--;
                    if (count < 0) {
                        count = 0;
                        continue;
                    }
                }
            }
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

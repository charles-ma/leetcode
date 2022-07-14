/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        return remove(remove(s, '('), ')');
    }

    private String remove(String s, char p) {
        int c = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                if (ch == p) {
                    c++;
                } else {
                    c--;
                }

                if (c < 0) {
                    c = 0;
                    continue;
                }
            }
            sb.insert(0, ch);
        }

        return sb.toString();
    }
}
// @lc code=end

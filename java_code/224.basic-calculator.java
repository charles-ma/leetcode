/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int sum = 0;
        int cs = 1;

        int i = 0;
        while (i < s.length()) {
            if (isSign(s.charAt(i))) {
                if (s.charAt(i) == '-') {
                    cs = -1;
                } else {
                    cs = 1;
                }
                i++;
                continue;
            }

            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            if (s.charAt(i) == '(') {
                int start = i;
                int stack = 0;
                while (i < s.length()) {
                    if (s.charAt(i) == '(') stack++;
                    if (s.charAt(i) == ')') stack--;
                    if (stack == 0) {
                        sum += cs * calculate(s.substring(start + 1, i));
                        break;
                    }
                    i++;
                }
                i++;
                continue;
            }

            if (isDigit(s.charAt(i))) {
                int start = i;
                while (i < s.length() && isDigit(s.charAt(i))) {
                    i++;
                }
                sum += cs * Integer.parseInt(s.substring(start, i));
                continue;
            }
        }
        return sum;
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }
}
// @lc code=end

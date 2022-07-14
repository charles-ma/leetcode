/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sum = 0;
        while (i < s.length()) {
            while (i < s.length() && isWhiteSpace(s.charAt(i)))
                i++;

            int sign = 1;
            if (i < s.length() && isSign(s.charAt(i))) {
                if (s.charAt(i++) == '-')
                    sign = -1;
            }

            if (i < s.length() && !isDigit(s.charAt(i)))
                return 0;

            if (i < s.length() && isDigit(s.charAt(i))) {
                while (i < s.length() && isDigit(s.charAt(i))) {
                    int v = (int) (s.charAt(i) - '0');
                    if (sum > Integer.MAX_VALUE / 10
                        || (sum == Integer.MAX_VALUE / 10 && v > 7)) {
                        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    sum = sum * 10 + v;
                    i++;
                }
                return sum * sign;
            }
        }
        return sum;
    }

    private boolean isWhiteSpace(char c) {
        return c == ' ';
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
// @lc code=end

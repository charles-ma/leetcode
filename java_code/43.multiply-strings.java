/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();

        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c1 = num1.charAt(i);
                char c2 = num2.charAt(j);
                int n1 = (int) (c1 - '0');
                int n2 = (int) (c2 - '0');
                int v = (n1 * n2) + result[i + j + 1];
                result[i + j + 1] = v % 10;
                result[i + j] += v / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : result) {
            if (!(sb.length() == 0 && p == 0))
                sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end

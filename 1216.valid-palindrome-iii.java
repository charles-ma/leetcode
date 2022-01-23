/*
 * @lc app=leetcode id=1216 lang=java
 *
 * [1216] Valid Palindrome III
 */

// @lc code=start
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        // DFS solution
        // Queue<int[]> q = new LinkedList<int[]>();
        // q.offer(new int[]{0, s.length() - 1});
        // int level = 0;

        // while (q.size() != 0 && level <= k) {
        //     int size = q.size();
        //     for (int i = 0; i < size; i++) {
        //         int[] v = q.poll();
        //         int x = v[0], y = v[1];
        //         while (x < y) {
        //             if (s.charAt(x) != s.charAt(y)) {
        //                 q.offer(new int[]{x + 1, y});
        //                 q.offer(new int[]{x, y - 1});
        //                 break;
        //             }
        //             x++; y--;
        //         }
        //         if (x >= y) return true;
        //     }
        //     level++;
        // }

        // return false;

        // Persue the longest common subsequence of the given string and its reverse
        int n = s.length();
        String s1 = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s.charAt(i - 1) == s1.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j -1]);
            }
        }

        return n - dp[n][n] <= k;
    }
}
// @lc code=end

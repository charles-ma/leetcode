/*
 * @lc app=leetcode id=2076 lang=java
 *
 * [2076] Process Restricted Friend Requests
 */

// @lc code=start
class Solution {
    private int[] dp;
    
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = i;

        boolean[] result = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int[] req = requests[i];
            int x = req[0], y = req[1];
            int r1 = findRoot(x), r2 = findRoot(y);
            
            boolean conflict = false;
            for (int j = 0; j < restrictions.length; j++) {
                int[] res = restrictions[j];
                int t1 = findRoot(res[0]);
                int t2 = findRoot(res[1]);

                if ((r1 == t1 && r2 == t2) ||
                    (r1 == t2 && r2 == t1)) {
                    conflict = true;
                }
            }

            if (!conflict) {
                result[i] = true;
                dp[r2] = r1;
            }
        }

        return result;
    }

    private int findRoot(int index) {
        if (dp[index] == index) return index;
        return findRoot(dp[index]);
    }
}
// @lc code=end

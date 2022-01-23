/*
 * @lc app=leetcode id=1891 lang=java
 *
 * [1891] Cutting Ribbons
 */

// @lc code=start
class Solution {
    public int maxLength(int[] ribbons, int k) {
        long max = Long.MIN_VALUE;
        long sum = 0;

        for (int r : ribbons) {
            max = Math.max((long)r, max);
            sum += r;
        }

        if (k > sum) return 0;
        
        long i = 1, j = max;
        while (i < j) {
            long mid = i + (j - i) / 2 + 1;
            long c = 0;
            for (int r : ribbons) {
                c += r / mid;
            }

            if (c >= k) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }

        return (int)i;
    }
}
// @lc code=end

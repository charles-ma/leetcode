/*
 * @lc app=leetcode id=896 lang=java
 *
 * [896] Monotonic Array
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] nums) {
        int d = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff != 0) {
                if (diff * d < 0) return false;
                if (d == 0) d = diff;
            }
        }

        return true;
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;

        while (i < nums.length && j < nums.length) {
            while (j < nums.length
                   && (nums[j] == 1 || (nums[j] == 0 && k > 0))) {
                if (nums[j++] == 0) k--;
            }

            max = Math.max(max, j - i);

            while (i < nums.length && k == 0) {
                 if (nums[i++] == 0) k++;
            }
        }

        return max;
    }
}
// @lc code=end

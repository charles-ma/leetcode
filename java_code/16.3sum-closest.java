/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int p1 = i + 1, p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[i] + nums[p1] + nums[p2];
                if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;

                if (sum < target) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        return result;
    }
}
// @lc code=end

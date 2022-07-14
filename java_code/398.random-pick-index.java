/*
 * @lc app=leetcode id=398 lang=java
 *
 * [398] Random Pick Index
 */

// @lc code=start
class Solution {
    private int[] nums;
    private Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int c = 1;
        int r = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;

            if (rand.nextInt(c++) == 0) {
                r = i;
            }
        }

        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

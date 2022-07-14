/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int max1 = 0, max2 = 0;
        int i = 0, j = height.length - 1;
        int sum = 0;

        while (i <= j) {
            if (height[i] < height[j]) {
                max1 = Math.max(max1, height[i]);
                sum += max1 - height[i++];
            } else {
                max2 = Math.max(max2, height[j]);
                sum += max2 - height[j--];
            }
        }

        return sum;
    }
}
// @lc code=end

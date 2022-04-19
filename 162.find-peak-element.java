/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;

            // if (mid == 0) {
            //     if (mid == nums.length - 1) return mid;
            //     if (nums[mid + 1] > nums[mid]) i = mid + 1;
            //     else return mid;
            // } else if (mid == nums.length - 1) {
            //     if (nums[mid - 1] > nums[mid]) j = mid - 1;
            //     else return mid;
            // } else {
            //     if (nums[mid + 1] > nums[mid]) i = mid + 1;
            //     else if (nums[mid + 1] < nums[mid] && nums[mid] > nums[mid - 1]) return mid;
            //     else j = mid - 1;
            // }
            
            // int v = nums[mid];
            // int a = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            // int b = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];

            // if (v > a && v > b) return mid;
            // if (v < b) i = mid + 1;
            // else j = mid - 1;

            if (nums[mid] < nums[mid + 1]) i = mid + 1;
            else j = mid;
        }

        return i;
    }
}
// @lc code=end

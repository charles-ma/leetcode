/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                j = mid;
            }
        }
        if (j >= 0 && j < nums.length && nums[j] == target) result[0] = j;

        i = 0; j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2 + 1;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        if (j >= 0 && j <nums.length && nums[j] == target) result[1] = j;

        return result;
    }
}
// @lc code=end

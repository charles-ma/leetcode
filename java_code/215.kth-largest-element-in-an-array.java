/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        helper(nums, nums.length - k, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void helper(int[] nums, int k, int start, int end) {
        int v = partition(nums, k, start, end);
        if (v < k) {
            helper(nums, k, v + 1, end);
        } 
        if (v > k) {
            helper(nums, k, start, v - 1);
        }
    }

    private int partition(int[] nums, int k, int start, int end) {
        if (start > end) return -1;

        int pivot = nums[end];
        int p = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, p++, i);
            }
        }
        swap(nums, p, end);
        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

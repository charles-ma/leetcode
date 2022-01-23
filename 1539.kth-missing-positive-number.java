/*
 * @lc app=leetcode id=1539 lang=java
 *
 * [1539] Kth Missing Positive Number
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;
            int v = arr[mid] - mid - 1;

            if (v < k) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        int delta = arr[i] - i - 1;
        return delta < k ? k + i + 1 : k + i;
    }
}
// @lc code=end

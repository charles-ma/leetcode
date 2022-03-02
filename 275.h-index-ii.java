/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] < citations.length - i) return citations.length - i - 1;
        }
        return citations.length;
    }
}
// @lc code=end

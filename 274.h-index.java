/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int[] buckets = new int[citations.length + 1];
        for (int c : citations) {
            if (c >= citations.length) buckets[citations.length]++;
            else buckets[c]++;
        }

        int v = 0;
        for (int i = citations.length; i >= 0; i--) {
            v += buckets[i];
            if (v >= i) return Math.min(v, i);
        }

        return 0;
    }
}
// @lc code=end

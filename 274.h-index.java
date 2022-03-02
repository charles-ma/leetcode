/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int c : citations) {
            if (c >= n) bucket[n]++;
            else bucket[c]++;
        }

        int h = 0;
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count > i) return Math.max(i, h);
            else h = count;
        }

        return 0;
    }
}
// @lc code=end

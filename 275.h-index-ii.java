/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        // for (int i = citations.length - 1; i >= 0; i--) {
        //     if (citations[i] < citations.length - i) return citations.length - i - 1;
        // }
        // return citations.length;
        int i = 0, j = citations.length - 1;
        if (citations[j] == 0) return 0;

        while (i < j) {
            int mid = i + ((j - i) >> 1);
            if (citations[mid] >= citations.length - mid) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        return citations.length - j;
    }
}
// @lc code=end

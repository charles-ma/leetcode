/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    private int[] sums;
    Random r;
    
    public Solution(int[] w) {
        sums = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            sums[i] = sum;
        }

        r = new Random();
    }
    
    public int pickIndex() {
        int v = r.nextInt(sums[sums.length - 1]) + 1;

        int i = 0, j = sums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;

            if (sums[mid] < v) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

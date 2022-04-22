/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    private int[] w;
    private Random r;
    private int sum;
    
    public Solution(int[] w) {
        this.w = w;
        this.r = new Random();
        for (int i = 0; i < this.w.length; i++) {
            this.sum += this.w[i];
            this.w[i] = this.sum;
        }
    }

    public int pickIndex() {
        int n = r.nextInt(sum) + 1;
        int i = 0, j = w.length;

        while (i < j) {
            int mid = i + (j - i) / 2;
            
            if (w[mid] < n) i = mid + 1;
            else j = mid;
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

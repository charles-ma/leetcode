/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double add = 1;
        if (n < 0) {
            n = -(n + 1);
            x = 1 / x;
            add = x;
        }
        
        if (n % 2 == 0) return myPow(x * x, n / 2) * add;
        else return myPow(x * x, n / 2) * x * add;
    }
}
// @lc code=end

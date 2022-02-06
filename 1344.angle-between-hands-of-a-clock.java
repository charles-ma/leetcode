/*
 * @lc app=leetcode id=1344 lang=java
 *
 * [1344] Angle Between Hands of a Clock
 */

// @lc code=start
class Solution {
    public double angleClock(int hour, int minutes) {
        double minD = (double) minutes;
        double minA = minD / 60;

        double hourD = (double) (hour == 12 ? 0 : hour);
        double hourA = hourD / 12;

        double adjust = minA * 30;

        double r = Math.abs((hourA - minA) * 360 + adjust);
        return Math.min(360 - r, r);
    }
}
// @lc code=end

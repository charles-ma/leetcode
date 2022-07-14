/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int sum = 0;
        while (i < flowerbed.length) {
            int c = 0;
            while (i < flowerbed.length && flowerbed[i] == 0) {
                if (!(i - 1 >= 0 && flowerbed[i - 1] == 1) &&
                        !(i + 1 < flowerbed.length && flowerbed[i + 1] == 1))
                    c++;

                i++;
            }
            i++;

            sum += c / 2 + c % 2;
        }

        return sum >= n;
    }
}
// @lc code=end

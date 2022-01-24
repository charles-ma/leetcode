/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<int[]>();

        while (i < firstList.length && j < secondList.length) {
            int[] f = firstList[i];
            int[] s = secondList[j];

            if (!(f[0] > s[1] || s[0] > f[1])) {
                result.add(new int[]{Math.max(f[0], s[0]), Math.min(f[1], s[1])});
            }

            if (s[1] > f[1]) i++;
            else j++;
        }

        int[][] r = new int[result.size()][2];
        result.toArray(r);
        return r;
    }
}
// @lc code=end

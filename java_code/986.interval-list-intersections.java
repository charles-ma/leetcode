/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<int[]>();
        int p = 0, q = 0;

        while (p < firstList.length && q < secondList.length) {
            int[] a1 = firstList[p];
            int[] a2 = secondList[q];

            if (a1[1] >= a2[0] && a2[1] >= a1[0])
                result.add(new int[]{Math.max(a1[0], a2[0]), Math.min(a1[1], a2[1])});

            if (a1[1] < a2[1]) p++;
            else q++;
        }

        int[][] r = new int[result.size()][];
        result.toArray(r);
        return r;
    }
}
// @lc code=end

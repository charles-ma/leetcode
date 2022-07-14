/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        helper(points, 0, points.length - 1, k - 1);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void helper(int[][] points, int i, int j, int k) {
        int v = select(points, i, j);

        if (v < k) {
            helper(points, v + 1, j, k);
        } else if (v > k) {
            helper(points, i, v - 1, k);
        }
    }

    private int select(int[][] points, int start, int end) {
        if (start > end) return -1;
        
        int p = start;
        for (int i = start; i < end; i++) {
            if (isCloserToOrigin(points[i], points[end])) {
                swap(i, p++, points);
            }
        }

        swap(end, p, points);

        return p;
    }

    private void swap(int x, int y, int[][] a) {
        int[] tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private boolean isCloserToOrigin(int[] a, int[] b) {
        return getDistance(a) - getDistance(b) < 0;
    }
}
// @lc code=end

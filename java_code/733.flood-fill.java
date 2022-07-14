/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (color != newColor) helper(image, sr, sc, color, newColor, dirs);
        return image;
    }

    private void helper(int[][] image, int x, int y, int color, int newColor, int[][] dirs) {
        if (x < 0 || x >= image.length || y < 0 ||
            y >= image[x].length || image[x][y] != color) return;

        image[x][y] = newColor;
        for (int[] dir : dirs) {
            helper(image, x + dir[0], y + dir[1], color, newColor, dirs);
        }
    }
}
// @lc code=end

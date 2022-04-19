/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Set<Integer> visited = new HashSet<Integer>();
        int count = 1;
        Queue<int[]> q = new LinkedList<int[]>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1},
                                   {1, -1}, {-1, 1}};

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        q.offer(new int[]{0, 0});
        visited.add(0);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == n - 1 && curr[1] == n - 1) return count;
                for (int[] dir : dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];

                    if (x >= n || y >= n || x < 0 || y < 0 || grid[x][y] == 1) continue;
                    if (visited.contains(x * n + y)) continue;
                    visited.add(x * n + y);
                    q.offer(new int[]{x, y});
                }
            }
            count++;
        }

        return -1;
    }
}
// @lc code=end

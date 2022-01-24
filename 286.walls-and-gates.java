/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 */

// @lc code=start
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<int[]>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                int rm = rooms[i][j];
                if (rm == 0) q.offer(new int[]{i, j});
            }
        }

        int level = 1;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] n = q.poll();
                int x = n[0], y = n[1];

                for (int[] dir : dirs) {
                    int x1 = x + dir[0], y1 = y + dir[1];
                    if (x1 >= 0 && x1 < rooms.length
                        && y1 >= 0 && y1 < rooms[x].length) {
                        if (rooms[x1][y1] == Integer.MAX_VALUE) {
                            q.offer(new int[]{x1, y1});
                            rooms[x1][y1] = level;
                        }
                    }
                }
            }
            level++;
        }
    }
}
// @lc code=end

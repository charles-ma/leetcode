/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 */

// @lc code=start
class Solution {

    class Node {
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        int x, y, cost;
    }

    public int swimInWater(int[][] grid) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(1, (n1, n2) -> n1.cost - n2.cost);
        if (grid.length == 0)
            return 0;

        pq.offer(new Node(0, 0, grid[0][0]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (pq.size() != 0) {
            Node n = pq.poll();
            if (n.x == grid.length - 1 && n.y == grid[0].length - 1) {
                return n.cost;
            }

            for (int[] dir : dirs) {
                int x = n.x + dir[0], y = n.y + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        Node newNode = new Node(x, y, Math.max(n.cost, grid[x][y]));
                        pq.offer(newNode);
                    }
                }
            }
        }

        return 0;
    }
}
// @lc code=end

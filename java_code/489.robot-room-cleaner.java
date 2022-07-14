/*
 * @lc app=leetcode id=489 lang=java
 *
 * [489] Robot Room Cleaner
 */

// @lc code=start
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void cleanRoom(Robot robot) {
        helper(robot, 0, 0, 0, new HashSet<String>());
    }

    private void helper(Robot robot, int x, int y, int face, Set<String> visited) {
        robot.clean();
        visited.add(x + "," + y);

        for (int i = 0; i < 4; i++) {
            int newFace = (face + i) % 4;
            int[] dir = dirs[newFace];

            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (!visited.contains(x1 + "," + y1) && robot.move()) {
                helper(robot, x1, y1, newFace, visited);
            }

            robot.turnRight();
        }

        // visited.remove(x + "," + y);
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
// @lc code=end

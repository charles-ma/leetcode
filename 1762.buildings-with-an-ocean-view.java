/*
 * @lc app=leetcode id=1762 lang=java
 *
 * [1762] Buildings With an Ocean View
 */

// @lc code=start
class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = heights.length - 1; i >= 0; i--) {
            int h = heights[i];
            if (stack.isEmpty() || heights[stack.peek()] < h) {
                stack.push(i);
            }
        }

        int size = stack.size();
        int[] r = new int[size];
        for (int i = 0; i < size; i++) {
            r[i] = stack.pop();
        }
        return r;
    }
}
// @lc code=end

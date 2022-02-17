/*
 * @lc app=leetcode id=1762 lang=java
 *
 * [1762] Buildings With an Ocean View
 */

// @lc code=start
class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < heights.length; i++) {
            while (stack.size() != 0 && heights[stack.peek()] <= heights[i])
                stack.pop();
            stack.push(i);
        }

        int n = stack.size();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
// @lc code=end

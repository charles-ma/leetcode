/*
 * @lc app=leetcode id=1944 lang=java
 *
 * [1944] Number of Visible People in a Queue
 */

// @lc code=start
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] <= h) {
                result[stack.pop()]++;
            }

            if (!stack.isEmpty()) result[stack.peek()]++;

            stack.push(i);
        }

        return result;
    }
}
// @lc code=end

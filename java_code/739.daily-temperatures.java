/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Map solution
        
        // Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        // int[] result = new int[temperatures.length];

        // for (int i = temperatures.length - 1; i >= 0; i--) {
        //     int tmp = temperatures[i];
        //     m.put(tmp, i);
        //     int min = Integer.MAX_VALUE;
        //     for (int t = tmp + 1; t <= 100; t++) {
        //         if (m.containsKey(t)) {
        //             min = Math.min(min, m.get(t) - i);
        //         }
        //     }
        //     if (min != Integer.MAX_VALUE) result[i] = min;
        // }

        // return result;

        // Stack solution
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            int tmp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < tmp) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
// @lc code=end

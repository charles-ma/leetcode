/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> q1 =
            new PriorityQueue<Integer>((i1, i2) -> (int)(i2 * 1.0 - i1 * 1.0));
        PriorityQueue<Integer> q2 =
            new PriorityQueue<Integer>((i1, i2) -> (int)(i1 * 1.0 - i2 * 1.0));

        for (int i = 0; i < k; i++) q2.offer(nums[i]);

        for (int i = 0; i < k / 2; i++) q1.offer(q2.poll());

        double[] result = new double[nums.length - k + 1];

        if (k == 1) {
            int i = 0;
            for (int num : nums) {
                result[i++] = num * 1.0;
            }
            return result;
        }
        
        result[0] = k % 2 == 1 ? q2.peek() * 1.0 : ((q1.peek() * 1.0 + q2.peek() * 1.0) / 2.0);
        
        int p = k;
        while (p < nums.length) {
            int r = p - k + 1;
            int remove = nums[r - 1];
            int add = nums[p];

            if (remove <= q1.peek()) q1.remove(remove);
            else if (remove >= q2.peek()) q2.remove(remove);

            if (q2.size() != 0 && add >= q2.peek()) q2.offer(add);
            else q1.offer(add);

            while (q1.size() < k / 2) q1.offer(q2.poll());

            while (q2.size() < k - (k / 2)) q2.offer(q1.poll());

            result[r] = k % 2 == 1 ?
                q2.peek() * 1.0 : ((q1.peek() * 1.0 + q2.peek() * 1.0) / 2.0);
            p++;
        }

        return result;
    }
}
// @lc code=end

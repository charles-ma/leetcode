/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int num : nums) {
            int c = m.getOrDefault(num, 0);
            m.put(num, c + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<Integer, List<Integer>>();
        for (int key : m.keySet()) {
            int count = m.get(key);
            List<Integer> l = buckets.getOrDefault(count, new ArrayList<Integer>());
            l.add(key);
            buckets.put(count, l);
        }

        int[] result = new int[k];
        int p = 0;
        for (int i = nums.length; i >= 1; i--) {
            if (buckets.containsKey(i)) {
                List<Integer> l = buckets.get(i);
                for (int v : l) {
                    result[p++] = v;
                    if (p >= k) return result;
                }
            }
        }

        return result;
    }
}
// @lc code=end

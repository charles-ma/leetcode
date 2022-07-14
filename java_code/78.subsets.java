/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> seed = new ArrayList();
        List<List<Integer>> result = new ArrayList();
        result.add(seed);

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> l = result.get(i);
                List<Integer> newList = new ArrayList<Integer>(l);
                newList.add(num);
                result.add(newList);
            }
        }

        return result;
    }
}
// @lc code=end

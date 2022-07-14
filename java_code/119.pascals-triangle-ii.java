/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>(Arrays.asList(1));
        int index = 1;
        while (index <= rowIndex) {
            result.add(1);
            for (int i = result.size() - 2; i >= 0; i--) {
                if (i == 0) result.set(i, 1);
                else result.set(i, result.get(i) + result.get(i - 1));
            }
            index++;
        }

        return result;
    }
}
// @lc code=end

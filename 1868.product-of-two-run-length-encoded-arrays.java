/*
 * @lc app=leetcode id=1868 lang=java
 *
 * [1868] Product of Two Run-Length Encoded Arrays
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int i = 0, j = 0;

        while (i < encoded1.length && j < encoded2.length) {
            int[] e1 = encoded1[i], e2 = encoded2[j];
            int v1 = e1[0], f1 = e1[1];
            int v2 = e2[0], f2 = e2[1];

            list.add(Arrays.asList(new Integer[]{v1 * v2, Math.min(f1, f2)}));

            if (f1 < f2) {
                e2[1] -= f1;
                i++;
            } else if (f1 > f2) {
                e1[1] -= f2;
                j++;
            } else {
                i++; j++;
            }

        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = null;
        for (List<Integer> v : list) {
            if (curr == null) curr = v;
            // need to compare int value rather than reference
            else if (v.get(0).intValue() != curr.get(0).intValue()) {
                res.add(curr);
                curr = v;
            } else {
                curr.set(1, curr.get(1) + v.get(1));
            }
        }

        res.add(curr);
        return res;
    }
}
// @lc code=end

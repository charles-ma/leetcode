/*
 * @lc app=leetcode id=939 lang=java
 *
 * [939] Minimum Area Rectangle
 */

// @lc code=start
class Solution {
    public int minAreaRect(int[][] points) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> m = new HashMap<>();

        for (int[] p : points) {
            Set<Integer> s = m.getOrDefault(p[0], new HashSet());
            s.add(p[1]);
            m.put(p[0], s);
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                Set<Integer> s1 = m.get(p1[0]);
                Set<Integer> s2 = m.get(p2[0]);
                if (s1.contains(p2[1]) && s2.contains(p1[1])) {
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
// @lc code=end

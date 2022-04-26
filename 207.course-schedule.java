/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> children = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> parents = new HashMap<Integer, Set<Integer>>();

        for (int[] pre : prerequisites) {
            int x = pre[0], y = pre[1];
            Set<Integer> c = children.getOrDefault(y, new HashSet<Integer>());
            c.add(x);
            children.put(y, c);

            Set<Integer> p = parents.getOrDefault(x, new HashSet<Integer>());
            p.add(y);
            parents.put(x, p);
        }

        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (!parents.containsKey(i) || parents.get(i).size() == 0) {
                q.offer(i);
                visited.add(i);
            }
        }

        while (q.size() != 0) {
            int v = q.poll();

            if (children.containsKey(v)) {
                for (int c : children.get(v)) {
                    if (visited.contains(c)) continue;

                    Set<Integer> ps = parents.get(c);
                    ps.remove(v);

                    if (ps.size() == 0) {
                        visited.add(c);
                        q.offer(c);
                    }
                }
            }
        }

        return visited.size() == numCourses;
    }
}
// @lc code=end

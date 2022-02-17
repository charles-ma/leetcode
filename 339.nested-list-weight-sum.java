/*
 * @lc app=leetcode id=339 lang=java
 *
 * [339] Nested List Weight Sum
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0, level = 1;
        Queue<NestedInteger> q = new LinkedList<NestedInteger>();

        for (NestedInteger ni : nestedList) q.offer(ni);
        
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger n = q.poll();
                if (n.isInteger()) sum += level * n.getInteger();
                else {
                    for (NestedInteger sub : n.getList()) {
                        q.offer(sub);
                    }
                }
            }
            level++;
        }
        return sum;
    }
}
// @lc code=end

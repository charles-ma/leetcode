/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result;
    
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList();
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int level) {
        if (root == null) return;

        int v = root.val;
        if (level == result.size()) result.add(root.val);
        else result.set(level, Math.max(result.get(level), root.val));

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
// @lc code=end

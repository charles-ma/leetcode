/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
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
    private TreeNode result;
    private int maxDepth = 0;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private int helper(TreeNode root, int level) {
        if (root == null) return level;

        int l = helper(root.left, level + 1);
        int r = helper(root.right, level + 1);

        if (l == r) {
            if (l >= maxDepth) {
                maxDepth = Math.max(maxDepth, l);
                result = root;
            }
        }

        return Math.max(l, r);
    }
}
// @lc code=end

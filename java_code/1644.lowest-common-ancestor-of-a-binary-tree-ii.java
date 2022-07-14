/*
 * @lc app=leetcode id=1644 lang=java
 *
 * [1644] Lowest Common Ancestor of a Binary Tree II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int count = 0;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode r = helper(root, p, q);
        return count == 2 ? r : null;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode l = helper(root.left, p, q);
        TreeNode r = helper(root.right, p, q);

        if (root == p || root == q) {
            count++;
            return root;
        }

        if (l != null && r != null) return root;
        return l != null ? l : r;
    }
}
// @lc code=end

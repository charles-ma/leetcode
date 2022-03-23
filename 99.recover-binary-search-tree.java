/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    TreeNode pre;
    TreeNode n1;
    TreeNode n2;
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        int v = root.val;
        if (pre != null && pre.val >= v) {
            if (n1 == null) {
                n1 = pre;
                n2 = root;
            } else n2 = root;
        }
        pre = root;
        traverse(root.right);
    }
}
// @lc code=end

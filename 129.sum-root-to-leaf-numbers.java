/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int tmp) {
        if (root == null) return;
        int v = root.val;
        tmp = tmp * 10 + v;
        if (root.left == null && root.right == null) {
            sum += tmp;
        } else {
            if (root.left != null) helper(root.left, tmp);
            if (root.right != null) helper(root.right, tmp);
        }
    }
}
// @lc code=end

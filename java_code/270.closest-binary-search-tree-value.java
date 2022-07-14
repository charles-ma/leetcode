/*
 * @lc app=leetcode id=270 lang=java
 *
 * [270] Closest Binary Search Tree Value
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
    private int v;
    
    public int closestValue(TreeNode root, double target) {
        v = root.val;
        helper(root, target);
        return v;
    }

    private void helper(TreeNode root, double target) {
        if (root == null) return;

        if (Math.abs(root.val - target) < Math.abs(v - target)) v = root.val;
        if (root.val > target) helper(root.left, target);
        else helper(root.right, target);
    }
}
// @lc code=end

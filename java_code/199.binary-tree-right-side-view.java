/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    private List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (root == null)
            return;

        if (result.size() <= level)
            result.add(root.val);
        else
            result.set(level, root.val);

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
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
    private Set<Integer> set;
    private List<TreeNode> result;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<Integer>();
        for (int n : to_delete) set.add(n);

        result = new ArrayList<TreeNode>();

        helper(root, null);

        return result;
    }

    private void helper(TreeNode root, TreeNode p) {
        if (root == null) return;

        if (set.contains(root.val)) {
            helper(root.left, null);
            helper(root.right, null);
            if (p != null && p.left == root) p.left = null;
            else if (p != null && p.right == root) p.right = null;
        } else {
            helper(root.left, root);
            helper(root.right, root);

            if (p == null) result.add(root);
        }
    }
}
// @lc code=end

import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=958 lang=java
 *
 * [958] Check Completeness of a Binary Tree
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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (q.peek() != null) {
            TreeNode n = q.poll();
            q.offer(n.left);
            q.offer(n.right);
        }

        while (!q.isEmpty() && q.peek() == null)
            q.poll();

        return q.isEmpty();
    }
}
// @lc code=end

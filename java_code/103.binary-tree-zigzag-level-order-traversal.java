/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) return result;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean flag = true;

        while (q.size() != 0) {
            int size = q.size();
            List<Integer> a = new LinkedList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode n = q.remove(0);
                if (flag) a.add(n.val);
                else a.add(0, n.val);

                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            result.add(a);
            flag = !flag;
        }

        return result;
    }
}
// @lc code=end

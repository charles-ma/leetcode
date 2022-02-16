/*
 * @lc app=leetcode id=314 lang=java
 *
 * [314] Binary Tree Vertical Order Traversal
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
class Node {
    TreeNode tn;
    int col;
    
    Node(TreeNode tn, int col) {
        this.tn = tn;
        this.col = col;
    }
}


class Solution {
    private Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
    private int min = 0, max = 0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(root, 0));
        
        while (q.size() != 0) {
            Node n = q.poll();
            int col = n.col;
            TreeNode tn = n.tn;
            int v = tn.val;

            m.putIfAbsent(col, new ArrayList<Integer>());
            m.get(col).add(v);
            min = Math.min(min, col);
            max = Math.max(max, col);

            if (tn.left != null) q.offer(new Node(tn.left, col - 1));
            if (tn.right != null) q.offer(new Node(tn.right, col + 1));
        }

        for (int i = min; i <= max; i++) {
            result.add(m.get(i));
        }
        
        return result;
    }
}
// @lc code=end

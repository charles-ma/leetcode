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
    TreeNode treeNode;
    int col;
    
    Node(TreeNode treeNode, int col) {
        this.treeNode = treeNode;
        this.col = col;
    }
}

class Solution {
    private TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(root, 0));
        
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                List<Integer> l = map.getOrDefault(n.col, new ArrayList<Integer>());
                l.add(n.treeNode.val);
                map.put(n.col, l);
                
                if (n.treeNode.left != null) q.offer(new Node(n.treeNode.left, n.col - 1));
                if (n.treeNode.right != null) q.offer(new Node(n.treeNode.right, n.col + 1));
            }
        }

        for (int key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
// @lc code=end

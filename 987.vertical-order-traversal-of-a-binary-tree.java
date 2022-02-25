/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, PriorityQueue<Integer>> m
                = new HashMap<Integer, PriorityQueue<Integer>>();

            for (int i = 0; i < size; i++) {
                Node v = q.poll();
                int index = v.col;
                TreeNode treeNode = v.treeNode;
                PriorityQueue<Integer> pq
                    = m.getOrDefault(index, new PriorityQueue<Integer>(1, (i1, i2) -> i1 - i2));
                pq.offer(treeNode.val);
                m.put(index, pq);

                if (treeNode.left != null) q.offer(new Node(treeNode.left, index - 1));
                if (treeNode.right != null) q.offer(new Node(treeNode.right, index + 1));
            }

            for (int k : m.keySet()) {
                map.putIfAbsent(k, new ArrayList<Integer>());
                while (!m.get(k).isEmpty()) {
                    map.get(k).add(m.get(k).poll());
                }
            }
            
        }

        for (int k : map.keySet()) {
            result.add(map.get(k));
        }

        return result;
    }
}

class Node {
    TreeNode treeNode;
    int col;

    Node(TreeNode tn, int c) {
        treeNode = tn;
        col = c;
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=426 lang=java
 *
 * [426] Convert Binary Search Tree to Sorted Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    private Node dummy;
    private Node pre;
    
    public Node treeToDoublyList(Node root) {
        dummy = new Node(0);
        pre = dummy;

        helper(root);

        if (dummy.right != null) {
            dummy.right.left = pre;
            pre.right = dummy.right;
        }

        return dummy.right;
    }

    private void helper(Node root) {
        if (root == null) return;

        helper(root.left);
        pre.right = root;
        root.left = pre;
        Node right = root.right;
        pre = root;
        helper(right);
    }
}
// @lc code=end

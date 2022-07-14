/*
 * @lc app=leetcode id=708 lang=java
 *
 * [708] Insert into a Sorted Circular Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        
        if (head == null) {
            n.next = n;
            return n;
        }

        Node curr = head;
        while (true) {
            if ((curr.val <= insertVal && curr.next.val >= insertVal)
                || (curr.next.val < curr.val && (curr.next.val >= insertVal || curr.val <= insertVal))
                || curr.next == head) {
                n.next = curr.next;
                curr.next = n;
                return head;
            }
            curr = curr.next;
        }
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(Math.max(lists.length, 1), (n1, n2) -> n1.val - n2.val);

        ListNode dummy = new ListNode();
        ListNode p = dummy;

        for (ListNode n : lists) {
            if (n != null) pq.offer(n);
        }

        while (pq.size() != 0) {
            ListNode n = pq.poll();
            p.next = n;
            p = p.next;

            if (n.next != null) pq.offer(n.next);
        }

        return dummy.next;
    }
}
// @lc code=end

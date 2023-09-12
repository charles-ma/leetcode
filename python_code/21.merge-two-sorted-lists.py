#
# @lc app=leetcode id=21 lang=python3
#
# [21] Merge Two Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        r = dummy = ListNode()
        while list1 and list2:
            if list1.val < list2.val:
                list1, r.next = list1.next, list1
            else:
                list2, r.next = list2.next, list2
            r = r.next

        r.next = list1 or list2
        return dummy.next
    
# @lc code=end

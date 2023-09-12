#
# @lc app=leetcode id=27 lang=python3
#
# [27] Remove Element
#

# @lc code=start
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        p = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[p], p = nums[i], p + 1
        return p
        
# @lc code=end

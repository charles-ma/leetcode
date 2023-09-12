#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        j = 0
        for i in range(len(nums)):
            if j == 0 or nums[j - 1] != nums[i]:
                nums[j], j = nums[i], j + 1
        return j
        
# @lc code=end

#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for index, num in enumerate(nums):
            t = target - num
            if t in map:
                return [map[t], index]
            map[num] = index
        
# @lc code=end

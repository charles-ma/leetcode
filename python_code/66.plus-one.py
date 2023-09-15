#
# @lc app=leetcode id=66 lang=python3
#
# [66] Plus One
#

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        c = 1
        result = []
        for i in range(len(digits) - 1, -1, -1):
            s = c + digits[i]
            c = int(s / 10)
            result.insert(0, s % 10)
        if c == 1:
            result.insert(0, 1)
        return result
                
# @lc code=end

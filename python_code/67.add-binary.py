#
# @lc app=leetcode id=67 lang=python3
#
# [67] Add Binary
#

# @lc code=start
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        result = ''
        i, j = len(a) - 1, len(b) - 1
        c = 0
        while i >= 0 or j >= 0 or c > 0:
            n1 = int(a[i]) if i >= 0 else 0
            n2 = int(b[j]) if j >= 0 else 0
            sum = n1 + n2 + c
            result = str(sum % 2) + result
            c = int(sum / 2)
            i, j = i - 1, j - 1
        return result
        
# @lc code=end

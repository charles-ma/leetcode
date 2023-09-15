#
# @lc app=leetcode id=58 lang=python3
#
# [58] Length of Last Word
#

# @lc code=start
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        for i in range(len(s) - 1, -1, -1):
            if s[i] == ' ':
                continue
            n = i
            while n >= 0 and s[n] != ' ':
                n = n - 1
            return i - n
        
# @lc code=end

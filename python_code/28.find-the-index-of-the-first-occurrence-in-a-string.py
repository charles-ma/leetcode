#
# @lc app=leetcode id=28 lang=python3
#
# [28] Find the Index of the First Occurrence in a String
#

# @lc code=start
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        l = len(needle)
        for i in range(len(haystack)):
            if needle == haystack[i: i + l]:
                return i
        return -1
# @lc code=end

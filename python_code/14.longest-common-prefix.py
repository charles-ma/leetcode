#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#

# @lc code=start
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        r = strs[0]
        for s in strs:
            r = self.findCommonPrefix(r, s)
        return r

    def findCommonPrefix(self, s1: str, s2: str) -> str:
        i = 0
        while i < len(s1) and i < len(s2):
            if s1[i] == s2[i]:
                i += 1
            else:
                break

        return s1[0: i]
                
# @lc code=end

#
# @lc app=leetcode id=13 lang=python3
#
# [13] Roman to Integer
#

# @lc code=start
class Solution:
    def romanToInt(self, s: str) -> int:
        m = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        running_sum = 0
        for i in range(len(s)):
            if i < len(s) - 1 and m[s[i]] < m[s[i + 1]]:
                running_sum -= m[s[i]]
            else:    
                running_sum += m[s[i]]
        return running_sum    
        
# @lc code=end

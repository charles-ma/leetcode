#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch in '([{':
                stack.append(ch)
            elif len(stack) == 0 or (stack.pop() + ch) not in ['()', '{}', '[]']:
                return False
        return len(stack) == 0
        
# @lc code=end

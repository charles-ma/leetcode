/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if (!isAlphaNumeric(c1)) i++;
            else if (!isAlphaNumeric(c2)) j--;
            else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
                i++; j--;
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
// @lc code=end

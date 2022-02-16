/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalin(s.substring(0, i) + s.substring(i + 1)) ||
                    isPalin(s.substring(0, j) + s.substring(j + 1));
            }
            i++; j--;
        }
        return true;
    }

    private boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }
}
// @lc code=end

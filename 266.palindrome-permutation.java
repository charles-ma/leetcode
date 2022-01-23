/*
 * @lc app=leetcode id=266 lang=java
 *
 * [266] Palindrome Permutation
 */

// @lc code=start
class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        return set.size() <= 1;
    }
}
// @lc code=end

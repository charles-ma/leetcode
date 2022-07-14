/*
 * @lc app=leetcode id=408 lang=java
 *
 * [408] Valid Word Abbreviation
 */

// @lc code=start
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, p = 0;

        while (i < abbr.length() && p < word.length()) {
            if (!Character.isDigit(abbr.charAt(i))) {
                if (abbr.charAt(i++) != word.charAt(p++))
                    return false;
                continue;
            }

            if (Character.isDigit(abbr.charAt(i))) {
                if (abbr.charAt(i) == '0')
                    return false;

                int start = i;
                while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                    i++;
                }
                if (i > start) {
                    int n = Integer.parseInt(abbr.substring(start, i));
                    if (n + p > word.length())
                        return false;

                    p += n;
                }
            }
        }

        return i == abbr.length() && p == word.length();
    }
}
// @lc code=end

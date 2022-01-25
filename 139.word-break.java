/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    private boolean[] dp;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        Set<String> dict = new HashSet<String>();
        for (String word : wordDict) dict.add(word);

        for (int i = s.length(); i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (dict.contains(sub) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
// @lc code=end

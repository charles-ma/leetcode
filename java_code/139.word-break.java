/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        Set<String> set = new HashSet<String>();
        for (String word : wordDict) {
            set.add(word);
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && set.contains(sub)) {
                    dp[i] = true; break;
                }
            }
        }

        return dp[s.length()];
    }
}
// @lc code=end

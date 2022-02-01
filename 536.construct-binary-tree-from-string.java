/*
 * @lc app=leetcode id=536 lang=java
 *
 * [536] Construct Binary Tree from String
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) return null;

        int index = s.indexOf("(");
        if (index == -1) index = s.length();
        String v = s.substring(0, index);
        TreeNode r = new TreeNode(Integer.parseInt(v));

        int p = index;
        int c = 0;
        while (p < s.length()) {
            if (s.charAt(p) == '(') c++;
            if (s.charAt(p) == ')') c--;
            if (c == 0) {
                r.left = str2tree(s.substring(index + 1, p));
                if (p < s.length() - 1) r.right = str2tree(s.substring(p + 2, s.length() - 1));
                return r;
            }
            p++;
        }

        return r;
    }
}
// @lc code=end

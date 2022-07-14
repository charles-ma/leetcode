/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, Integer> ancestors = new HashMap();
    private Set<Integer> result = new HashSet();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findTarget(root, target);
        helper(root, k, 0);
        return new ArrayList<Integer>(result);
    }

    private void helper(TreeNode root, int k, int level) {
        if (root == null) return;

        int v = root.val;
        if (ancestors.containsKey(v)) {
            level = ancestors.get(v);
            if (level == k) result.add(v);
        } else {
            level++;
            if (level == k) {
                result.add(v);
                return;
            }
        }

        helper(root.left, k, level);
        helper(root.right, k, level);
    }

    private int findTarget(TreeNode root, TreeNode target) {
        if (root == null) return -1;

        if (root == target) {
            ancestors.put(root.val, 0);
            return 0;
        }

        int l = findTarget(root.left, target);
        int r = findTarget(root.right, target);

        if (l == -1 && r == -1) return -1;
        if (l != -1) {
            ancestors.put(root.val, l + 1);
            return l + 1;
        }
        ancestors.put(root.val, r + 1);
        return r + 1;
    }
}
// @lc code=end

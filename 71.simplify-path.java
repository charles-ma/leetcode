/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        List<String> stack = new LinkedList<String>();
        String[] paths = path.split("/");
        
        for (String dir : paths) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.remove(stack.size() - 1);
            } else if (!dir.isEmpty() && !dir.equals(".")){
                stack.add(dir);
            }
        }

        return "/" + String.join("/", stack);
    }
}
// @lc code=end

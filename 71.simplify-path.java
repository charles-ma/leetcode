/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<String>();

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!part.equals(".") && !part.isEmpty()) {
                stack.push(part);
            }
        }

        List<String> result = new ArrayList<String>(stack);
        return "/" + String.join("/", result);
    }
}
// @lc code=end

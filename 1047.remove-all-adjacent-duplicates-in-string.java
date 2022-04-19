/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        // Stack<Character> stack = new Stack<Character>();

        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (!stack.isEmpty() && stack.peek() == c) stack.pop();
        //     else stack.push(c);
        // }

        // StringBuilder sb = new StringBuilder();
        // while (!stack.isEmpty()) sb.insert(0, stack.pop());

        // return sb.toString();

        int p = 0;
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];

            if (p == -1 || chars[p] != c) {
                chars[++p] = c;
            } else {
                p--;
            }
        }

        if (p == -1) return "";
        return new String(Arrays.copyOfRange(chars, 0, p + 1));
    }
}
// @lc code=end

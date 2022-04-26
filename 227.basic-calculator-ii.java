/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<String>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c + "");
                i++; continue;
            } 

            int p = i;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                i++;
            }
            String value = s.substring(p, i);
            if (!value.isEmpty()) {
                if (stack.isEmpty()) stack.push(value);
                else {
                    String op = stack.pop();
                    if (op.equals("-")) stack.push("-" + value);
                    else if (op.equals("+")) stack.push(value);
                    else {
                        int first = Integer.parseInt(stack.pop());
                        int sec = Integer.parseInt(value);
                        int r = op.equals("*") ? first * sec : first / sec;
                        stack.push(r + "");
                    }
                }
                continue;
            }

            i++;
        }

        int sum = 0;
        for (String sub : stack) {
            sum += Integer.parseInt(sub);
        }

        return sum;
    }
}
// @lc code=end

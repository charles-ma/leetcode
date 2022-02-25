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
            if (c == '+' || c == '-') {
                stack.push("" + c);
                i++;
            } else if (c == '*' || c == '/') {
                while (i < s.length() && !Character.isDigit(s.charAt(i))) i++;
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) i++;

                int second = Integer.parseInt(s.substring(start, i));
                int first = Integer.parseInt(stack.pop());

                int r = first * second;
                if (c == '/') r = first / second;

                stack.push("" + r);
            } else if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
                stack.push(s.substring(start, i));
            } else {
                i++;
            }
        }

        List<String> l = new ArrayList<String>(stack);
        int sum = 0, flag = 1;
        for (String token : l) {
            System.out.println(token);
            if (token.equals("-")) flag = -1;
            else if(token.equals("+")) flag = 1;
            else sum += flag * Integer.parseInt(token);
        }

        return sum;
    }
}
// @lc code=end

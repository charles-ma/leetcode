/*
 * @lc app=leetcode id=556 lang=java
 *
 * [556] Next Greater Element III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        char[] a = String.valueOf(n).toCharArray();
        Map<Character, Integer> m = new HashMap<Character, Integer>();

        for (int i = a.length - 1; i >= 1; i--) {
            if (!m.containsKey(a[i])) m.put(a[i], i);
            
            if (a[i] <= a[i - 1]) continue;
            int v = (int)(a[i - 1] - '0');
            
            for (int j = v + 1; j < 10; j++) {
                char ch = (char)(j + '0');
                if (m.containsKey(ch)) {
                    swap(a, i - 1, m.get(ch));
                    reverse(a, i, a.length - 1);
                    long r = Long.parseLong(new String(a));
                    return r > Integer.MAX_VALUE ? -1 : (int) r;
                }
            }
        }

        return -1;
    }

    private void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            swap(a, i++, j--);
        }
    }
}
// @lc code=end

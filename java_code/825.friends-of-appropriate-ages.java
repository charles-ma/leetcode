/*
 * @lc app=leetcode id=825 lang=java
 *
 * [825] Friends Of Appropriate Ages
 */

// @lc code=start
class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> ageMap = new HashMap();

        for (int age : ages) {
            int count = ageMap.getOrDefault(age, 0);
            ageMap.put(age, count + 1);
        }

        int sum = 0;
        for (int x : ageMap.keySet()) {
            for (int y : ageMap.keySet()) {
                int c1 = ageMap.get(x);
                int c2 = ageMap.get(y);
                if (sendRequest(x, y)) {
                    if (x == y)
                        sum += c1 * (c1 - 1);
                    else
                        sum += c1 * c2;
                }
            }
        }

        return sum;
    }

    private boolean sendRequest(int a, int b) {
        return b > 0.5 * a + 7 && b <= a;
    }
}
// @lc code=end

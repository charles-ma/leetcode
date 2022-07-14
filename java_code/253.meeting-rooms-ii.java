/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int size = intervals.length;
        int[] starts = new int[size];
        int[] ends = new int[size];
        int p = 0;

        for (int[] interval : intervals) {
            starts[p] = interval[0];
            ends[p++] = interval[1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int c = 0, max = 0;
        int p1 = 0, p2 = 0;
        while (p1 < size) {
            if (starts[p1] < ends[p2]) {
                p1++; c++;
            } else {
                p2++; c--;
            }
            max = Math.max(max, c);
        }

        return max;
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // int i = 0, j = arr.length - 1;

        // while (i < j) {
        //     int mid = i + (j - i) / 2;
        //     if (arr[mid] < x) {
        //         i = mid + 1;
        //     } else {
        //         j = mid;
        //     }
        // }

        // int p1 = j - 1, p2 = j;
        // List<Integer> l1 = new ArrayList();
        // List<Integer> l2 = new ArrayList();
        // int c = 0;

        // while (c < k && (p1 >= 0 || p2 < arr.length)) {
        //     if (p1 < 0) l2.add(arr[p2++]);
        //     else if (p2 == arr.length) l1.add(0, arr[p1--]);
        //     else {
        //         if (arr[p2] - x < x - arr[p1]) l2.add(arr[p2++]);
        //         else l1.add(0, arr[p1--]);
        //     }
        //     c++;
        // }

        // return Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList());

        // int i = 0, j = arr.length - k;

        // while (i < j) {
        //     int mid = i + (j - i) / 2;
        //     int v = arr[mid] + arr[mid + k];
        //     if (v < 2 * x) {
        //         i = mid + 1;
        //     } else {
        //         j = mid;
        //     }
        // }
        
        int i = 0, j = arr.length - k;
        while (i < j) {
            int mid = i + (j - i) / 2;
            int v = arr[mid] + arr[mid + k - 1];
            if (v < 2 * x) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        
        if (i >= 1 && arr[i - 1] + arr[i + k - 1] >= 2 * x) i = i - 1;
        
        return Arrays.stream(arr, i, i + k).boxed().collect(Collectors.toList());
    }
}
// @lc code=end

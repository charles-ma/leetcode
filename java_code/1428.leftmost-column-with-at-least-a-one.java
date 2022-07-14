/*
 * @lc app=leetcode id=1428 lang=java
 *
 * [1428] Leftmost Column with at Least a One
 */

// @lc code=start
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    //     List<Integer> d = binaryMatrix.dimensions();
    //     int m = d.get(0), n = d.get(1);
    //     int result = n;

    //     for (int i = 0; i < m; i++) {
    //         int l = 0, h = n - 1;
            
    //         while (l < h) {
    //             int mid = l + (h - l) / 2;
    //             if (binaryMatrix.get(i, mid) == 1) {
    //                 h = mid;
    //             } else {
    //                 l = mid + 1;
    //             }
    //         }

    //         if (binaryMatrix.get(i, l) == 0) l++;
    //         result = Math.min(result, l);
    //     }

    //     return result == n ? -1 : result;

        List<Integer> d = binaryMatrix.dimensions();
        int m = d.get(0), n = d.get(1);

        int i = 0, j = n - 1;
        int result = n;
        while (true) {
            while (i < m && binaryMatrix.get(i, j) == 0) {
                i++;
            }

            if (i == m) break;
            
            while (j >= 0 && binaryMatrix.get(i, j) == 1) {
                result = Math.min(result, j);
                j--;
            }

            if (j < 0) break;
        }

        return result == n ? -1 : result;
    }
        
        
}
// @lc code=end

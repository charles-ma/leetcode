/*
 * @lc app=leetcode id=1570 lang=java
 *
 * [1570] Dot Product of Two Sparse Vectors
 */

// @lc code=start
class SparseVector {

    private Map<Integer, Integer> m;
    
    SparseVector(int[] nums) {
        m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            m.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for (int k : m.keySet()) {
            if (vec.m.containsKey(k)) {
                sum += vec.m.get(k) * m.get(k);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
// @lc code=end

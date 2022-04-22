/*
 * @lc app=leetcode id=346 lang=java
 *
 * [346] Moving Average from Data Stream
 */

// @lc code=start
class MovingAverage {

    private LinkedList<Integer> queue = new LinkedList<Integer>();
    private int size;
    private int sum;
    
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        queue.add(val);
        if (queue.size() > size) {
            int v = queue.remove(0);
            sum -= v;
        }
        sum += val;
        return 1.0 * sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
// @lc code=end

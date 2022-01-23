/*
 * @lc app=leetcode id=346 lang=java
 *
 * [346] Moving Average from Data Stream
 */

// @lc code=start
class MovingAverage {
    private Queue<Integer> q;
    private int size;
    private int sum;
    
    public MovingAverage(int size) {
        q = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        q.offer(val);
        sum += val;

        if (q.size() > size) {
            sum -= q.poll();
        }

        return (double)sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
// @lc code=end

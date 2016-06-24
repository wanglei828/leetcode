/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

public class MovingAverage {
    
    Queue<Integer>  q = new LinkedList<Integer>();
    int size = 0;
    int sum = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if(q.size() < size) {
            sum += val;
            q.add(val);
            return (double)sum/(double)(q.size());
        } else {
            int tmp = q.poll();
            sum += (val-tmp);
            q.add(val);
            return (double)sum/(double)size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

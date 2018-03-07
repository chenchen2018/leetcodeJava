package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cchen on 3/7/18.
 */
public class Q346 {
}

class MovingAverage {
    Queue<Integer> nums;
    int size;
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new LinkedList<>();
        this.size = size;
        this.sum = 0.0;
    }

    public double next(int val) {
        nums.offer(val);
        sum += val;
        if (nums.size() <= this.size) {
            return sum / nums.size();
        } else {
            sum -= nums.poll();
            return sum / this.size;
        }
    }
}

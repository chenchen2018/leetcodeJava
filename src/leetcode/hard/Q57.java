package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Q57 {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 2));
        list.add(new Interval(3, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(12, 16));
        List<Interval> res = new Q57Solution().insert(list, new Interval(4, 9));
        res.stream().forEach(System.out::println);
    }
}

class Q57Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int index = 0;
        while (index < intervals.size()) {
            if (newInterval.start > intervals.get(index).end) {
                index++;
            } else {
                while (index < intervals.size() && (isInterleaving(newInterval, intervals.get(index)) || isInterleaving(intervals.get(index), newInterval))) {
                    newInterval = mergeInterval(newInterval, intervals.get(index));
                    intervals.remove(index);
                }
                intervals.add(index, newInterval);
                break;
            }
        }
        if (index == intervals.size()) {
            intervals.add(index, newInterval);
        }
        return intervals;
    }

    private Interval mergeInterval(Interval interval1, Interval interval2) {
        return new Interval(Math.min(interval1.start, interval2.start), Math.max(interval1.end, interval2.end));
    }

    private boolean isInterleaving(Interval interval1, Interval interval2) {
        return interval2.start >= interval1.start && interval2.start <= interval1.end;
    }
}

class Interval {
    int start, end;

    public Interval() {
        start = end = 0;
    }


    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

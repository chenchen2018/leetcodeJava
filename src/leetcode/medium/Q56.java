package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chen on 1/3/18.
 */
public class Q56 {
}

class Q56Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, (i1, i2) -> {
            return i1.start - i2.start;
        });
        Interval candidate = intervals.get(0);
        for (int index = 1; index < intervals.size(); index++) {
            Interval curr = intervals.get(index);
            if (curr.start > candidate.end) {
                res.add(candidate);
                candidate = curr;
            } else {
                candidate = merge(candidate, curr);
            }
        }
        res.add(candidate);
        return res;
    }

    private Interval merge(Interval interval1, Interval interval2) {
        return new Interval(Math.min(interval1.start, interval2.start), Math.max(interval1.end, interval2.end));
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

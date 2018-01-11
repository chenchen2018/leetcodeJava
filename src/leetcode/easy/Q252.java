package leetcode.easy;

import java.util.Arrays;

public class Q252 {
}

class Q252Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return true;
        }
        Arrays.sort(intervals, (i1, i2) -> {
           return i1.start - i2.start;
        });
        for (int index = 1; index < intervals.length; index++) {
            if (intervals[index].start < intervals[index - 1].end) {
                return false;
            }
        }
        return true;
    }
}

class Interval {
    int start, end;
    public Interval() {
        this.start = 0;
        this.end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

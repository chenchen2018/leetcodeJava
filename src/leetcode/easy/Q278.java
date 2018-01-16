package leetcode.easy;

public class Q278 {
}

class Q278Solution {
    public int firstBadVersion(int n) {
        if (n < 1) {
            return 0;
        }
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }
        if (isBadVersion(right)) {
            return right;
        }
        return 0;
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
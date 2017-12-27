package leetcode.medium;

public class Q11 {
}

class Q11Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            res = temp > res ? temp : res;
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}


package leetcode.easy;

/**
 * Created by chen on 1/3/18.
 */
public class Q167 {
}

class Q167Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        if (numbers == null || numbers.length < 2) {
            return res;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
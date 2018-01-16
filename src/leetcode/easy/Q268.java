package leetcode.easy;

import java.util.Arrays;

public class Q268 {
    public static void main(String[] args) {
        int[] input = {7, 5, 4, 1, 8, 6, 0, 3};
        new Q268Solution().magicSort(input);
        Arrays.stream(input).forEach(System.out::print);
    }
}

class Q268Solution {
    public int missingNumber(int[] nums) {
        magicSort(nums);
        for (int index = 0; index < nums.length; index++) {
            if (index != nums[index]) {
                return index;
            }
        }
        return nums.length;
    }

    public void magicSort(int[] nums) {
        int index = 0, n = nums.length;
        while (index < n) {
            while (index != nums[index] && nums[index] < n) {
                int temp = nums[index];
                nums[index] = nums[temp];
                nums[temp] = temp;
            }
            index++;
        }
    }
}
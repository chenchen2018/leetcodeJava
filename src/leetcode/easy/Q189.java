package leetcode.easy;

/**
 * Created by chen on 1/4/18.
 */
public class Q189 {
}

class Q189Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k %= nums.length;
        while (k > 0) {
            int temp = nums[nums.length - 1];
            for (int index = nums.length - 2; index >= 0; index--) {
                nums[index + 1] = nums[index];
            }
            nums[0] = temp;
            k--;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k %= nums.length;
        if (k == 0) {
            return;
        }
        //copy last k elements
        int[] temp = new int[k];
        int pointer = 0;
        for (int index = nums.length - k; index < nums.length; index++) {
            temp[pointer++] = nums[index];
        }
        //copy first nums.length - k elements to the end of the array
        pointer = nums.length - 1;
        for (int index = nums.length - k - 1; index >= 0; index--) {
            nums[pointer--] = nums[index];
        }
        //copy back last k elements
        for (int index = 0; index < k; index++) {
            nums[index] = temp[index];
        }
    }

    public void rorate3(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k %= nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
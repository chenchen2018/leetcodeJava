package leetcode.hard;

public class Q4 {
}

class Q4Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (findKthElement(nums1, 0, nums2, 0, totalLength / 2) +
                    findKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1)) / 2.0;
        } else {
            return findKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1);
        }
    }

    private int findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int increment = k / 2 - 1;  //index increment starting from current index
        int nums1Element = start1 + increment >= nums1.length ? Integer.MAX_VALUE : nums1[start1 + increment];
        int nums2Element = start2 + increment >= nums2.length ? Integer.MAX_VALUE : nums2[start2 + increment];
        if (nums1Element >= nums2Element) {
            return findKthElement(nums1, start1 + increment + 1, nums2, start2, k - increment);
        } else {
            return findKthElement(nums1, start1, nums2, start2 + increment + 1, k - increment);
        }
    }
}
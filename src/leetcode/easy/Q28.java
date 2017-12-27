package leetcode.easy;

public class Q28 {
}

class Q28Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int left = 0;
        while (left + needle.length() <= haystack.length()) {
            if (haystack.charAt(left) != needle.charAt(0)) {
                left++;
            } else {
                //compare if 2 strings are same
                int index = 0;
                while (index < needle.length()) {
                    if (needle.charAt(index) == haystack.charAt(left + index)) {
                        index++;
                    } else {
                        break;
                    }
                }
                if (index == needle.length()) {
                    return left;
                }
                left++;
            }
        }
        return -1;
    }
}
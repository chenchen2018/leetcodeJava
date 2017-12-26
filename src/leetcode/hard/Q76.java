package leetcode.hard;

public class Q76 {

    public static void main(String[] args) {
        System.out.println(new Q76Solution().minWindow("aa", "a"));
    }

}

class Q76Solution {

    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0 || s == null || s.length() == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        int minLeftIndex = -1, minRightIndex = -1;

        int[] sMap = new int[256], tMap = new int[256];
        //first load t into the tMap
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }

        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < s.length()) {
            while (!contains(sMap, tMap) && rightIndex < s.length()) {
                sMap[s.charAt(rightIndex++)]++;
            }
            if (contains(sMap, tMap)) {
                int currLength = rightIndex - leftIndex;
                if (currLength < minLength) {
                    minLength = currLength;
                    minLeftIndex = leftIndex;
                    minRightIndex = rightIndex;
                }
            }
            sMap[s.charAt(leftIndex++)]--;
        }

        if (minLeftIndex == -1) {
            return "";
        }
        return s.substring(minLeftIndex, minRightIndex);
    }

    private boolean contains(int[] sMap, int[] tMap) {
        for (int index = 0; index < sMap.length; index++) {
            if (sMap[index] < tMap[index]) {
                return false;
            }
        }
        return true;
    }

//    private String minWindow2(String s, String t) {
//        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
//            return "";
//        }
//        int[] map = new int[256];
//        for (char c : t.toCharArray()) {
//            map[c]++;
//        }
//        String res = "";
//        int tNumner = t.length(), sNumber = 0;
//        int leftIndex = 0, rightIndex = 0;
//        int minLength = Integer.MAX_VALUE;
//        while (leftIndex < s.length()) {
//            while (rightIndex < s.length() && sNumber < tNumner) {
//                if (map[s.charAt(rightIndex)] > 0) {
//                    sNumber++;
//                    map[s.charAt(rightIndex)]--;
//                }
//                rightIndex++;
//            }
//            while (sNumber >= tNumner) {
//                if (rightIndex - leftIndex < minLength) {
//                    minLength = rightIndex - leftIndex;
//                    res = s.substring(leftIndex, rightIndex);
//                }
//
//            }
//        }
//    }
}

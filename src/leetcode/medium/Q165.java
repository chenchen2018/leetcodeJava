package leetcode.medium;

/**
 * Created by cchen on 3/27/18.
 */
public class Q165 {
    public static void main(String[] args) {
        Q165Solution solution = new Q165Solution();
        System.out.println(solution.compareVersion("01", "1"));
    }
}

class Q165Solution {
    public int compareVersion(String version1, String version2) {
        String[] firstVersion = version1.split("\\."), secondVersion = version2.split("\\.");
        int length = Math.max(firstVersion.length, secondVersion.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < firstVersion.length ? Integer.parseInt(firstVersion[i]) : 0;
            Integer v2 = i < secondVersion.length ? Integer.parseInt(secondVersion[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}
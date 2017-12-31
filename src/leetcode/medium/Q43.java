package leetcode.medium;

/**
 * Created by chen on 12/31/17.
 */
public class Q43 {
    public static void main(String[] args) {
        System.out.println(new Q43Solution().multiply("98", "9"));
    }
}

class Q43Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int num1Index = num1.length() - 1; num1Index >= 0; num1Index--) {
            int digit = num1.charAt(num1Index) - '0', carry = 0;
            int resIndex = res.length - 1 - (num1.length() - 1 - num1Index);
            for (int num2Index = num2.length() - 1; num2Index >= 0; num2Index--) {
                carry += digit * (num2.charAt(num2Index) - '0');
                carry += res[resIndex];
                res[resIndex] = carry % 10;
                carry /= 10;
                resIndex--;
            }
            if (carry != 0) {
                while (carry != 0) {
                    carry += res[resIndex];
                    res[resIndex--] = carry % 10;
                    carry /= 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        //skip as many 0's as we can
        int index = 0;
        while (index < res.length && res[index] == 0) {
            index++;
        }
        while (index < res.length) {
            sb.append(res[index++]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
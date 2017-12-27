package leetcode.medium;

public class Q12 {
}

class Q12Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int index = 0; index < 13; index++) {
            int counts = num / nums[index];
            num %= nums[index];
            while (counts > 0) {
                sb.append(romans[index]);
                counts--;
            }
        }
        return sb.toString();
    }
}
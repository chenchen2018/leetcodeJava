package leetcode.easy;

public class Q258 {
}

class Q258Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int temp = 0;
            while (num != 0) {
                temp += num % 10;
                num /= 10;
            }
            num = temp;
        }
        return num;
    }
}
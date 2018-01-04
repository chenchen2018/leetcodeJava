package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by chen on 1/4/18.
 */
public class Q60 {
}

class Q60Solution {
    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for (int index = 1; index <= n; index++) {
            num[index - 1] = index;
        }
        int step = 1;
        while (step < k) {
            getNext(num);
            step++;
        }
        StringBuilder sb = new StringBuilder();
        for (int number : num) {
            sb.append(number);
        }
        return sb.toString();
    }

    private void getNext(int[] num) {
        Stack<Integer> stack = new Stack<>();
        stack.push(num[num.length - 1]);
        for (int index = num.length - 2; index >= 0; index--) {
            if (num[index] > stack.peek()) {
                stack.push(num[index]);
            } else {
                while (!stack.isEmpty() && num[index] < stack.peek()) {
                    stack.pop();
                }
                int lastIndex = num.length - 1 - stack.size();
                int temp = num[index];
                num[index] = num[lastIndex];
                num[lastIndex] = temp;
                Arrays.sort(num, index + 1, num.length - 1);
                return;
            }
        }
    }
}
package leetcode.easy;

public class Q204 {
}

class Q204Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        int counter = 0;
        for (int curr = 2; curr < n; curr++) {
            if (!notPrime[curr]) {
                counter++;
            }
            for (int time = 2; time * curr < n; time++) {
                notPrime[time * curr] = true;
            }
        }
        return counter;
    }
}
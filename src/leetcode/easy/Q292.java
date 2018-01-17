package leetcode.easy;

public class Q292 {
}

class Q292Solution {
    //ok let's do it in dp way
    //let's say we have 1, 2, 3 stones on table, so you will win. but when you have 4, you lose, because no matter how many stones you move,
    //next player will be facing 1, 2, 3 stones.
    //so, let's say f[i] stands for when there are i stones on table, the current player will win : true, false : lose
    //so f[i] is true if one of f[i - 1]  f[i - 2]  f[i - 3] is false.
    //unfortunately, TLE.
    public boolean canWinNim(int n) {
        if (n < 4) {
            return true;
        }
        boolean[] willWin = new boolean[n + 1];
        willWin[0] = false;
        willWin[1] = true;
        willWin[2] = true;
        willWin[3] = true;
        for (int stone = 4; stone <= n; stone++) {
            if (!willWin[stone - 1] || !willWin[stone - 2] || !willWin[stone - 3]) {
                willWin[stone] = true;
            }
        }
        return willWin[n];
    }

    public boolean canWinNim2(int n) {
        return n % 4 != 0;
    }
}
package leetcode.medium;

/**
 * Created by cchen on 1/26/18.
 */
public class Q547 {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int n = M.length, circles = n;
        int[] groupLeader = new int[n];
        for (int index = 0; index < n; index++) {
            groupLeader[index] = index;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    int iLeader = findLeader(groupLeader, i), jLeader = findLeader(groupLeader, j);
                    if (iLeader != jLeader) {
                        circles--;
                    }
                    groupLeader[iLeader] = groupLeader[jLeader];
                }
            }
        }
        return circles;
    }

    private int findLeader(int[] groupLeader, int a) {
        if (a == groupLeader[a]) {
            return a;
        }
        groupLeader[a] = findLeader(groupLeader, groupLeader[a]);
        return groupLeader[a];
    }
}

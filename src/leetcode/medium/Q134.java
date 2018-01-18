package leetcode.medium;

public class Q134 {
}

class Q134Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //enumerating start index to see if we can return back to original point
        for (int start = 0; start < gas.length; start++) {
            int tank = gas[start];
            int currStation = start;
            while (tank >= cost[currStation]) {
                tank -= cost[currStation];
                currStation++;
                if (currStation == gas.length) {
                    currStation = 0;
                }
                tank += gas[currStation];
                if (currStation == start) {
                    return start;
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int index = -1;

        for(int i = 0; i<gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0) {
                index = i;
                sum = 0;
            }
        }
        return total < 0 ? -1 : index + 1;
        // index should be updated here for cases ([5], [4]);
        // total < 0 is for case [2], [2]
    }
}
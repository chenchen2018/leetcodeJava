package leetcode.medium;

/**
 * Created by chen on 1/3/18.
 */
public class Q59 {
}

class Q59Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        int[][] res = new int[n][n];
        int rowIndex = 0, colIndex = 0;
        int rowStartIndex = 0, rowEndIndex = n - 1;
        int num = 1;
        while (rowStartIndex < rowEndIndex) {
            //first go to right
            while (colIndex < rowEndIndex) {
                res[rowIndex][colIndex] = num++;
                colIndex++;
            }
            //then go down
            while (rowIndex < rowEndIndex) {
                res[rowIndex][colIndex] = num++;
                rowIndex++;
            }
            //then go left
            while (colIndex > rowStartIndex) {
                res[rowIndex][colIndex] = num++;
                colIndex--;
            }
            //go up
            while (rowIndex > rowStartIndex) {
                res[rowIndex][colIndex] = num++;
                rowIndex--;
            }
            rowIndex++;
            colIndex++;
            rowStartIndex++;
            rowEndIndex--;
        }
        if (rowStartIndex == rowEndIndex) {
            res[rowIndex][colIndex] = num;
        }
        return res;
    }
}
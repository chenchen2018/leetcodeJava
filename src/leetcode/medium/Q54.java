package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 1/1/18.
 */
public class Q54 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Q54Solution().spiralOrder(matrix);
    }
}

class Q54Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rowLowerLimit = 0, rowUpperLimit = matrix.length - 1;
        int colLowerLimit = 0, colUpperLimit = matrix[0].length - 1;
        int rowIndex, colIndex;
        while (rowLowerLimit < rowUpperLimit && colLowerLimit < colUpperLimit) {
            rowIndex = rowLowerLimit;
            colIndex = colLowerLimit;
            //first go right
            while (colIndex < colUpperLimit) {
                res.add(matrix[rowIndex][colIndex++]);
            }
            //second go down
            while (rowIndex < rowUpperLimit) {
                res.add(matrix[rowIndex++][colIndex]);
            }
            //third to left
            while (colIndex > colLowerLimit) {
                res.add(matrix[rowIndex][colIndex--]);
            }
            //last go up
            while (rowIndex > rowLowerLimit) {
                res.add(matrix[rowIndex--][colIndex]);
            }
            rowLowerLimit++;
            rowUpperLimit--;
            colLowerLimit++;
            colUpperLimit--;
        }
        if (rowLowerLimit == rowUpperLimit) {
            //only one col left
            while (colLowerLimit <= colUpperLimit) {
                res.add(matrix[rowLowerLimit][colLowerLimit++]);
            }
        } else if (colLowerLimit == colUpperLimit){
            //only one row left
            while (rowLowerLimit <= rowUpperLimit) {
                res.add(matrix[rowLowerLimit++][colLowerLimit]);
            }
        }
        return res;
    }
}
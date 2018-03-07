package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchen on 3/7/18.
 */
public class Q339 {
}

class Q339Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger ni: list) {
            if (ni.isInteger()) {
                sum += depth * ni.getInteger();
            } else {
                sum += helper(ni.getList(), depth + 1);
            }
        }
        return sum;
    }

    public int depthSumIteration(List<NestedInteger> nestedList) {
        int depth = 1, sum = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> next = new ArrayList<>();
            for (NestedInteger ni: nestedList) {
                if (ni.isInteger()) {
                    sum += depth * ni.getInteger();
                } else {
                    next.addAll(ni.getList());
                }
            }
            depth++;
            nestedList = next;
        }
        return sum;
    }
}

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public void setInteger(int value);
    public void add(NestedInteger ni);
    public List<NestedInteger> getList();
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
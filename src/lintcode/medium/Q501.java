package lintcode.medium;

import java.util.*;

public class Q501 {
    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        set.add(new int[]{0, 0});
        int[] array = {0, 0};
        System.out.println(set.contains(array));
    }
}

class Q501Solution {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        });
        Set<int[]> set = new HashSet<>();
        int[] origin = {0, 0};
        pq.offer(new Element(origin, matrix[0][0]));
        set.add(origin);

        int[] dx = {0, 1}, dy = {1, 0};
        int step = 1;

        while (step < k) {
            Element element = pq.poll();
            int currX = element.position[0], currY = element.position[1];
            for (int i = 0; i < dx.length; i++) {
                int newX = currX + dx[i], newY = currY + dy[i];
                if (inBound(matrix, newX, newY)) {
                    int[] newPosition = {newX, newY};
                    if (!set.contains(newPosition)) {
                        set.add(newPosition);
                        Element nextElement = new Element(newPosition, matrix[newX][newY]);
                        pq.offer(nextElement);
                    }
                }
            }
            step++;
        }
        return pq.poll().val;
    }

    class Element {
        int[] position;
        int val;

        public Element(int[] position, int val) {
            this.position = position;
            this.val = val;
        }
    }

    private boolean inBound(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return false;
        }
        return true;
    }
}

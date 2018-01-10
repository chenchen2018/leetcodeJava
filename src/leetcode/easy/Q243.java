package leetcode.easy;

public class Q243 {
}

class Q243Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Index = -1, word2Index = -1;
        int res = Integer.MAX_VALUE;
        for (int index = 0; index < words.length; index++) {
            if (words[index].equals(word1)) {
                word1Index = index;
                if (word2Index != -1) {
                    res = Math.min(res, word1Index - word2Index);
                }
            } else if (words[index].equals(word2)) {
                word2Index = index;
                if (word1Index != -1) {
                    res = Math.min(res, word2Index - word1Index);
                }
            }
        }
        return res;
    }
}
package leetcode.medium;

import java.util.List;

public class Q127 {
}

//unfortunately, this will be TLE.
class Q127Solution {
    int res;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        res = Integer.MAX_VALUE;
        boolean[] visited = new boolean[wordList.size()];
        helper(beginWord, endWord, wordList, visited, 1);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private void helper(String beginWord, String endWord, List<String> wordList, boolean[] visited, int currLength) {
        for (int index = 0; index < wordList.size(); index++) {
            if (!visited[index] && oneCharacterDifferent(beginWord, wordList.get(index))) {
                if (wordList.get(index).equals(endWord)) {
                    res = Math.min(res, currLength + 1);
                    break;
                }
                visited[index] = true;
                helper(wordList.get(index), endWord, wordList, visited, currLength + 1);
                visited[index] = false;
            }
        }
    }

    private boolean oneCharacterDifferent(String word1, String word2) {
        boolean hasDiff = false;
        for (int index = 0; index < word1.length(); index++) {
            if (word1.charAt(index) != word2.charAt(index)) {
                if (hasDiff) {
                    return false;
                }
                hasDiff = true;
            }
        }
        return hasDiff;
    }
}
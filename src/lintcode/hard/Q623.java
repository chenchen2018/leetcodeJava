package lintcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchen on 2/3/18.
 */
public class Q623 {
    public static void main(String[] args) {
        String[] input = {"abc", "abd", "abcd", "adc"};
        List<String> res = new Q623Solution().kDistance(input, "ac", 1);
        res.stream().forEach(System.out::println);
    }
}

class Q623Solution {
    char[] target;
    int n, K;
    List<String> res = null;
    int[] f;

    public List<String> kDistance(String[] words, String targetStr, int k) {
        target = targetStr.toCharArray();
        n = target.length;
        K = k;
        res = new ArrayList<>();

        //init trie
        //root
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode.insertWord(root, word);
        }
        //init f
        //f[""][0 - n]
        f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = i;
        }
        //dfs
        dfs(root, f);
        //return result
        return res;
    }

    //at node p, prefix Sp
    //f now means f[sp][0 - n]
    //to do: Sp --> (Sp, 'a') ..., (Sp, 'z')
    private void dfs(TrieNode node, int[] f) {
        int[] nf = new int[n + 1];
        if (node.hasWord) {
            if (f[n] <= K) {
                res.add(node.word);
            }
        }
        int i, j, c;
        for (i = 0; i < 26; i++) {
            if (node.sons[i] == null) {
                continue;
            }
            nf[0] = f[0] + 1;
            for (j = 1; j <= n; j++) {
                nf[j] = Math.min(Math.min(nf[j - 1] + 1, f[j] + 1), f[j - 1] + 1);
                c = target[j - 1] - 'a';
                if (c == i) {
                    nf[j] = Math.min(nf[j], f[j - 1]);
                }
            }
            dfs(node.sons[i], nf);
        }
    }
}

class TrieNode {
    TrieNode[] sons;
    String word;
    boolean hasWord;

    public TrieNode() {
        sons = new TrieNode[26];
    }

    public static void insertWord(TrieNode root, String string) {
        for (char c : string.toCharArray()) {
            int index = c - 'a';
            if (root.sons[index] == null) {
                root.sons[index] = new TrieNode();
            }
            root = root.sons[index];
        }
        root.hasWord = true;
        root.word = string;
    }
}
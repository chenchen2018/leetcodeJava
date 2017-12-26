//package leetcode.medium;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Q208 {
//
//}
//
//class Trie {
//    TrieNode root;
//    /** Initialize your data structure here. */
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        TrieNode curr = root;
//        for (int index = 0; index < word.length(); index++) {
//            char c = word.charAt(index);
//            if (!curr.children.containsKey(c)) {
//                curr.children.put(c, new TrieNode());
//            }
//            curr = curr.children.get(c);
//        }
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        return getLastNode(word) != null;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        return getLastNode(prefix) != null;
//    }
//
//    private TrieNode getLastNode(String input) {
//        TrieNode curr = root;
//        for (int index = 0; index < input.length(); index++) {
//            char c = input.charAt(index);
//            if (!curr.children.containsKey(c)) {
//                return null;
//            }
//            curr = curr.children.get(c);
//        }
//        return curr;
//    }
//}
//
//class TrieNode {
//    Map<Character, TrieNode> children;
//    boolean isWord;
//
//    public TrieNode() {
//        children = new HashMap<>();
//        isWord = false;
//    }
//}
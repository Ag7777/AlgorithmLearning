package com.hjx.leetcodeStart;

public class Leetcode208 {

}
class TrieNode{
    TrieNode[] children;
    boolean hasWord;
    TrieNode(){
        children = new TrieNode[26];
        hasWord = false;
    }

    public void insert(String word, int index){
        if(index == word.length()){
            this.hasWord = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if(children[pos] == null){
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }

    public TrieNode find(String word, int index){
        if(index == word.length()){
            return this;
        }
        int pos = word.charAt(index) - 'a';
        if(children[pos] == null){
            return null;
        }
        return children[pos].find(word, index + 1);
    }
}

class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return (node != null && node.hasWord);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null;
    }
}
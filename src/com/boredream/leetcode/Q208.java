package com.boredream.leetcode;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
public class Q208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));// 返回 True
        System.out.println(trie.search("app"));// 返回 False
        System.out.println(trie.startsWith("app"));// 返回 True
        trie.insert("app");
        System.out.println(trie.search("app")); // 返回 True
    }

    static class Trie {

        class TrieNode {
            char value;
            TrieNode[] children;
            boolean isEnd;
        }

        private TrieNode root;

        // 思路：每个字母一层，保存在hash结构里，方便O1获取
        // 直接hash套hash不行，不知道几层。所以用链表。O1 get？ 每个节点每一层再维护一个Hash表

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if(node.children == null) {
                    node.children = new TrieNode[26];
                }
                if(node.children[index] == null) {
                    node.children[index] = new TrieNode();
                    node.children[index].value = c;
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        private TrieNode getMatchNode(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if(node.children == null) {
                    return null;
                }
                if(node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

        public boolean startsWith(String prefix) {
            return getMatchNode(prefix) != null;
        }

        public boolean search(String word) {
            // node.children == null 判断不行，可能插入了多次单词，apple + app，对于app如果按这个条件是获取不到的，所以要给node达标
            TrieNode node = getMatchNode(word);
            return node != null && node.isEnd;
        }
    }

}

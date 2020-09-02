package com.boredream.leetcode.lean;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/trie
 */
public class TrieTest {

    public static void main(String[] args) {
        MapSum sum = new MapSum();

        sum.insert("apple", 3);
        System.out.println(sum.sum("ap"));
        sum.insert("app", 2);
        System.out.println(sum.sum("ap"));
    }

    public static class Trie {

        public static class Node {
            public boolean isWord;
            public char c;
            public List<Node> children;

            public Node(char c) {
                this.c = c;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return c == node.c;
            }

            @Override
            public int hashCode() {
                return Objects.hash(c);
            }
        }

        private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node(' ');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word == null) return;

            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                // 每层遍历，找不到就新增
                char c = word.charAt(i);
                Node next = null;
                if (node.children != null) {
                    // TODO: 2020/9/2 children 用hash map更好
                    for (Node child : node.children) {
                        if(child.c == c) {
                            next = child;
                            break;
                        }
                    }
                }

                if(next == null) {
                    if(node.children == null) {
                        node.children = new ArrayList<>();
                    }
                    next = new Node(c);
                    node.children.add(next);
                }

                if(i == word.length() - 1) {
                    next.isWord = true;
                }
                node = next;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return search(word, false);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return search(prefix, true);
        }

        private boolean search(String word, boolean isPrefix) {
            if(word == null) return false;

            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Node next = null;
                if (node.children != null) {
                    for (Node child : node.children) {
                        if(child.c == c) {
                            next = child;
                            break;
                        }
                    }
                }

                if(next == null) {
                    return false;
                }

                if(isPrefix) {
                    if(i >= word.length() - 1) {
                        return true;
                    }
                } else {
                    if (next.isWord && i == word.length() - 1) {
                        return true;
                    }
                }

                node = next;
            }
            return false;
        }
    }

    public static class MapSum {

        public static class TrieNode {
            Map<Character, TrieNode> children = new HashMap();
            int count;
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            if(key == null) return;
            TrieNode node = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                TrieNode next = node.children.getOrDefault(c, new TrieNode());
                next.count += val;
                node.children.put(c, next);
                node = next;
            }
        }

        public int sum(String prefix) {
            if(prefix == null) return 0;
            TrieNode node = root;
            int count = Integer.MAX_VALUE;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                TrieNode next = node.children.get(c);
                if(next == null) return 0;
                count = Math.min(count, next.count);
                node = next;
            }
            return count;
        }
    }

}

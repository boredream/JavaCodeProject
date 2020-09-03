package com.boredream.leetcode.lean;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/trie
 */
public class TrieTest {

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String[] words = {"cdba"};
        System.out.println(new TrieTest().findWords(board, words));
    }

    public static class Trie {

        public static class Node {
            public String word;
            public boolean isWord;
            public char c;
            public Map<Character, Node> children = new HashMap<>();

            public Node(char c) {
                this.c = c;
            }
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node(' ');
        }

        public void insert(String word) {
            if (word == null) return;
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Node next = node.children.getOrDefault(c, new Node(c));
                node.children.put(c, next);
                node = next;
            }
            node.isWord = true;
            node.word = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return search(word, false);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return search(prefix, true);
        }

        private boolean search(String word, boolean isPrefix) {
            if (word == null) return false;

            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Node next = node.children.get(c);

                if (next == null) {
                    return false;
                }

                if (isPrefix) {
                    if (i >= word.length() - 1) {
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

        public String getPrefix(String word) {
            if (word == null) return null;

            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Node next = node.children.get(c);

                if (next == null) {
                    return null;
                }

                if (next.isWord) {
                    return next.word;
                }
                node = next;
            }
            return null;
        }
    }

    public static class MapSum {

        public static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            int count;
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            if (key == null) return;
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
            if (prefix == null) return 0;
            TrieNode node = root;
            int count = Integer.MAX_VALUE;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                TrieNode next = node.children.get(c);
                if (next == null) return 0;
                count = Math.min(count, next.count);
                node = next;
            }
            return count;
        }
    }

    // dict里是词根，将句子里所有单词替换为对应的词根
    public String replaceWords(List<String> dictionary, String sentence) {
        if (sentence == null || sentence.length() == 0) return sentence;
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : sentence.split(" ")) {
            sb.append(' ');
            if (trie.getPrefix(s) != null) {
                sb.append(trie.getPrefix(s));
            } else {
                sb.append(s);
            }
        }
        return sb.substring(1);
    }

    // insert和字典树没区别，search时，支持.通配符
    static class WordDictionary {

        Trie.Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Trie.Node(' ');
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            if (word == null) return;
            Trie.Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie.Node next = node.children.get(c);
                if (next == null) {
                    next = new Trie.Node(c);
                    node.children.put(c, next);
                }
                node = next;
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            if (word == null) return false;
            Queue<Trie.Node> queue = new LinkedList<>();
            queue.add(root);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    if (c == '.') {
                        // 通配符，这一层所有字符都作为备选项
                        Trie.Node poll = queue.poll();
                        queue.addAll(poll.children.values());
                    } else {
                        // 字符，所有备选项都进行单词校验
                        Trie.Node poll = queue.poll();
                        Trie.Node next = poll.children.get(c);
                        if (next != null) {
                            queue.add(next);
                        }
                    }
                }

                if (queue.isEmpty()) return false;
                if (i == word.length() - 1) {
                    for (Trie.Node node : queue) {
                        if (node.isWord) return true;
                    }
                }
            }
            return false;
        }
    }

    // 2d字符数组中，找贪吃蛇组成的匹配单词
    public List<String> findWords(char[][] board, String[] words) {
        // 字典树保存words，然后board bfs搜索
        List<String> list = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 ||
                words == null || words.length == 0) return list;

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // dfs遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(list, new HashSet<>(), board, i, j, trie.root);
            }
        }
        return list;
    }

    private void dfs(List<String> list, HashSet<String> pass, char[][] board, int i, int j, Trie.Node node) {
        // 边界
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;

        char c = board[i][j];
        Trie.Node next = node.children.get(c);
        // 此路不通
        if(next == null) return;

        // 路线重复
        String rout = "" + i + j;
        if(pass.contains(rout)) return;
        pass.add(rout);

        // 匹配字典树
        if(next.isWord) {
            list.add(next.word);
            // 一次性
            next.isWord = false;
        }

        // 继续向四个方向走
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] ints : dir) {
            dfs(list, pass, board, i + ints[0], j + ints[1], next);
        }
        // TODO: 2020/9/3 思路总体正确，理解错误，应该是dfs，一定要回溯处理。
    }

    // 跳出所有俩单词合并可组成回文字符串的索引对
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        // 第一轮，所有单词反着加入字典树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(new StringBuilder(word).reverse().toString());
        }
        // 第二轮，去字典树立匹配，单词或树消耗完后，剩余部分判断是否是回文。


        return list;
    }


}

package com.boredream.leetcode;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 */
public class Q211 {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));// 返回 False
        System.out.println(wordDictionary.search("bad"));// 返回 True
        System.out.println(wordDictionary.search(".ad"));// 返回 True
        System.out.println(wordDictionary.search("b.."));// 返回 True
    }

    static class WordDictionary {

        // 思路：还是前缀树吗？遇到.怎么处理？或运算 下面所有的节点？
        private WordDictionary[] children;
        private boolean isEnd;

        public WordDictionary() {
            children = new WordDictionary[26];
        }

        public void addWord(String word) {
            WordDictionary node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new WordDictionary();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return search(word, this, 0);
        }

        public boolean search(String word, WordDictionary startNode, int startIndex) {
            WordDictionary node = startNode;
            // TODO: chunyang 2023/9/1 已经拆解了search，递归了，所以可以不用for循环了，直接递归替代for循环
            for (int i = startIndex; i < word.length(); i++) {
                if(node.children == null) {
                    return false;
                }
                char c = word.charAt(i);
                if(c == '.') {
                    // 遍历所有有值的child，任意满足即可？
                    for (int j = 0; j < 26; j++) {
                        if(node.children[j] != null) {
                        }
                    }
                } else {
                    int index = c - 'a';
                    if(node.children[index] == null) {
                        return false;
                    }
                    node = node.children[index];
                }
            }
            return false;
        }
    }


}

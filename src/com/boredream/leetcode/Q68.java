package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 注意:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q68 {
    public static void main(String[] args) {
//        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        System.out.println(fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }

    static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int lineWidth = 0;
        int lineWordCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (lineWordCount > 0) {
                sb.append(" ");
                lineWidth++;
            }
            sb.append(words[i]);
            lineWidth += words[i].length();
            lineWordCount++;

            // 每加一个单词，判断是否满行
            if (i == words.length - 1 || lineWidth + words[i + 1].length() + 1 > maxWidth) {
                // 满了，开始补空格
                int diff = maxWidth - lineWidth;
                if (i == words.length - 1 || lineWordCount == 1) {
                    // 最后一段，空格都放末尾
                    for (int j = 0; j < diff; j++) {
                        sb.append(" ");
                    }
                } else {
                    // 先记录每个间隔的空格数量
                    int spaceCount = diff / (lineWordCount - 1);
                    int moreCount = diff - spaceCount * (lineWordCount - 1);
                    // 从后往前挨个塞
                    int insertSpaceIndex = sb.length();
                    for (int j = 0; j < lineWordCount - 1; j++) {
                        int wordIndex = i - j;
                        insertSpaceIndex -= words[wordIndex].length();
                        if (j > 0) {
                            insertSpaceIndex--;
                        }
                        for (int k = 0; k < spaceCount; k++) {
                            sb.insert(insertSpaceIndex, ' ');
                        }
                        // 4个单词，3个间隔，需要在前moreCount个间隔插入空格
                        // j代表从后往前的间隔索引，所以条件应该是 lineWordCount - 1 - j <= moreCount
                        if (moreCount > 0 && lineWordCount - 1 - j <= moreCount) {
                            // 有额外的，从左到右挨个多加一个
                            sb.insert(insertSpaceIndex, ' ');
                        }
                    }
                }
                list.add(sb.toString());
                sb = new StringBuilder();
                lineWidth = 0;
                lineWordCount = 0;
            }
        }
        // TODO: chunyang 2023/7/20 待优化，应该在append的时候就加入空格，而非加入后回头insert，这样效率会差点（sb底层是数组吧？）
        return list;
    }
}

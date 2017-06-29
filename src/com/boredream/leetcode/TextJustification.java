package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static void main(String[] args) {
        String[] words = {""};
        int maxWidth = 0;
        List<String> strs = fullJustify(words, maxWidth);
        for (String str : strs) {
            System.out.println(str);
        }
    }

    private static StringBuilder sb = new StringBuilder();

    public static List<String> fullJustify(String[] words, int maxWidth) {



        List<String> list = new ArrayList<>();
        for (String word : words) {
            if(word.length() > maxWidth) {
                continue;
            }
            if (sb.length() <= maxWidth - word.length()) {
                sb.append(word).append(" ");
            } else {
                list.add(sb.substring(0, sb.length() - 1));
                sb = new StringBuilder();
                sb.append(word).append(" ");
            }
        }

        if (sb.length() > 0) {
            list.add(sb.substring(0, sb.length() - 1));
        }

        List<String> result = new ArrayList<>();
        for (int index = 0; index < list.size(); index++) {
            String s = list.get(index);

            // content count
            String[] strs = s.split(" ");
            // all space count
            int spaceCount = maxWidth - s.replace(" ", "").length();
            // extra space count
            int extraSpaceCount = 0;
            if (strs.length > 1) {
                extraSpaceCount = spaceCount % (strs.length - 1);
            }

            if (index == list.size() - 1) {
                StringBuilder lastSb = new StringBuilder();
                for (String str : strs) {
                    lastSb.append(str);
                    if (lastSb.length() < maxWidth) {
                        lastSb.append(" ");
                    }
                }

                for (int i = 0; i < maxWidth - lastSb.toString().trim().length() - 1; i++) {
                    lastSb.append(" ");
                }
                result.add(lastSb.toString());
                break;
            }

            if (strs.length == 1) {
                StringBuilder sbSpace = new StringBuilder();
                for (int i = 0; i < maxWidth - s.trim().length(); i++) {
                    sbSpace.append(" ");
                }

                result.add(s.trim() + sbSpace.toString());
            } else if (spaceCount == 0) {
                // no extra space
                StringBuilder sbSpace = new StringBuilder();
                for (int i = 0; i < spaceCount / (strs.length - 1); i++) {
                    sbSpace.append(" ");
                }

                result.add(s.replace(" ", sbSpace.toString()).trim());
            } else {
                // have extra space
                StringBuilder sbSpace = new StringBuilder();
                for (int i = 0; i < spaceCount / (strs.length - 1); i++) {
                    sbSpace.append(" ");
                }

                StringBuilder newSb = new StringBuilder();
                for (String str : strs) {
                    str = str + sbSpace.toString();
                    if (extraSpaceCount > 0) {
                        str += " ";
                        extraSpaceCount--;
                    }
                    newSb.append(str);
                }

                result.add(newSb.toString().trim());
            }
        }

        return result;
    }


}

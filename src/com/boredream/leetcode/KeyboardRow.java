package com.boredream.leetcode;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by lichunyang on 2017/7/17.
 */
public class KeyboardRow {

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = findWords(words);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> charList1 = Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P');
        List<Character> charList2 = Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L');
        List<Character> charList3 = Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M');
        for (Character s : charList1) {
            map.put(s, 1);
        }
        for (Character s : charList2) {
            map.put(s, 2);
        }
        for (Character s : charList3) {
            map.put(s, 3);
        }

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if(word.length() == 0) continue;
            boolean isSingleLine = true;
            for (int i = 0, index = map.get(word.toUpperCase().charAt(0)); i < word.toCharArray().length; i++) {
                if(map.get(word.toUpperCase().charAt(i)) != index) {
                    isSingleLine = false;
                    break;
                }
            }
            if(isSingleLine) result.add(word);
        }
        return result.toArray(new String[result.size()]);
    }

}

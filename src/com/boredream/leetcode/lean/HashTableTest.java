package com.boredream.leetcode.lean;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/hash-table/
 */
public class HashTableTest {

    public static void main(String[] args) {
        System.out.println(new HashTableTest().groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }

    // 自定义hash set
    // All values will be in the range of [0, 1000000].
    // The number of operations will be in the range of [1, 10000].
    static class MyHashSet {

        private LinkedList<Integer>[] nums;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            // 暂时不考虑扩容问题，一步到位
            // 100w范围的数字，落在1w的范围里
            nums = new LinkedList[10000];
        }

        public void add(int key) {
            int hash = hash(key);
            if (nums[hash] == null) {
                nums[hash] = new LinkedList<>();
                nums[hash].add(key);
            } else {
                if (!nums[hash].contains(key)) {
                    nums[hash].add(key);
                }
            }
        }

        public void remove(int key) {
            int hash = hash(key);
            if (nums[hash] != null) {
                nums[hash].remove((Integer) key);
                if (nums[hash].size() == 0) {
                    nums[hash] = null;
                }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int hash = hash(key);
            return nums[hash] != null;
        }

        private int hash(int key) {
            return key % nums.length;
        }
    }

    // 判断重复数字
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }

    // 所有数字都出现2次，只有一个1次，找出
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return set.iterator().next();
    }

    // 唯一交集
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        int length = 0;
        for (Integer i : nums2) {
            if (set.contains(i)) {
                set.remove(i);
                nums1[length++] = i;
            }
        }
        return Arrays.copyOfRange(nums1, 0, length);
    }

    // Input: 19
    // Output: true
    // Explanation:
    // 12 + 92 = 82
    // 82 + 22 = 68
    // 62 + 82 = 100
    // 12 + 02 + 02 = 1
    private HashSet<Integer> map = new HashSet<>();

    public boolean isHappy(int n) {
        // 数字开始循环，则代表无法成为happy num
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum = sum + num * num;
            n = n / 10;
        }
        if (sum == 1) return true;
        if (map.contains(sum)) return false;
        map.add(sum);
        return isHappy(sum);
    }

    // 俩数和是target的索引
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 判断是否是同结构字符串
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapSt = new HashMap<>();
        HashMap<Character, Character> mapTs = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (mapSt.containsKey(sChar) && mapSt.get(sChar) != tChar) {
                return false;
            }
            mapSt.put(sChar, tChar);

            if (mapTs.containsKey(tChar) && mapTs.get(tChar) != sChar) {
                return false;
            }
            mapTs.put(tChar, sChar);
        }
        return true;
    }

    // 寻找俩数组的索引和最小的交集
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> list = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = i + map.get(list2[i]);
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    list.clear();
                    list.add(list2[i]);
                } else if (indexSum == minIndexSum) {
                    list.add(list2[i]);
                }
            }
        }

        return list.size() == 0 ? null : list.toArray(new String[list.size()]);
    }

    // 第一个非重复字符
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // 完整交集
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        int length = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) >= 1) {
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
                nums1[length++] = nums2[i];
            }
        }
        return Arrays.copyOfRange(nums1, 0, length);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        // What if the given array is already sorted? How would you optimize your algorithm?
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 双指针
        int length = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                nums1[length++] = nums2[index2];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, length);
    }

    // 重复数字index差值>=k
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Integer minDistance = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer old = map.get(nums[i]);
            if (old != null) {
                // duplicate
                int distance = Math.abs(i - old);
                if (minDistance == null || distance < minDistance) {
                    minDistance = distance;
                }
            }
            map.put(nums[i], i);
        }
        return minDistance != null && minDistance <= k;
    }

    // 字母相同的放一组，无视顺序
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        // 自定义hash，因为都是小写字母，直接模拟
        List<String>[] map = new List[26 * 26];
        for (String str : strs) {
            int hash = 0;
            for (int i = 0; i < str.length(); i++) {
                hash += Math.pow(26, i) + (str.charAt(i) - 'a');
            }
            if(map[hash] == null) {
                map[hash] = new LinkedList<>();
                list.add(map[hash]);
            }
            map[hash].add(str);
        }
        return list;
        // TODO: 2020/8/18 Math.pow(26, i) 才是map的容量，太大了。
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        // 自定义hash，因为都是小写字母，直接模拟
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            String hash = String.valueOf(chars);
            List<String> group = map.get(hash);
            if(group == null) {
                group = new LinkedList<>();
                map.put(hash, group);
                list.add(group);
            }
            group.add(str);
        }
        return list;
        // TODO: 2020/8/18 Math.pow(26, i) 才是map的容量，太大了。
    }

}

package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insert-delete-getrandom-o1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO
 */
public class Q380 {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println();
        System.out.println(randomizedSet.insert(1)); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println(randomizedSet.remove(2)); // 返回 false ，表示集合中不存在 2 。
        System.out.println(randomizedSet.insert(2)); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(randomizedSet.getRandom()); // getRandom 应随机返回 1 或 2 。
        System.out.println(randomizedSet.remove(1)); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        System.out.println(randomizedSet.insert(2)); // 2 已在集合中，所以返回 false 。
        System.out.println(randomizedSet.getRandom()); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。

        // 时间复杂度要O1
        // Set数据唯一，且要支持O1的读写，所以底层一定要数组
        // 数字范围所有int，那数组大小？

        // 思路：参考官方
        // 不用int[]固定的，使用ArrayList可变长度数组。由于没有要求 getByIndex，所以index无所谓，可以每次都插入到末尾。
        // 但是要get O1，可以再~借助一个HashMap，即同一个数字在arrayList和HashMap里都存一份，前者用于random读，后者用于单个读写
        // 难点在于删除，删除HashMap的同时，也删除了ArrayList中间某个数字，后面的都往前挪？这样就On了，因为不在乎index，所以可以删除后把末尾数字挪到删除位置

    }

    static class RandomizedSet {

        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int lastNum = list.get(list.size() - 1);
            list.set(index, lastNum);
            list.remove(list.size() - 1);
            map.put(lastNum, index);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }

}

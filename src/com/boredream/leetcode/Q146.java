package com.boredream.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class Q146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 2);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }

    static class LRUCache {
        // 思路：O1的读写，需要hash
        // LRU 规则，代表有顺序，但只在乎头尾，当get时，数据被提到头；当push时，如果超过容量则删除尾，可以使用链表
        // 难点：map可以快速get到，但是如何把链表里的数据提到head呢？
        private HashMap<Integer, Integer> kvMap = new HashMap<>();
        private LinkedList<Integer> keyList = new LinkedList<>();
        private int capacity;
        private HashMap<Integer, Integer> needDeleteKeyCount = new HashMap<>();
        private int totalNeedDeleteKeyCount = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            // 当取的时候，直接返回
            Integer value = kvMap.get(key);
            // 直接往头部插入新的值，然后记录这个待删除的值信息。因为之前的key在链表中间，无法直接删除
            keyList.addFirst(key);
            recordNeedDeleteKey(key);
            return value != null ? value : -1;
        }

        private void recordNeedDeleteKey(int key) {
            needDeleteKeyCount.put(key, needDeleteKeyCount.getOrDefault(key, 0) + 1);
            totalNeedDeleteKeyCount++;
        }

        public void put(int key, int value) {
            if (kvMap.containsKey(key)) {
                recordNeedDeleteKey(key);
            }
            kvMap.put(key, value);
            keyList.addFirst(key);

            // 每次添加完，都尝试删除末尾待删除的部分
            while (totalNeedDeleteKeyCount > 0) {
                Integer count = needDeleteKeyCount.get(keyList.getLast());
                if (count != null) {
                    if (count == 1) {
                        needDeleteKeyCount.remove(keyList.getLast());
                    } else {
                        needDeleteKeyCount.put(keyList.getLast(), count - 1);
                    }
                    keyList.removeLast();
                    totalNeedDeleteKeyCount--;
                } else {
                    break;
                }
            }

            if (keyList.size() > capacity + totalNeedDeleteKeyCount) {
                kvMap.remove(keyList.getLast());
                keyList.removeLast();
            }
        }
    }

    // TODO: chunyang 2023/8/9 双链表

}

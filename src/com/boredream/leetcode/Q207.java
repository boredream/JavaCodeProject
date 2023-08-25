package com.boredream.leetcode;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * <p>
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class Q207 {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{
                {1,0},
        };
        System.out.println(canFinish(2, prerequisites));
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 思路：拓扑问题。有序图。如果有些节点连成了一个循环的图，则代表不可能。如果没有循环则有可能，且还要记录是否达到numCourses
        // 先记录有序图，不一定非要用node链表，可以用 数组套数组表示，一层的索引代表当前课程值，二层列表代表指向的邻居
        List<List<Integer>> edges = new ArrayList<>();
        // 图节点入度，代表指向某个节点的数量
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // 按目标课程总数创建图，最终这个图上所有节点都正常访问，则代表ok
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            // 学习课程 index0 之前，你需要完成课程 index1，后者是前者的前置，所以1指向0
            edges.get(pre[1]).add(pre[0]);
            indeg[pre[0]] ++;
        }

        // queue wfs
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0) {
                // 无入度的节点，代表是整个拓扑结构的起点
                queue.offer(i);
            }
        }

        int visited = 0;
        while(!queue.isEmpty()) {
            // 先出栈前置节点，然后记录访问数+1
            visited ++;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                // 前置节点出栈后，所有指向的节点入度数-1
                indeg[v] --;
                if(indeg[v] == 0) {
                    // 指向节点入度数到0时，代表下一轮时，这些节点就是新的拓扑起点了
                    queue.offer(v);
                }
            }
        }
        // 整个遍历结束，如果有多个节点是互相指向形成循环的，则不会出现入度减到0的情况，因此也不会记录访问数
        // 因此访问数代表是无循环可访问的所有节点数量
        return visited >= numCourses;
    }

}

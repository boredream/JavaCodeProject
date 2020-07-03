package com.boredream.algorithms.base.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BFS 广度优先搜索 - 寻找路径
 */
public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }

    }

    public boolean hasPathTo(int v) {
        return marked[v]; // 只要是到达过的点，代表可以有路径过去
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != this.s; x = edgeTo[x]) {
            // edgeTo[当前结点] = 连接到当前结点的上一个结点
            // 所以 x = edgeTo[x] 代表去找到指向当前节点的上一个点，依次循环往回找到起点停止
            path.push(x);
        }
        path.push(this.s);
        return path;
    }

    public static void main(String[] args) {
        Graph g = Graph.create();

        BreadthFirstPaths search = new BreadthFirstPaths(g, 0);
        System.out.println(search.pathTo(3));
    }

}

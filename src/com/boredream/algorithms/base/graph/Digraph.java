package com.boredream.algorithms.base.graph;

import java.util.LinkedList;

/**
 * 有向图
 */
public class Digraph {

    private final int V; // 顶点数量
    private int E; // 边数量
    private LinkedList<Integer>[] adj; // 相邻连接信息

    public Digraph(int v) {
        this.V = v;
        this.E = 0;

        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) { // 添加一个v连接w的边
        adj[v].add(w); // v的连接信息里新增一个w
        // 这里和无向图不同，单向的
        // adj[w].add(v); // 反过来一样
        E++;
    }

    public LinkedList<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w = 0; w < adj(v).size(); w++) {
                // 遍历所有的点的关联图，然后反过来添加到新图里
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public static Digraph create() {
        Digraph g = new Digraph(7);
        g.addEdge(0, 5);
        g.addEdge(0, 1);
        g.addEdge(0, 6);
        g.addEdge(6, 4);
        g.addEdge(5, 4);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        return g;
    }

    public static Digraph createHasCycle() {
        Digraph g = create();
        g.addEdge(4, 3);
        return g;
    }
}

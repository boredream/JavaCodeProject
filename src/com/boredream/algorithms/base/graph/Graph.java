package com.boredream.algorithms.base.graph;

import java.util.LinkedList;

/**
 * 图
 */
public class Graph {

    private final int V; // 顶点数量
    private int E; // 边数量
    private LinkedList<Integer>[] adj; // 相邻连接信息

    public Graph(int v) {
        this.V = v;
        this.E = 0;

        adj = new LinkedList[V]; // 算法4书里其实用的是Bag对象，只能add不能get的一个可重复、无序、可遍历集合
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
        adj[w].add(v); // 反过来一样
        E++;
    }

    public LinkedList<Integer> adj(int v) {
        return adj[v];
    }

    public static Graph create() {
        Graph g = new Graph(6);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.addEdge(5, 3);
        return g;
    }
}

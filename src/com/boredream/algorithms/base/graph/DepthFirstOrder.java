package com.boredream.algorithms.base.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * DFS 排序
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre; // 前序
    private Queue<Integer> post; // 后序
    private Stack<Integer> reversePost; // 逆后序

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        pre.offer(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
        post.offer(v);
        reversePost.push(v);
    }

    public Queue<Integer> pre() {
        return pre;
    }

    public Queue<Integer> post() {
        return post;
    }

    public Stack<Integer> reversePost() {
        return reversePost;
    }
}

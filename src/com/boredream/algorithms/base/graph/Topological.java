package com.boredream.algorithms.base.graph;

/**
 * 拓扑排序
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle dc = new DirectedCycle(G);
        if (!dc.hasCycle()) {
            // 有序图无环时才能拓扑排序
            DepthFirstOrder dfo = new DepthFirstOrder(G);
            order = dfo.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(13);
        g.addEdge(0, 5);
        g.addEdge(0, 1);
        g.addEdge(0, 6);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 4);
        g.addEdge(6, 4);
        g.addEdge(6, 9);
        g.addEdge(9, 10);
        g.addEdge(9, 11);
        g.addEdge(11, 12);
        g.addEdge(9, 12);
        g.addEdge(8, 7);
        g.addEdge(7, 6);

        Topological topological = new Topological(g);
        System.out.println(topological.order);
    }
}

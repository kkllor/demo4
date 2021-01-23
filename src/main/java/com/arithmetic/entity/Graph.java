package com.arithmetic.entity;

import java.util.LinkedList;

/**
 * @author kkllor
 * @date 2021/1/23 8:22 PM
 */
public class Graph {
    private int v;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public int getV() {
        return v;
    }
}

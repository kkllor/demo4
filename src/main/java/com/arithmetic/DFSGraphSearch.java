package com.arithmetic;

import com.arithmetic.entity.Graph;

import java.util.*;

/**
 * @author kkllor
 * @date 2021/1/23 8:26 PM
 */
public class DFSGraphSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 4);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 8);
        graph.addEdge(6, 7);
        graph.addEdge(5, 2);
        graph.addEdge(5, 9);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        System.out.println(dfs(graph, 4, 2));
    }

    public static Set<Integer> dfs(Graph graph, int index, int degree) {
        Set<Integer> set = new HashSet<>();
        _dfs(graph, set, index, degree, 0);
        return set;
    }

    public static void _dfs(Graph graph, Set<Integer> set, int index, int degree, int currentDegree) {
        if (currentDegree > degree) {
            return;
        }
        if (set.contains(index)) {
            return;
        }
        set.add(index);
        LinkedList<Integer> adj = graph.getAdj()[index];
        for (int t : adj) {
            _dfs(graph, set, t, degree, currentDegree + 1);
        }
    }
}

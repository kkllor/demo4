package com.arithmetic;

import com.arithmetic.entity.Graph;

import java.util.*;

/**
 * @author kkllor
 * @date 2021/1/23 8:26 PM
 */
public class DFSGraphSearch1 {
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
        System.out.println(dfs(graph, 4, 1));
    }

    public static Set<Integer> dfs(Graph graph, int index, int degree) {
        HashMap<Integer, Integer> degreeMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        degreeMap.put(index, 0);
        while (!stack.isEmpty()) {
            int s = stack.pop();
            if (set.contains(s)) {
                continue;
            }
            int d = degreeMap.get(s);
            if (d > degree) {
                continue;
            }
            set.add(s);
            LinkedList<Integer> adj = graph.getAdj()[s];
            for (int t : adj) {
                stack.push(t);
                degreeMap.put(t, d + 1);
            }
        }
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

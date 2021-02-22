package com.arithmetic;

import com.arithmetic.entity.Graph;

import java.util.*;

/**
 * @author kkllor
 * @date 2021/1/23 8:26 PM
 */
public class BFSGraphSearch {
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
        System.out.println(bfs(graph, 4, 1));
    }

    public static Set<Integer> bfs(Graph graph, int index, int degree) {
        HashMap<Integer, Integer> degreeMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        if (graph.getV() == 0) {
            return set;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        degreeMap.put(index, 0);
        while (!queue.isEmpty()) {
            int s = queue.poll();
            set.add(s);
            LinkedList<Integer> adj = graph.getAdj()[s];
            int d = degreeMap.get(s);
            if (d >= degree) {
                continue;
            }
            for (int t : adj) {
                if (!set.contains(t)) {
                    queue.add(t);
                    degreeMap.put(t, d + 1);
                }
            }
        }
        return set;
    }
}

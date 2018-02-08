package com.HackerRank.CrackingTheCodingChapter;

import java.util.*;

/**
 * Created by yanli on 2016-10-18.
 */
public class BFSShortestReachInAGraph {
    public static class Graph {
        private Map<Integer, LinkedList<Integer>> idAdjacentListMap = new HashMap<Integer, LinkedList<Integer>>();
        private int size;

        public Graph(int size) {
            idAdjacentListMap.clear();
            this.size = size;
        }

        public void addEdge(int first, int second) {
            addEdgeDirected(first, second);
            addEdgeDirected(second, first);
        }

        private void addEdgeDirected(int first, int second) {
            if (idAdjacentListMap.containsKey(first)) {
                idAdjacentListMap.get(first).add(second);
            } else {
                LinkedList<Integer> integers = new LinkedList<Integer>();
                integers.add(second);
                idAdjacentListMap.put(first, integers);
            }
        }

        public int[] shortestReach(int startId) { // 0 indexed
            System.out.println("startId = " + startId);
//            System.out.println("idAdjacentListMap = " + idAdjacentListMap);
            ArrayDeque<Node> nodesToVisit = new ArrayDeque<Node>(this.size);
            nodesToVisit.addLast(new Node(startId, 0));
            HashSet<Integer> visited = new HashSet<Integer>();
            HashMap<Integer, Integer> distanceMap = new HashMap<Integer, Integer>(this.size);

            // BFS
//            System.out.println("idAdjacentListMap = " + idAdjacentListMap);
            while (!nodesToVisit.isEmpty()) {
                Node parentNode = nodesToVisit.pollFirst();
                if (visited.contains(parentNode.id)) {
                    continue;
                } else {
                    visited.add(parentNode.id);
                }
                distanceMap.put(parentNode.id, parentNode.level * 6);
                if (idAdjacentListMap.containsKey(parentNode.id)) {
                    for (Integer child : idAdjacentListMap.get(parentNode.id)) {
                        nodesToVisit.addLast(new Node(child, parentNode.level + 1));
                    }
                }
//                System.out.println("nodesToVisit = " + nodesToVisit);
            }
//            System.out.println(distanceMap);

            // get ans
            int[] ans = new int[this.size];
            for (int i = 1; i <= this.size; i++) {
                if (i == startId) {
                    continue;
                }
                if (distanceMap.containsKey(i)) {
                    ans[i - 1] = distanceMap.get(i);
                } else {
                    ans[i - 1] = -1;
                }
            }
            return ans;
        }

        private class Node {
            int id;
            int level;

            public Node(int id, int level) {
                this.id = id;
                this.level = level;
            }

            public Node() {

            }

            @Override
            public String toString() {
                return "Node{" +
                        "id=" + id +
                        ", level=" + level +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "GraphUndirected{" +
                    "idAdjacentListMap=" + idAdjacentListMap +
                    ", size=" + size +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            System.out.println(graph);
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();

                // add each edge to the graph
                graph.addEdge(u, v);
                System.out.println(graph);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt();
            int[] distances = graph.shortestReach(startId);

            for (int i = 1; i <= distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i - 1]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}

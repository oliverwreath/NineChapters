package com.aTemplates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * BFS with a queue b
 */
public class BFS_ShortestReachInGraph {
    private final static Logger logger = LoggerFactory.getLogger(BFS_ShortestReachInGraph.class);

    public static void main(String[] args) {
        testBFS_ShortestReachInGraph();
    }

    private static void testBFS_ShortestReachInGraph() {
        BFS_ShortestReachInGraph BFS_ShortestReachInGraph = new BFS_ShortestReachInGraph();
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }

    public static class Graph {
        private HashMap<Integer, Node> nodeLookup = new HashMap<>();
        private int size;

        public Graph(int size) {
            this.size = size;
        }

        public class Node {
            private int id;
            LinkedList<Node> adjacent = new LinkedList<>();

            private Node(int id) {
                this.id = id;
            }
        }

        private Node getNode(int id) {
            if (!nodeLookup.containsKey(id)) {
                nodeLookup.put(id, new Node(id));
            }
            return nodeLookup.get(id);
        }

        public void addEdge(int source, int destination) {
            Node s = getNode(source);
            Node d = getNode(destination);
            s.adjacent.add(d);
            d.adjacent.add(s);
        }

        private class Entry {
            int id;
            int distance;

            public Entry(int id, int distance) {
                this.id = id;
                this.distance = distance;
            }
        }

        public int[] shortestReach(int startId) { // 0 indexed
            // filter abnormal inputs
            if (startId < 0) {
                return new int[0];
            }

            // core logic
            int[] result = new int[this.size];
            for (int i = 0; i < this.size; i++) {
                result[i] = -1;
            }

            Queue<Entry> queue = new LinkedList<>();
            queue.add(new Entry(startId, 0));
            HashSet<Integer> visited = new HashSet<>();
            while (!queue.isEmpty()) {
                Entry currentEntry = queue.poll();
                if (!visited.contains(currentEntry.id)) {
                    visited.add(currentEntry.id);
                    result[currentEntry.id] = currentEntry.distance;
                    for (Node child : getNode(currentEntry.id).adjacent) {
                        queue.add(new Entry(child.id, currentEntry.distance + 6));
                    }
                }
            }

            // wrap up
            return result;
        }

        public boolean hasPathDFS(int source, int destination) {
            Node s = getNode(source);
            Node d = getNode(destination);
            HashSet<Integer> visited = new HashSet<>();
            return hasPathDFS(s, d, visited);
        }

        public boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
            if (visited.contains((source.id))) {
                return false;
            }
            visited.add(source.id);
            if (source == destination) {
                return true;
            }
            for (Node child : source.adjacent) {
                if (hasPathDFS(child, destination, visited)) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasPathBFS(int source, int destination) {
            Node s = getNode(source);
            Node d = getNode(destination);
            return hasPathBFS(s, d);
        }

        public boolean hasPathBFS(Node source, Node destination) {
            LinkedList<Node> nextToVisit = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            nextToVisit.add(source);
            while (!nextToVisit.isEmpty()) {
                Node node = nextToVisit.remove();
                if (node == destination) {
                    return true;
                }

                if (visited.contains(node.id)) {
                    continue;
                }
                visited.add(node.id);
                nextToVisit.addAll(node.adjacent);
            }
            return false;
        }
    }


    /**
     * @param A an array of Integer
     * @return an integer
     */
    int longestIncreasingContinuousSubsequence(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // return the final result
        return -1;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}

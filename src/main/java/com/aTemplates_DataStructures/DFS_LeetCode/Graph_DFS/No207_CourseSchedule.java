package com.aTemplates_DataStructures.DFS_LeetCode.Graph_DFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class No207_CourseSchedule {
    private final static Logger logger = LoggerFactory.getLogger(No207_CourseSchedule.class);

    public static void main(String[] args) {
        testNo207_CourseSchedule();
    }

    private static void testNo207_CourseSchedule() {
        No207_CourseSchedule No207_CourseSchedule = new No207_CourseSchedule();
        MyLogger.info("result True v.s. " + No207_CourseSchedule.canFinish(2, new int[][]{
                {1, 0}
        }));
        MyLogger.info("result False v.s. " + No207_CourseSchedule.canFinish(2, new int[][]{
                {1, 0},
                {0, 1}
        }));
    }

    /**
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // filter abnormal inputs
        if (numCourses < 1) {
            return true;
        }

        // DFS?
        int t = prerequisites.length;
        GraphDirected graph = new GraphDirected(t);
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[0], prerequisite[1]);
        }

        globalVisited.clear();
        for (int id = 0; id < numCourses; id++) {
            localVisited.clear();
//            System.out.println("outer id = " + id);
            boolean isValid = dfsHelper(id, graph);
//            System.out.println(isValid);
            if (!isValid) {
                return false;
            }
        }

        return true;
    }

    public class GraphDirected {
        private HashMap<Integer, Node> nodeLookup = new HashMap<>();
        private int size;

        public GraphDirected(int size) {
            this.size = size;
        }

        public class Node {
            public int id;
            public LinkedList<Node> require = new LinkedList<>();

            private Node(int id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "id=" + id +
                        '}';
            }
        }

        public Node getNode(int id) {
            if (!nodeLookup.containsKey(id)) {
                nodeLookup.put(id, new Node(id));
            }
            return nodeLookup.get(id);
        }

        public void addEdge(int source, int destination) {
            Node s = getNode(source);
            Node d = getNode(destination);
            s.require.add(d);
        }
    }

    private HashSet<Integer> globalVisited = new HashSet<>();
    private HashSet<Integer> localVisited = new HashSet<>();

    private boolean dfsHelper(int id, GraphDirected graph) {
        if (globalVisited.contains(id)) {
            return true;
        }
        GraphDirected.Node currentNode = graph.getNode(id);
        localVisited.add(id);
        globalVisited.add(id);
//        System.out.println("id = " + id);
//        System.out.println("globalVisited = " + globalVisited);
//        System.out.println("localVisited = " + localVisited);
//        System.out.println("currentNode.require = " + currentNode.require);
        for (GraphDirected.Node require : currentNode.require) {
//            System.out.println("localVisited.contains(require.id) = " + localVisited.contains(require.id));
            if (localVisited.contains(require.id)) {
                return false;
            } else {
                boolean isValid = dfsHelper(require.id, graph);
                if (!isValid) {
                    return false;
                }
            }
        }
        localVisited.remove(id);
        return true;
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

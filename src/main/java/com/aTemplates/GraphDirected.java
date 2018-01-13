package com.aTemplates;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
                for (Node child : getNode(currentEntry.id).require) {
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
        for (Node child : source.require) {
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
            nextToVisit.addAll(node.require);
        }
        return false;
    }
}
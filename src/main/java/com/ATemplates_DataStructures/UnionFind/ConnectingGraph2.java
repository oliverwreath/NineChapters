package com.ATemplates_DataStructures.UnionFind;

public class ConnectingGraph2 {
    public static void main(String[] args) {
        ConnectingGraph2 connectingGraph2 = new ConnectingGraph2(5);
        connectingGraph2.query(1);
        connectingGraph2.connect(1, 2);
        connectingGraph2.query(1);
        connectingGraph2.connect(2, 4);
        connectingGraph2.query(1);
        connectingGraph2.connect(1, 4);
        connectingGraph2.query(1);
    }

    /*
     * @param n: An integer
     */
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        L = new int[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            L[i] = i;
            count[i] = 1;
        }
    }

    int[] L;
    int[] count;

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        L[find(a)] = find(b);
        int tmp = count[a];
        count[a] += count[b];
        count[b] += tmp;
    }

    public int find(int a) {
        if (a == L[a]) {
            return a;
        }

        int root = a;
        while (L[root] != root) {
            root = L[root];
        }
        L[a] = root;
        return root;
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        // int root = find(a);
        // int count = 0;
        // for (int i = 1; i <= L.length - 1; i++) {
        //     if (find(i) == root) {
        //         count++;
        //     }
        // }

        // return count;
        return count[a];
    }
}
package com.AdvancedAlgorithms.数据结构上之并查集与字典树;

public class ConnectingGraphII_590 {
    private int[] father;

    /*
     * @param n: An integer
     */
    public ConnectingGraphII_590(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        return find(a) == find(b);
    }

    private int find(int x) {
        if (father[x] == x) {
            return x;
        } else {
            return father[x] = find(father[x]);
        }
    }
}
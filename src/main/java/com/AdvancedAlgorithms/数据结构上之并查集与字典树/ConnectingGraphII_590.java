package com.AdvancedAlgorithms.数据结构上之并查集与字典树;

public class ConnectingGraphII_590 {
    private int[] father;
    private int[] count;

    /*
     * @param n: An integer
     */
    public ConnectingGraphII_590(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
            count[i] = 1;
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
            count[rootB] += count[rootA];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        return count[find(a)];
    }

    private int find(int x) {
        if (father[x] == x) {
            return x;
        } else {
            return father[x] = find(father[x]);
        }
    }
}
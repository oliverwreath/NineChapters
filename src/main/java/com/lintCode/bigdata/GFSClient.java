package com.lintCode.bigdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanli on 9/17/2016.
 */
/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */
public class GFSClient extends BaseGFSClient {
    private int chunkSize;
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public GFSClient(int chunkSize) {
        // initialize your data structure here
        this.chunkSize = chunkSize;
    }

    // @param filename a file name
    // @return conetent of the file given from GFS
    public String read(String filename) {
        // Write your code here
        if (map.containsKey(filename)) {
            int n = map.get(filename);
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                buffer.append(readChunk(filename, i));
            }
            return buffer.toString();
        } else {
            return null;
        }
    }

    // @param filename a file name
    // @param content a string
    // @return void
    public void write(String filename, String content) {
        // Write your code here
        int len = content.length();
        int n = len / 5;
        for (int i = 0; i < n; i++) {
            writeChunk(filename, i, content.substring(i * 5, i * 5 + 5));
        }
        if (len % 5 > 0) {
            writeChunk(filename, n, content.substring(n * 5));
            map.put(filename, n + 1);
        } else {
            map.put(filename, n);
        }
    }
}

class BaseGFSClient {
    private Map<String, String> chunk_list;

    public BaseGFSClient() {
    }

    public String readChunk(String filename, int chunkIndex) {
        // Read a chunk from GFS
        return new String();
    }

    public void writeChunk(String filename, int chunkIndex,
                           String content) {
        // Write a chunk to GFS
        return;
    }
}
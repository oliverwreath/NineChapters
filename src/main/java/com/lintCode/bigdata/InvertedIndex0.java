package com.lintCode.bigdata;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/10/2016.
 */
public class InvertedIndex0 {
    private final static Logger logger = LoggerFactory.getLogger(InvertedIndex0.class);

    public static void main(String[] arg) {
        testInvertedIndex();
    }

    private static void testInvertedIndex() {
        List<Document> docs = new LinkedList<Document>();
        docs.add(new Document(1, "This is the content of document 1 it is very short"));
        docs.add(new Document(2, "This is the content of    document 2 it is very long bilabial bilabial heheh hahaha ..."));
        logger.info("ret = {}", invertedIndex(docs));
    }

    public static Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        if (docs == null || docs.size() == 0) {
            return new HashMap<String, List<Integer>>();
        }

        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        for (Document doc : docs) {
            String[] words = doc.content.trim().split(" ");
            Set<String> setWords = new HashSet<String>(Arrays.asList(words));
            for (String word : setWords) {
                if (!word.equals("")) {
                    if (map.containsKey(word)) {
                        map.get(word).add(doc.id);
                    } else {
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(doc.id);
                        map.put(word, list);
                    }
                }
            }
        }

        return map;
    }
}

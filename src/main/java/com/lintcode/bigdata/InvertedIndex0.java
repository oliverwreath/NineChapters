package com.lintcode.bigdata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class InvertedIndex0 {

  public static void main(String[] arg) {
    testInvertedIndex();
  }

  private static void testInvertedIndex() {
    List<Document> docs = new LinkedList<Document>();
    docs.add(new Document(1, "This is the content of document 1 it is very short"));
    docs.add(
        new Document(2, "This is the content of    document 2 it is very long bilabial bilabial heheh hahaha ..."));
    log.info("ret = {}", invertedIndex(docs));
  }

  public static Map<String, List<Integer>> invertedIndex(List<Document> docs) {

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

package com.NineChapters.TwoPointers.MustHashMap;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lintcode607TwoSumIiiDataStructureDesign {

  public class TwoSum {

    private HashMap<Integer, Boolean> hashMap;

    public TwoSum() {
      hashMap = new HashMap<>();
    }

    /**
     * @param key: An integer
     * @return: nothing
     */
    public void add(int key) {

      hashMap.put(key, hashMap.containsKey(key));
    }

    /**
     * @param sum: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the sum.
     */
    public boolean find(int sum) {
      for (Map.Entry<Integer, Boolean> entry : hashMap.entrySet()) {
        if (hashMap.containsKey(sum - entry.getKey()) && (sum != (entry.getKey() + entry.getKey())
            || entry.getValue())) {
          return true;
        }
      }
      return false;
    }
  }
}

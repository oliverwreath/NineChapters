package com.oliver;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TopK {

  public static void main(String[] args) {
    System.out.println("begin");
//    int[] nums = new int[]{3, 3, 3, 1, 2, 2};
//    List<Object> intByCount1 = Arrays.stream(nums).boxed()
//        .collect(Collectors.groupingBy(a -> a, LinkedHashMap::new, Collectors.counting()))
//        .entrySet().stream().filter(entry -> entry.getValue() > 2)
//        .map(e -> e::getKey)
//        .toList();
//    System.out.println(Arrays.toString(intByCount1));

    List<Integer> list = List.of(1, 2, 2, 3, 3, 3);
    LinkedHashMap<Integer, Long> intByCount2 = list.stream()
        .collect(Collectors.groupingBy(a -> a, LinkedHashMap::new, Collectors.counting()));
    System.out.println(intByCount2);
    System.out.println("end");
  }
}

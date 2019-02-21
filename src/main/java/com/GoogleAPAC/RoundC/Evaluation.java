package com.GoogleAPAC.RoundC;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/18/2016.
 */
public class Evaluation {
    private static final Logger logger = LoggerFactory.getLogger(Evaluation.class);

    public static void main(String[] arg) {
        testEvaluation();
    }

    private static void testEvaluation() {
        long startTime = System.currentTimeMillis();
        evaluation();
        logger.info("time elapsed: {}ms", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    static void evaluation() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            // input
            int N = scan.nextInt();
            Map<String, List<String>> pointMap = new HashMap<String, List<String>>();
            Map<String, Integer> wantedBloodMap = new HashMap<String, Integer>();
            LinkedList<String> knownList = new LinkedList<String>();
            for (int n = 0; n < N; n++) {
                String string = scan.next();
                String left = string.substring(0, string.indexOf("="));
                String right = string.substring(string.indexOf("(") + 1, string.length() - 1);
//                System.out.println(string);
//                System.out.println(left);
//                System.out.println(right);
                if (!right.isEmpty()) {
                    String[] splits = right.split(",");
//                    System.out.println(Arrays.toString(splits));
                    Set<String> set = new HashSet<String>(Arrays.asList(splits));
                    for (String s : set) {
                        if (pointMap.containsKey(s)) {
                            pointMap.get(s).add(left);
                        } else {
                            LinkedList<String> tmpList = new LinkedList<String>();
                            tmpList.add(left);
                            pointMap.put(s, tmpList);
                        }
                    }
                    wantedBloodMap.put(left, set.size());
                } else {
                    knownList.add(left);
                }
            }
//            System.out.println(pointMap);
//            System.out.println(wantedBloodMap);
//            System.out.println(knownList);

            // process
            while (wantedBloodMap.size() > 0 && knownList.size() > 0) {
                if (pointMap.containsKey(knownList.getFirst())) {
                    String first = knownList.getFirst();
                    List<String> list = pointMap.get(first);
                    for (String targeted : list) {
                        if (wantedBloodMap.containsKey(targeted)) {
                            int newBlood = wantedBloodMap.get(targeted) - 1;
                            if (newBlood <= 0) {
                                knownList.addLast(targeted);
                                wantedBloodMap.remove(targeted);
                            } else {
                                wantedBloodMap.put(targeted, newBlood);
                            }
                        }
                    }
                }
                knownList.removeFirst();
            }
//            System.out.println(pointMap);
//            System.out.println(wantedBloodMap);
//            System.out.println(knownList);

            // result
            if (wantedBloodMap.isEmpty()) {
                System.out.format("Case #%d: %s\n", t + 1, "GOOD");
            } else {
                System.out.format("Case #%d: %s\n", t + 1, "BAD");
            }
        }
    }
}

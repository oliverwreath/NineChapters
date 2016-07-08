package com.apac;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.apac.Util.getPrintWriter;

/**
 * Created by yanli_000 on 16/7/8.
 */
public class RobotRockBand {
    private final static Logger logger = LoggerFactory.getLogger(RobotRockBand.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new RobotRockBand().robotRockBand();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public void robotRockBand() {
        Scanner scanner = new Scanner(System.in);
        int numOfCases;
        if (scanner.hasNext()) {
            numOfCases = scanner.nextInt();
            PrintWriter printWriter = getPrintWriter("C:\\Users\\yanli_000\\Desktop\\RobotRockBand.out");

            for (int caseI = 0; caseI < numOfCases; caseI++) {
                int N = scanner.nextInt();
                long K = scanner.nextLong();
                myCountedSet<Long> set1 = new myCountedSet<Long>();
                myCountedSet<Long> set2 = new myCountedSet<Long>();
                myCountedSet<Long> set3 = new myCountedSet<Long>();
                myCountedSet<Long> set4 = new myCountedSet<Long>();
                for (int j = 0; j < N; j++) {
                    set1.add(scanner.nextLong());
                }
                for (int j = 0; j < N; j++) {
                    set2.add(scanner.nextLong());
                }
                for (int j = 0; j < N; j++) {
                    set3.add(scanner.nextLong());
                }
                for (int j = 0; j < N; j++) {
                    set4.add(scanner.nextLong());
                }
                BigInteger xorHitCount = getXORHitCount(set1, set2, set3, set4, K);
                String result = "Case #" + (caseI + 1) + ": " + xorHitCount;
//                System.out.println(result);
                printWriter.println(result);
            }

            printWriter.flush();
        }
    }

    private class myCountedSet<E> implements Iterable<E> {
        Set<E> set = new TreeSet<E>();
        Map<E, Long> map = new HashMap<E, Long>();

        public myCountedSet() {
        }

        public void add(E key) {
            if (set.contains(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                set.add(key);
                map.put(key, 1L);
            }
        }

        public long getCounter(long key) {
            return map.get(key);
        }

        public int size() {
            return set.size();
        }

        public Set<E> getSet() {
            return set;
        }

        public Map<E, Long> getMap() {
            return map;
        }

        public Iterator<E> iterator() {
            return set.iterator();
        }

        @Override
        public String toString() {
            return "myCountedSet{" +
                    "map=" + map +
                    '}';
        }
    }

    private static BigInteger getXORHitCount(myCountedSet<Long> set1, myCountedSet<Long> set2, myCountedSet<Long> set3, myCountedSet<Long> set4, long target) {
        logger.debug("{}", set1);
        logger.debug("{}", set2);
        logger.debug("{}", set3);
        logger.debug("{}", set4);
        logger.info("{}", set1.size());
        logger.info("{}", set2.size());
        logger.info("{}", set3.size());
        logger.info("{}", set4.size());
        long loopSize = (long) set1.size() * set2.size() * set3.size() * set4.size();
        if (loopSize > 16777216) {
            logger.error("loopSize = {} too big!!", loopSize);
            return BigInteger.valueOf(-1);
        }

        BigInteger hitCount = BigInteger.ZERO;
        for (Long aLong1 : set1) {
            for (Long aLong2 : set2) {
                long tmpResult = aLong1 ^ aLong2;
                for (Long aLong3 : set3) {
                    long tmpResult2 = tmpResult ^ aLong3;
                    for (Long aLong4 : set4) {
                        long xorResult = tmpResult2 ^ aLong4;
                        if ((xorResult) == target) {
                            logger.debug("HIT!! {} ^ {} ^ {} ^ {} = {}", aLong1, aLong2, aLong3, aLong4, xorResult);
                            hitCount = hitCount.add(BigInteger.valueOf(set1.getCounter(aLong1)).multiply(BigInteger.valueOf(set2.getCounter(aLong2))).multiply(BigInteger.valueOf(set3.getCounter(aLong3))).multiply(BigInteger.valueOf(set4.getCounter(aLong4))));
                        } else {
                            logger.debug("MISS!! {} ^ {} ^ {} ^ {} = {}", aLong1, aLong2, aLong3, aLong4, xorResult);
                        }
                    }
                }
            }
        }

        logger.info("hit count is {}", hitCount);
        return hitCount;
    }
}
